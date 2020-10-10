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

    private List<HashMap> dayCalPFC;
    private List<HashMap> morningCalPFC;
    private List<HashMap> eveningCalPFC;
    private List<HashMap> recipes;
    private double[] userRemCalPFC;

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

    public HashMap<String[], double[]> getDish() {
        String timeOfDay = getCurrentTimeOfDay();
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

    private HashMap<String[], double[]> getDishAndRecipe(List<HashMap> dishCalPFC) {
        String currentDishName = "";
        double[] currentDishCalPFC = new double[4];

        for (int i = 0; i < dishCalPFC.size(); i++) {
            Random rnd = new Random();
            HashMap<String, double[]> dish = dishCalPFC.get(rnd.nextInt(dishCalPFC.size()));
            Map.Entry<String, double[]> currentDish = dish.entrySet().iterator().next();

            String dishName = currentDish.getKey();
            double[] calPFC = currentDish.getValue();

            if (    userRemCalPFC[0] - calPFC[0] > 0 &&
                    userRemCalPFC[1] - calPFC[1] > 0 &&
                    userRemCalPFC[2] - calPFC[2] > 0 &&
                    userRemCalPFC[3] - calPFC[3] > 0 ) {
                currentDishName = dishName;
                currentDishCalPFC = calPFC;
                break;
            }
    }

        String[] recipe = getRecipe(currentDishName);
        String[] recAndName = new String[] {currentDishName, recipe[0], recipe[1]};

        HashMap<String[], double[]> result = new HashMap<>();
        result.put(recAndName, currentDishCalPFC);

        return result;
    }

    private String[] getRecipe(String dishName) {
        String[] result = new String[2];

        for (int i = 0; i < recipes.size(); i++) {
            HashMap recipe = recipes.get(i);

            if (recipe.containsKey(dishName)) {
                result = (String[]) recipe.get(dishName);
                break;
            }
        }

        return result;
    }

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
