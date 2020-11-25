package com.example.scopum;

import com.example.scopum.Bot.botapi.BotContext;
import com.example.scopum.Diet.DailyDiet;
import com.example.scopum.Diet.LongDiet;
import com.example.scopum.Training.NormalTraining;
import com.example.scopum.Training.ProfessionalTraining;
import com.example.scopum.model.User;
import org.json.simple.parser.ParseException;
import com.example.scopum.Bot.StrConst;

import java.io.IOException;


public class BotController implements BotFunctionality {

    public BotController() {

    }

    @Override
    public void dailyDiet(BotContext context) throws IOException, ParseException {
        DailyDiet dailyDiet = new DailyDiet(context);


        dailyDiet.tryGetEatenCalPFC();
        /*
        List<String> userAllergyProd = user.getAllergyProducts();
        ProductsFinder finder = new ProductsFinder(dailyDiet.remCalPFC, userAllergyProd);
        HashMap<String[], double[]> dish = finder.getDishDaily();
        Map.Entry<String[], double[]> currentDish = dish.entrySet().iterator().next();

        String dishName = currentDish.getKey()[0];

        String recipe = currentDish.getKey()[1];
        String ingred = currentDish.getKey()[2];

        double[] calPFC = currentDish.getValue();



        if (calPFC[0] == 0.0) {
                System.out.println("Мы не смогли ничего найти подходящего в нашей базе данных рецептов. Возможно, вы уже употребили достаточно пищи сегодня");
        } else {
            System.out.println("Могу предложить вам этот рецепт:\n" +
                    dishName + "\n" +
                    recipe + "\n" +
                    ingred + "\n" +
                    "БЖУК данного рецепта:\n" +
                    calPFC[0] + " " + "белков" + "\n" +
                    calPFC[1] + " " + "жиров" + "\n" +
                    calPFC[2] + " " + "углеводов" + "\n" +
                    calPFC[3] + " " + "калорий" + "\n");

        }
        */

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
    public void normalTraining() throws IOException, InterruptedException {
        NormalTraining nTraining = new NormalTraining();

        nTraining.formatNormalTraining();

    }

    @Override
    public void professionalTraining() throws IOException, InterruptedException {
        ProfessionalTraining pTraining = new ProfessionalTraining();

        pTraining.formatProfessionalTraining();
    }

    public void start(String userChoice, BotContext context) throws IOException, InterruptedException, ParseException {
        switch (userChoice) {
            case "Дневная диета":
                dailyDiet(context);
                break;
            case "Многодневная диета":
                longDiet(context);
                break;
            case "Тренировка":
                normalTraining();
                break;
            case "Профессиональная тренировка":
                professionalTraining();
                break;
        }
    }

}
