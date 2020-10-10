package Diet;

import Bot.JSONParse;
import org.json.simple.parser.ParseException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ProductsFinder extends JSONParse {

    private JSONParse jsonObj = new JSONParse();

    private List<HashMap> dayCalPFC;        // массив дневных блюд
    private List<HashMap> morningCalPFC;        // массив утренних блюд
    private List<HashMap> eveningCalPFC;        // массив вечерних блюд
    private List<HashMap> recipes;      // массив рецептов
    private double[] userRemCalPFC;     // остаток необходимых к употреблению БЖУК

    public ProductsFinder(double[] userRemCalPFC) throws ParseException {
        jsonObj.productsInit("e:\\JavaProjects\\Scopum\\Scopum\\src\\main\\java\\Diet\\Day.json");
        dayCalPFC = jsonObj.convertJson();
        jsonObj.productsInit("E:\\JavaProjects\\Scopum\\Scopum\\src\\main\\java\\Diet\\Morning.json");
        morningCalPFC = jsonObj.convertJson();
        jsonObj.productsInit("E:\\JavaProjects\\Scopum\\Scopum\\src\\main\\java\\Diet\\Evening.json");
        eveningCalPFC = jsonObj.convertJson();
        jsonObj.productsInit("E:\\JavaProjects\\Scopum\\Scopum\\src\\main\\java\\Diet\\Recipes.json");
        recipes = jsonObj.convertRecipes();
        this.userRemCalPFC = userRemCalPFC;
    }

    /**
     * Получение блюда
     * @return Возвращает словарь, где ключ - название блюда, рецепт и ингредиенты, а значение - БЖУК
     */
    public HashMap<String[], double[]> getDish() {
        String timeOfDay = getCurrentTimeOfDay();       // получение нынешнего времени суток
        HashMap<String[], double[]> result = new HashMap<>();

        switch (timeOfDay) {
            case "morning":
                result = getDishAndRecipe(morningCalPFC);
                break;
            case "day":
                result = getDishAndRecipe(dayCalPFC);
                break;
            case "evening":
                result = getDishAndRecipe(eveningCalPFC);
        }
        return result;
    }

    /**
     * Получение блюда и его рецепта
     * @param dishCalPFC массив блюд
     * @return Возвращает словарь, где ключ - название блюда, рецепт и ингредиенты, а значение - БЖУК
     */
    private HashMap<String[], double[]> getDishAndRecipe(List<HashMap> dishCalPFC) {
        String currentDishName = "";        // название нужного блюда
        double[] currentDishCalPFC = new double[4];     // БЖУК нужного блюда

        for (int i = 0; i < dishCalPFC.size(); i++) {
            Random rnd = new Random();
            HashMap<String, double[]> dish = dishCalPFC.get(rnd.nextInt(dishCalPFC.size()));        // получение рандомного блюда из массива блюд
            Map.Entry<String, double[]> currentDish = dish.entrySet().iterator().next();        // преобразование нужного словаря блюда

            String dishName = currentDish.getKey();     // получение название блюда
            double[] calPFC = currentDish.getValue();       // получение БЖУК блюда

            if (    userRemCalPFC[0] - calPFC[0] > 0 &&
                    userRemCalPFC[1] - calPFC[1] > 0 &&
                    userRemCalPFC[2] - calPFC[2] > 0 &&
                    userRemCalPFC[3] - calPFC[3] > 0 ) {
                currentDishName = dishName;
                currentDishCalPFC = calPFC;
                break;      // если нашли подходящее блюдо, то цикл прерывается
            }
    }

        String[] recipe = getRecipe(currentDishName);       // получаем рецепт подходящего блюда
        String[] recAndName = new String[] {currentDishName, recipe[0], recipe[1]};

        HashMap<String[], double[]> result = new HashMap<>();
        result.put(recAndName, currentDishCalPFC);

        return result;
    }

    /**
     * Получение рецепта
     * @param dishName Название блюда
     * @return Рецепт и ингредиенты
     */
    private String[] getRecipe(String dishName) {
        String[] result = new String[2];

        for (int i = 0; i < recipes.size(); i++) {      // идем по всем рецептам
            HashMap recipe = recipes.get(i);

            if (recipe.containsKey(dishName)) {     // проверяем у каждого совпадает ли название с входящим
                result = (String[]) recipe.get(dishName);
                break;
            }
        }

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
            return "morning";
        } else if (currentHour >= 12 && currentHour < 15) {
            return "day";
        } else {
            return "evening";
        }
    }
}
