package com.example.scopum.Diet;
import com.example.scopum.Bot.Message;
import com.example.scopum.Bot.botapi.BotContext;
import com.example.scopum.model.Gender;
import com.example.scopum.model.User;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;

public class DailyDiet extends Diet {
    private int age; // Возраст пользователя
    private double weight; // Вес пользователя
    private int growth; // Рост пользователя
    private Gender gender; // Пол пользователя
    private double employment; // Уровень занятости пользователя(1-5)
    public double[] remCalPFC = new double[4];      // оставшиеся КБЖУ
    private double[] userCalPFC;
    private BotContext context;

    public DailyDiet(BotContext context) {
        this.context = context;
        this.weight = context.getUser().getWeight();
        this.growth = context.getUser().getGrowth();
        this.age = context.getUser().getAge();
        this.gender = context.getUser().getGender();
        this.employment = context.getUser().getEmployment();
        this.userCalPFC = context.getUser().getCalPFC();        // то, сколько пользователь уже употребил за день
    }

    /**
     * Попытка получить БЖУК пользователя
     * @return получилось или нет
     */
    public void tryGetEatenCalPFC() {
        computeUserRemCalPFC(userCalPFC);      // подсчет оставшихся к употреблению
    }

    /**
     * Подсчет оставшихся БЖУК к употреблению
     * @param userEatenCalPFC Употребленные БЖУК на данный момент
     */
    private void computeUserRemCalPFC(double[] userEatenCalPFC) {
        double[] userDailyCalPfc = computeUserCalPFC(gender, weight, growth, age, employment);      // получение дневной нормы БЖУК пользователя


        if (!context.getUser().isTracking() && Arrays.equals(context.getUser().getCalPFC(), new double[]{0.0, 0.0, 0.0, 0.0})) {
            remCalPFC = new double[]{  userDailyCalPfc[0] - userEatenCalPFC[0],
                                        userDailyCalPfc[1] - userEatenCalPFC[1],
                                        userDailyCalPfc[2] - userEatenCalPFC[2],
                                        userDailyCalPfc[3] - userEatenCalPFC[3]};


        } else {
            remCalPFC = context.getUser().getCalPFC();
        }
        context.getUser().setLastCalPFC(context.getUser().getCalPFC());

        context.getUser().setCalPFC(remCalPFC);

        Message message = new Message();
        message.setRemUserCalPFC(remCalPFC);
        message.sendMessage(context, message.getRemUserCalPFC());
    }

}
