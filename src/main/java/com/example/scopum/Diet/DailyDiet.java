package com.example.scopum.Diet;
import com.example.scopum.Bot.StrConst;
import com.example.scopum.Bot.botapi.BotContext;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Scanner;

public class DailyDiet extends Diet {
    private int age; // Возраст пользователя
    private double weight; // Вес пользователя
    private int growth; // Рост пользователя
    private String gender; // Пол пользователя
    private double employment; // Уровень занятости пользователя(1-5)
    public double[] remCalPFC = new double[4];      // оставшиеся БЖУК
    private double[] userCalPFC;
    private long chatId;
    private BotContext context;

    public DailyDiet(BotContext context) {
        this.context = context;
        this.weight = context.getUser().getWeight();
        this.growth = context.getUser().getGrowth();
        this.age = context.getUser().getAge();
        this.gender = context.getUser().getGender();
        this.employment = context.getUser().getEmployment();
        this.userCalPFC = context.getUser().getCalPFC();
        this.chatId = context.getUser().getChatId();
    }

    /**
     * Попытка получить БЖУК пользователя
     * @return получилось или нет
     */
    public void tryGetEatenCalPFC() {
        //StrConst.askCalPFC();
//        Scanner in = new Scanner(System.in);
//
//        String userChoice = in.nextLine();
//        userChoice = userChoice.replaceAll("\\s+","");
//        userChoice = userChoice.toLowerCase();

        //double[] userEatenCalPFC = convertUserCalPFC(calPFC);       // конвертация БЖУК
        computeUserRemCalPFC(userCalPFC);      // подсчет оставшихся к употреблению

    }

    /**
     * Подсчет оставшихся БЖУК к употреблению
     * @param userEatenCalPFC Употребленные БЖУК на данный момент
     */
    private void computeUserRemCalPFC(double[] userEatenCalPFC) {
        double[] userDailyCalPfc = computeUserCalPFC(gender, weight, growth, age, employment);      // получение дневной нормы БЖУК пользователя

        remCalPFC = new double[]{  userDailyCalPfc[0] - userEatenCalPFC[0],
                                        userDailyCalPfc[1] - userEatenCalPFC[1],
                                        userDailyCalPfc[2] - userEatenCalPFC[2],
                                        userDailyCalPfc[3] - userEatenCalPFC[3]};

        StringBuilder sb = new StringBuilder();
        sb.append("Вам осталось необходимо употребить:\n");
        sb.append(remCalPFC[0] + " " + "калорий\n");
        sb.append(remCalPFC[1] + " " + "белков\n");
        sb.append(remCalPFC[2] + " " + "жиров\n");
        sb.append(remCalPFC[3] + " " + "углеводов");

        SendMessage message = new SendMessage()
                .setChatId(context.getUser().getChatId())
                .setText(sb.toString());

        try {
            context.getBot().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

}
