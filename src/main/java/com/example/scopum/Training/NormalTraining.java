package com.example.scopum.Training;

import java.io.IOException;
import java.util.Scanner;

public class NormalTraining extends Training {
    public static void formatNormalTraining() throws IOException, InterruptedException {
        System.out.println("Вы выбрали раздел тренировки!" +
                "Чем хотите заняться сегодня?");
        System.out.println("1. Комплекс упражнений для развития тела \r\n" +
                "2. Комплекс упражнений для похудения \r\n" +
                "3. Упражнения для развития мышц рук \r\n" +
                "4. Упражнения для развития мышц пресса \r\n" +
                "5. Упражнения для развития мышц ног");

        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();

        switch (answer) {
            case "1":
                NormalTraining.developmentBody();
                break;
            case "2":
                NormalTraining.theSlim();
                break;
            case "3":
                NormalTraining.armsMuscles();
                break;
            case "4":
                NormalTraining.abdominalMuscles();
                break;
            case "5":
                NormalTraining.legsMuscles();
                break;
            default:
                System.out.println("Некорректно введенный запрос. Повторите попытку");
                break;
        }
    }

    private static void developmentBody() throws IOException, InterruptedException {
        System.out.println("Я думаю, что для развития вашего тела подойдут эти упражнения: \r\n" +
                "Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        Thread.sleep(5000);
/**
 * Блок вывода необходимой информации из файла
 * Есть вопросы - стоит спросить!!!
 */
        //Scanner in = new Scanner(Paths.get("DevelopmaenBody.txt"), "UTF-8");
       // while (in.hasNextLine()){
            //System.out.println(in.nextLine());}
    }

    private static void theSlim() throws InterruptedException {
        System.out.println("Я думаю, что для похудения вам подойдут эти упражнения: \r\n" +
                "Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        Thread.sleep(5000);
    }

    private static void armsMuscles() throws InterruptedException {
        System.out.println("Я думаю, что для развития мышц рук вам подойдут эти упражнения: \r\n" +
                "Подтягивания - Отжимания - Использование_гантелей");
        Thread.sleep(5000);
    }

    private static void abdominalMuscles() throws InterruptedException {
        System.out.println("Я думаю, что для развития мышц пресса вам подойдут эти упражнения: \r\n" +
                "Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса");
        Thread.sleep(5000);
    }

    private static void legsMuscles() throws InterruptedException {
        System.out.println("Я думаю, что для развития мышц ног вам подойдут эти упражнения: \r\n" +
                "Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        Thread.sleep(5000);
    }

/**
 * Блок вывода ошибок
 * На будующее время
 */
}
