import Diet.DailyDiet;
import Diet.ProductsFinder;

import com.sun.security.jgss.GSSUtil;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class BotController implements BotFunctionality {

    public BotController() {
        System.out.println("Привет! Меня зовут Scopum. " +
                "Я бот, который поможет тебе орагнизовать в твоем обычном дне элементы здорового образа жизни" +
                "Давай познакомимся!");
    }

    @Override
    public void dailyDiet(User user) throws IOException, ParseException {
        double weight = user.getWeight();
        int growth = user.getGrowth();
        int age = user.getAge();
        String gender = user.getGender();
        double employment = user.getEmployment();

        DailyDiet dailyDiet = new DailyDiet(weight, growth, age, gender, employment);

        boolean isGetCalPFC = dailyDiet.tryGetEatenCalPFC();

        if (!isGetCalPFC) {
            System.out.println("Перечислите через Enter еду, которую вы сегодня ели." +
                    "Формат записи: вместо \"овсянная каша\" пишите овсянка, вместо \"сваренный рис\" - рис.");

            while(true) {
                Scanner in = new Scanner(System.in);
                System.out.println("Введите название продукта");
                String userFood = Bot.findWord(in.nextLine());
                System.out.println("Продолжить запись продуктов?(да/нет)");
                if(in.nextLine() == "нет") {
                    break;
                }
            }
        } else {
            ProductsFinder finder = new ProductsFinder(dailyDiet.remCalPFC);
            HashMap<String[], double[]> dish = finder.getDish();
            Map.Entry<String[], double[]> currentDish = dish.entrySet().iterator().next();

            String dishName = currentDish.getKey()[0];

            String recipe = currentDish.getKey()[1];
            String ingred = currentDish.getKey()[2];

            double[] calPFC = currentDish.getValue();

            if(dishName == null) {
                System.out.println("Мы не смогли ничего найти подходящего в нашей базе данных рецептов. Возможно, вы уже употребили достаточно пищи сегодня");
            } else {
                System.out.println( "Могу предложить вам этот рецепт:\n" +
                        dishName + "\n" +
                        recipe + "\n" +
                        ingred + "\n" +
                        "КБЖУ данного рецепта:\n" +
                        calPFC[0] + "\n" +
                        calPFC[1] + "\n" +
                        calPFC[2] + "\n" +
                        calPFC[3] + "\n");
            }
        }
    }

    @Override
    public void longDiet() {

    }

    @Override
    public void normalTraining() {

    }

    @Override
    public void professionalTraining() {

    }



}
