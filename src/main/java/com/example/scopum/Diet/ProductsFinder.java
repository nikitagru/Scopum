package com.example.scopum.Diet;

import com.example.scopum.Bot.botapi.BotContext;
import org.json.simple.parser.ParseException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProductsFinder {

    private List<Dish> dishes;        // массив блюд
    private double[] userRemCalPFC;     // остаток необходимых к употреблению БЖУК
    private String[] allegryProducts;       // массив аллергических продуктов пользователя
    private BotContext context;

    public ProductsFinder(double[] userRemCalPFC, String[] allergyProd, BotContext context) throws ParseException {
        this.userRemCalPFC = userRemCalPFC;
        this.allegryProducts = allergyProd;
        this.context = context;

    }

    /**
     * Получение блюда
     * @return Возвращает словарь, где ключ - название блюда, рецепт и ингредиенты, а значение - БЖУК
     */
    public HashMap<String[], double[]> getDishDaily() {
        String timeOfDay = getCurrentTimeOfDay();       // получение нынешнего времени суток
        HashMap<String[], double[]> result;

        this.dishes = getAllDishesByTime(timeOfDay, context.getDishes());
        result = getDishAndRecipe(dishes);

        return result;
    }

    /**
     * Получение блюда и его рецепта
     * @param dishCalPFC массив блюд
     * @return Возвращает словарь, где ключ - название блюда, рецепт и ингредиенты, а значение - БЖУК
     */
    private HashMap<String[], double[]> getDishAndRecipe(List<Dish> dishCalPFC) {
        String currentDishName = "";        // название нужного блюда
        double[] currentDishCalPFC = new double[4];     // БЖУК нужного блюда
        String[] recipe = new String[2];


        for (int i = 0; i < dishCalPFC.size(); i++) {
            Random rnd = new Random();
            Dish dish = dishCalPFC.get(rnd.nextInt(dishCalPFC.size()));        // получение рандомного блюда из массива блюд

            String dishName = dish.getName();     // получение название блюда
            double[] calPFC = dish.getCalPFC();       // получение БЖУК блюда

            if (    userRemCalPFC[0] - calPFC[3] > 0 &&
                    userRemCalPFC[1] - calPFC[1] > 0 &&
                    userRemCalPFC[2] - calPFC[2] > 0 &&
                    userRemCalPFC[3] - calPFC[0] > 0 ) {
                currentDishName = dishName;
                currentDishCalPFC = calPFC;
                recipe[0] = dish.getRecipe();       // получаем рецепт подходящего блюда
                recipe[1] = dish.getIngredients();  // получаем ингредиенты рецепта

                boolean allergy = checkAllergy(recipe[1]);      // сдержит ли еда продукты, вызывающие аллергическую реакцию

                if (!allergy) {
                    break;      // если нашли подходящее блюдо, то цикл прерывается
                }
            }
        }


        String[] recAndName = new String[] {currentDishName, recipe[0], recipe[1]};

        HashMap<String[], double[]> result = new HashMap<>();
        result.put(recAndName, currentDishCalPFC);

        return result;
    }

    /**
     * Получение ныншнего времени суток
     * @return Утро, день или вечер
     */
    private String getCurrentTimeOfDay() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String currentTime = dtf.format(now);
        int currentHour = Integer.parseInt(currentTime.substring(0, 2));

        if (currentHour >= 6 && currentHour < 12) {
            return "Morning";
        } else if (currentHour >= 12 && currentHour < 15) {
            return "Day";
        } else {
            return "Evening";
        }
    }

    /**
     * Проверяет содержится ли в рецепте продукты, вызывающие аллергическую реакцию
     * @param ingredients Ингредиенты рецепта
     * @return Содержит ли аллергические продукты
     */
    private boolean checkAllergy(String ingredients) {
        List<String> ingred = Arrays.asList(ingredients.split("\n"));       // ингредиенты рецепта в виде массива

        for (int i = 0; i < ingred.size(); i++) {
            String idredient = ingred.get(i);
            int index = idredient.indexOf("-");     // получаем индекс первого тире
            ingred.set(i, idredient.substring(0, index - 1).toLowerCase());     // заменяем название продукта("Помидор - 2шт" -> "помидор)"
        }

        boolean result = false;
        if (allegryProducts != null) {
            for(String allergy : allegryProducts) {
                if (ingred.contains(allergy)) {
                    result = true;
                }
            }
        }

        return result;
    }

    /**
     * Получение всех блюд для определенного времени суток
     * @param time Время суток(утро, день или вечер)
     * @param dishArray массив всех блюд
     * @return массив блюд определенного времени суток
     */
    public List<Dish> getAllDishesByTime(String time, Iterable<Dish> dishArray) {
        List<Dish> dishes = new ArrayList<>();

        for(Dish d : dishArray) {
            if (d.getTime().equals(time)) {
                dishes.add(d);
            }
        }

        return dishes;
    }
}
