package com.example.scopum.Bot;

import com.example.scopum.Bot.botapi.BotContext;
import com.example.scopum.Diet.DailyDiet;
import com.example.scopum.Diet.LongDiet;
import com.example.scopum.Diet.ProductsFinder;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Основные функции бота
 */
public class BotController {

    /**
     * Разовый подбор блюда
     * @param context контекст приложения
     */
    public void createDailyDiet(BotContext context) {
        DailyDiet dailyDiet = new DailyDiet(context);

        dailyDiet.tryGetEatenCalPFC();


        String[] userAllergyProd = context.getUser().getAllergyProducts();
        ProductsFinder finder = new ProductsFinder(dailyDiet.remCalPFC, userAllergyProd, context);
        HashMap<String[], double[]> dish = finder.getDishDaily();
        Map.Entry<String[], double[]> currentDish = dish.entrySet().iterator().next();

        String dishName = currentDish.getKey()[0];

        String recipe = currentDish.getKey()[1];
        String ingredients = currentDish.getKey()[2];

        double[] calPFC = currentDish.getValue();



        if (calPFC[0] == 0.0) {
            Message message = new Message();
            message.sendMessage(context, "Мы не смогли ничего найти подходящего в нашей базе данных рецептов. " +
                    "Возможно, вы уже употребили достаточно пищи сегодня");
        } else {
            Message message = new Message();
            message.setFullRecipe(dishName, recipe, ingredients,  calPFC);
            message.sendMessage(context, message.getFullRecipe());

            context.getUser().setBotFunction("end");
        }


    }

    public void createLongDiet(BotContext context) {
        LongDiet longDiet = new LongDiet(context);
        longDiet.initLongDiet();
        context.getUser().setBotFunction("end");
    }

    public void start(BotContext context) throws IOException, InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        BotControllerState state = BotControllerState.valueOf(context.getUser().getBotFunction());
        state.enter(context, this);
    }

}
