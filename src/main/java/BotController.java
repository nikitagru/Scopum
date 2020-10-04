import Diet.DailyDiet;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class BotController implements BotFunctionality {

    public BotController() {
        System.out.println("Привет! Меня зовут Scopum. " +
                "Я бот, который поможет тебе орагнизовать в твоем обычном дне элементы здорового образа жизни" +
                "Давай познакомимся!");
    }

    @Override
    public void dailyDiet(double weight, int growth, int age, String gender, double employment) throws IOException {
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
