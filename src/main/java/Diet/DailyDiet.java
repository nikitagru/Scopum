package Diet;

import java.util.Scanner;


public class DailyDiet extends Diet {
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

                double[] userEatenCalPFC = convertUserCalPFC(calPFC);
                computeUserRemCalPFC(userEatenCalPFC);
                break;
            case "нет":
                System.out.println("Давайте тогда посчитаем сами.");
                isSuccess = false;
                break;
        }
        return isSuccess;
    }

    private void computeUserRemCalPFC(double[] userEatenCalPFC) {
        double[] userDailyCalPfc = computeUserCalPFC(gender, weight, growth, age, employment);

        requiredCalPfc = new double[]{  userDailyCalPfc[0] - userEatenCalPFC[0],
                                        userDailyCalPfc[1] - userEatenCalPFC[1],
                                        userDailyCalPfc[2] - userEatenCalPFC[2],
                                        userDailyCalPfc[3] - userEatenCalPFC[3]};

        System.out.println("Вам осталось необходимо употребить:");
        System.out.println(requiredCalPfc[0] + " " + "калорий");
        System.out.println(requiredCalPfc[1] + " " + "белков");
        System.out.println(requiredCalPfc[2] + " " + "жиров");
        System.out.println(requiredCalPfc[3] + " " + "углеводов");

    }

    private double[] convertUserCalPFC(String calPFC) {
        String[] userCalPFC = calPFC.split("_");
        double[] finUserCalPfc = new double[4];

        for(int i = 0; i < 4; i++) {
            finUserCalPfc[i] = Double.parseDouble(userCalPFC[i]);
        }
        return finUserCalPfc;
    }

}
