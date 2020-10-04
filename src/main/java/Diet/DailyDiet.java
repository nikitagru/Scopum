package Diet;

import java.util.Scanner;

public class DailyDiet {
    private int age; // Возраст пользователя
    private double weight; // Вес пользователя
    private int growth; // Рост пользователя
    private String gender; // Пол пользователя
    private double employment; // Уровень занятости пользователя(1-5)

    public DailyDiet(double weight, int growth, int age, String gender, double employment) {
        this.age = age;
        this.weight = weight;
        this.growth = growth;
        this.gender = gender;
        this.employment = employment;
    }

    private double computeDailyCal() {
        if (gender == "male") {
            double result = (10 * weight) + (6.25 * growth) - (5 * age) * employment;
            return result;
        } else {
            double result = (10 * weight) + (6.25 * growth) - (5 * age) * employment;
            return result;
        }
    }

    public int computeEatenCalPFC() {
        System.out.println("Вы знаете какое количество КБЖУ вы сегодня уже употребили?(Да/Нет)");
        Scanner in = new Scanner(System.in);

        String userChoice = in.nextLine();
        userChoice = userChoice.replaceAll("\\s+","");
        userChoice = userChoice.toLowerCase();

        switch (userChoice) {
            case "да":
                System.out.println("Напишите в формате К-Б-Ж-У (без пробелов и через тире)");
                String calPFC = in.nextLine();
                calPFC = calPFC.replaceAll("\\s+","");
                break;
            case "нет":
                System.out.println("Давайте тогда посчитаем сами.");

        }

    }

    private double computeUserPFC() {
        System.out.println("Напишите, что вы сегодня ели? ");
    }
}
