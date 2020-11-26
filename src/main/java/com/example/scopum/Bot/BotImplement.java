package com.example.scopum.Bot;

import com.example.scopum.Bot.botapi.BotContext;
import com.example.scopum.Diet.DailyDiet;
import com.example.scopum.Diet.LongDiet;
import com.example.scopum.Diet.ProductsFinder;
import com.example.scopum.Training.NormalTraining;
import com.example.scopum.Training.ProfessionalTraining;
import org.json.simple.parser.ParseException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class BotImplement implements BotController {

    public BotImplement() {

    }

    @Override
    public void dailyDiet(BotContext context) throws ParseException {
        DailyDiet dailyDiet = new DailyDiet(context);


        dailyDiet.tryGetEatenCalPFC();

        String[] userAllergyProd = context.getUser().getAllergyProducts();
        ProductsFinder finder = new ProductsFinder(dailyDiet.remCalPFC, userAllergyProd);
        HashMap<String[], double[]> dish = finder.getDishDaily();
        Map.Entry<String[], double[]> currentDish = dish.entrySet().iterator().next();

        String dishName = currentDish.getKey()[0];

        String recipe = currentDish.getKey()[1];
        String ingred = currentDish.getKey()[2];

        double[] calPFC = currentDish.getValue();



        if (calPFC[0] == 0.0) {
            SendMessage message = new SendMessage().setChatId(context.getUser().getChatId())
                    .setText("Мы не смогли ничего найти подходящего в нашей базе данных рецептов. Возможно, вы уже употребили достаточно пищи сегодня");
            try {
                context.getBot().execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Могу предложить вам этот рецепт:\n");
            sb.append(dishName + "\n");
            sb.append(recipe + "\n");
            sb.append(ingred + "\n");
            sb.append("БЖУК данного рецепта:\n");
            sb.append(calPFC[0] + " " + "белков" + "\n");
            sb.append(calPFC[1] + " " + "жиров" + "\n");
            sb.append(calPFC[2] + " " + "углеводов" + "\n");
            sb.append(calPFC[3] + " " + "калорий" + "\n");

            SendMessage message = new SendMessage().setChatId(context.getUser().getChatId())
                    .setText(sb.toString());
            try {
                context.getBot().execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }


    }


    @Override
    public void longDiet(BotContext context) {
        double weight = context.getUser().getWeight();
        int growth = context.getUser().getGrowth();
        int age = context.getUser().getAge();
        String gender = context.getUser().getGender();
        double employment = context.getUser().getEmployment();

        LongDiet longDiet = new LongDiet(weight, growth, age, gender, employment);

        longDiet.initLongDiet();
    }

    @Override
    public void normalTraining(BotContext context) throws IOException, InterruptedException {
        NormalTraining nTraining = new NormalTraining(context);

        nTraining.formatNormalTraining();

    }

    @Override
    public void professionalTraining(BotContext context) throws IOException, InterruptedException {
        ProfessionalTraining pTraining = new ProfessionalTraining(context);

        pTraining.formatProfessionalTraining();
    }

    public void start(String userChoice, BotContext context) throws ParseException, IOException, InterruptedException {
        switch (userChoice) {
            case "Дневная диета":
                dailyDiet(context);
                break;
            case "Многодневная диета":
                longDiet(context);
                break;
            case "Тренировка":
                normalTraining(context);
                break;
            case "Профессиональная тренировка":
                professionalTraining(context);
                break;
        }
    }

}
