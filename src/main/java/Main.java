import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // главный класс для запуска бота и инициализации пользователя

        BotController bot = new BotController();
        User user = new User();

        while (true) {
            System.out.println("Что бы вы хотели сделать?");
            System.out.println("\"Дневная диета\"--\"Многодневная диета\"--\"Тренировка\"");

            Scanner in = new Scanner(System.in);
            String userChoice = in.nextLine();

            switch (userChoice) {
                case "Дневная диета":
                    bot.dailyDiet(user.getWeight(), user.getGrowth(), user.getAge(), user.getGender(), user.getEmployment());
                    break;
                case "Многодневная диета":
                    bot.longDiet();
                    break;
                default:
                    System.out.println("Некорректно введенный запрос. Повторите попытку");
                    break;
            }
        }
    }


}
