package Diet;

import java.util.Scanner;


public class DailyDiet {
    private int age; // Возраст пользователя
    private double weight; // Вес пользователя
    private int growth; // Рост пользователя
    private String gender; // Пол пользователя
    private double employment; // Уровень занятости пользователя(1-5)
    public double[] requiredCalPfc = new double[4];

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

    public boolean tryGetEatenCalPFC() {
        System.out.println("Вы знаете какое количество КБЖУ вы сегодня уже употребили?(Да/Нет)");
        Scanner in = new Scanner(System.in);

        String userChoice = in.nextLine();
        userChoice = userChoice.replaceAll("\\s+","");
        userChoice = userChoice.toLowerCase();

        boolean isSuccess = true;

        switch (userChoice) {
            case "да":
                System.out.println("Напишите в формате К_Б_Ж_У (без пробелов и через подчеркивание)");

                String calPFC = in.nextLine();
                calPFC = calPFC.replaceAll("\\s+","");

                double[] userCalPFC = convertUserCalPFC(calPFC);
                computeUserPFC(userCalPFC);
                break;
            case "нет":
                System.out.println("Давайте тогда посчитаем сами.");
                isSuccess = false;
                break;
        }
        return isSuccess;
    }

    private void computeUserPFC(double[] calPFC) {
        double dailyCal = computeDailyCal();
        double finDailyCal = dailyCal - calPFC[0];

        requiredCalPfc = new double[]{  finDailyCal,
                                        dailyCal * 30 / 4 - calPFC[1],
                                        dailyCal * 20 / 9 - calPFC[2],
                                        dailyCal * 50 / 4 - calPFC[3]};

        System.out.println("Вам осталось необходимо употребить:");
        System.out.println(requiredCalPfc[0] + "калорий");
        System.out.println(requiredCalPfc[1] + "белков");
        System.out.println(requiredCalPfc[2] + "жиров");
        System.out.println(requiredCalPfc[3] + "углеводов");

    }

    private double[] convertUserCalPFC(String calPFC) {
        String[] userCalPFC = calPFC.split("\\w");
        double[] finUserCalPfc = new double[4];

        for(int i = 0; i < 4; i++) {
            finUserCalPfc[i] = Integer.parseInt(userCalPFC[i]);
        }
        return finUserCalPfc;
    }
}
