package Training;

import java.io.IOException;
import java.util.Scanner;

public class ProfessionalTraining extends Training{
    public static void formatProfessionalTraining() throws IOException, InterruptedException {
        System.out.println("Вы выбрали раздел профессиональной тренировки! \r\n" +
                "Для начала выберите вид спорта, которым занимаетесь:");
        System.out.println("1. Бадминтон \r\n" +
                "2. Баскетбол \r\n" +
                "3. Бильярд \r\n" +
                "4. Бокс \r\n" +
                "5. Велоспорт \r\n" +
                "6. Киберспорт \r\n" +
                "7. Настольный теннис \r\n" +
                "8. Футбол \r\n" +
                "9. Хоккей \r\n");

        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();

        switch (answer) {
            case "1":
                ProfessionalTraining.badminton();
                break;
            case "2":
                ProfessionalTraining.basketball();
                break;
            case "3":
                ProfessionalTraining.billiards();
                break;
            case "4":
                ProfessionalTraining.boxing();
                break;
            case "5":
                ProfessionalTraining.cycling();
                break;
            case "6":
                ProfessionalTraining.eSport();
                break;
            case "7":
                ProfessionalTraining.tableTennis();
                break;
            case "8":
                ProfessionalTraining.football();
                break;
            case "9":
                ProfessionalTraining.hockey();
                break;
            default:
                System.out.println("Некорректно введенный запрос. Повторите попытку");
                break;
        }
    }

    private static void badminton() throws IOException, InterruptedException {
        System.out.println("Я думаю, что для игры в бадминтон полезно будет выполнять следующие упражнения: \r\n" +
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

    private static void basketball() throws InterruptedException {
        System.out.println("Я думаю, что для игры в бадминтон полезно будет выполнять следующие упражнения: \r\n" +
                "Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        Thread.sleep(5000);
    }

    private static void billiards() throws InterruptedException {
        System.out.println("Я думаю, что для игры в бильярд полезно будет выполнять следующие упражнения: \r\n" +
                "Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        Thread.sleep(5000);
    }

    private static void boxing() throws InterruptedException {
        System.out.println("Я думаю, что для бокса полезно будет выполнять следующие упражнения: \r\n" +
                "Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        Thread.sleep(5000);
    }

    private static void cycling() throws InterruptedException {
        System.out.println("Я думаю, что для велоспорта полезно будет выполнять следующие упражнения: \r\n" +
                "Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        Thread.sleep(5000);
    }

    private static void eSport() throws InterruptedException {
        System.out.println("Я думаю, что для игры в киберспорт полезно будет выполнять следующие упражнения: \r\n" +
                "Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        Thread.sleep(5000);
    }

    private static void tableTennis() throws InterruptedException {
        System.out.println("Я думаю, что для игры в настольный теннис полезно будет выполнять следующие упражнения: \r\n" +
                "Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        Thread.sleep(5000);
    }

    private static void football() throws InterruptedException {
        System.out.println("Я думаю, что для игры в футбол полезно будет выполнять следующие упражнения: \r\n" +
                "Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        Thread.sleep(5000);
    }

    private static void hockey() throws InterruptedException {
        System.out.println("Я думаю, что для игры в хоккей полезно будет выполнять следующие упражнения: \r\n" +
                "Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        Thread.sleep(5000);
    }

/**
 * Блок вывода ошибок
 * На будующее время
 */
}
