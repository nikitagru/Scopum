package com.example.scopum.Bot;

import com.example.scopum.Bot.botapi.BotContext;
import com.example.scopum.Diet.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

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
        DishesFinder finder = new DishesFinder(context.getUser().getCalPFC(), userAllergyProd, context);
        HashMap<String[], double[]> dish = finder.getDishDaily();
        Map.Entry<String[], double[]> currentDish = dish.entrySet().iterator().next();

        String dishName = currentDish.getKey()[0];

        String recipe = currentDish.getKey()[1];
        String ingredients = currentDish.getKey()[2];

        String photoName = currentDish.getKey()[3];

        double[] calPFC = currentDish.getValue();
        if (context.getUser().isTracking()) {
            context.getUser().setTrackingCalPFC(calPFC);
        }

        Message message = new Message();
        if (calPFC[0] <= 0.0) {
            message.sendMessage(context, "Мы не смогли ничего найти подходящего в нашей базе данных рецептов. " +
                    "Возможно, вы уже употребили достаточно пищи сегодня");
        } else {
            message.setFullRecipe(dishName, recipe, ingredients,  calPFC);
            Photo photo = new Photo();
            photo.setPhoto(photoName);
            message.sendMessage(context, message.getFullRecipe(), photo.getPhoto());

            if (context.getUser().isTracking()) {
                StringBuilder sb = new StringBuilder();
                double[] userRemCalPFC = context.getUser().getCalPFC();
                sb.append("Ваши данные учтены. Остаток дневной нормы:\n");
                sb.append("Калорий: " + userRemCalPFC[0] + "\n");
                sb.append("Белков: " + userRemCalPFC[1] + "\n");
                sb.append("Жиров: " + userRemCalPFC[2] + "\n");
                sb.append("Углеводов: " + userRemCalPFC[3] + "\n");

                message.sendMessage(context, sb.toString());
            }
        }
        context.getUser().setBotFunction("end");
    }

    /**
     * Анализатор КБЖУ продукта
     * @param context контекст приложения
     */
    public void createAnalyzer(BotContext context) {
        ProductFinder productFinder = new ProductFinder();
        Message message = new Message();
        if (context.getInput().equals(""))
        {
            message.sendMessage(context,"Ведите продукт");
        }
        else
        {
            if (!Pattern.matches("^-?[0-9][0-9,.]+$", context.getInput())) {
                Product userProduct = productFinder.getCalPFC(context.getInput().toLowerCase(), context.getProducts());
                if (userProduct == null) {
                    message.sendMessage(context, "Мы ничего не смогли найти в базе данных продуктов. Возможно, вы допустили ошибку в названии.");
                } else {
                    message.setProductCalPFC(userProduct);
                    message.sendMessage(context, message.getProductCalPFC());
                }
                context.getUser().setBotFunction("end");
            } else {
                message.sendMessage(context, "Вы ввели число. Пожалуйста, введите строку");
            }

        }
    }

    public void start(BotContext context) throws IOException, InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        BotControllerState state = BotControllerState.valueOf(context.getUser().getBotFunction());
        state.enter(context, this);
    }

}
