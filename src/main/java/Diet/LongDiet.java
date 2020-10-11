package Diet;

public class LongDiet extends Diet {
    private int age; // Возраст пользователя
    private double weight; // Вес пользователя
    private int growth; // Рост пользователя
    private String gender; // Пол пользователя
    private double employment; // Уровень занятости пользователя(1-5)

    public LongDiet(double weight, int growth, int age, String gender, double employment) {
        this.age = age;
        this.weight = weight;
        this.growth = growth;
        this.gender = gender;
        this.employment = employment;
    }

    public void InitLongDiet() {
        double[] userCalPFC = computeUserCalPFC(gender, weight, growth, age, employment);

        System.out.println("Ваша дневная норма КБЖУ:\n " +
                            userCalPFC[0] + "\n" + " " + "калорий" +
                            userCalPFC[1] + "\n" + " " + "белков" +
                            userCalPFC[2] + "\n" + " " + "жиров" +
                            userCalPFC[3] + "\n" + " " + "углеводов");


    }
}
