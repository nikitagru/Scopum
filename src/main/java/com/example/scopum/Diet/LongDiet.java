package com.example.scopum.Diet;

import com.example.scopum.Bot.botapi.BotContext;
import com.example.scopum.model.Gender;

public class LongDiet extends Diet {
    private int age; // Возраст пользователя
    private double weight; // Вес пользователя
    private int growth; // Рост пользователя
    private Gender gender; // Пол пользователя
    private double employment; // Уровень занятости пользователя(1-5)

    public LongDiet(BotContext context) { // User user
        this.age = context.getUser().getAge();             /* this.user */
        this.weight = context.getUser().getWeight();
        this.growth = context.getUser().getGrowth();
        this.gender = context.getUser().getGender();
        this.employment = context.getUser().getEmployment();
    }

    public void initLongDiet() {
        double[] userCalPFC = computeUserCalPFC(gender, weight, growth, age, employment);

        System.out.println("Ваша дневная норма КБЖУ:\n " +
                            userCalPFC[0] + "\n" + " " + "калорий" +
                            userCalPFC[1] + "\n" + " " + "белков" +
                            userCalPFC[2] + "\n" + " " + "жиров" +
                            userCalPFC[3] + "\n" + " " + "углеводов");


    }
}
