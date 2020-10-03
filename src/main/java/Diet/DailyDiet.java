package Diet;

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

    private double computeDaily() {
        if (gender == "male") {
            double result = 88.36 + (13.4 * weight) + (4.8 * growth) - (5.7 * age) * employment;
            return result;
        } else {
            double result = 447.6 + (9.2 * weight) + (3.1 * growth) - (4.3 * age) * employment;
            return result;
        }
    }
}
