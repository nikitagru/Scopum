import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class User {
    private String name; // Имя пользователя
    private int age; // Возраст пользователя
    private double weight; // Вес пользователя
    private int growth; // Рост пользователя
    private Gender gender; // Пол пользователя
    private double employment; // Уровень занятости пользователя(1-5)

    public User() {
        init();
    }

    /**
     * Инициализация пользователя
     */
    private void init() {
        do {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите ваше имя");
            String name = in.nextLine();
            setName(name);

            System.out.println("Введите ваш возраст");
            int age = Integer.parseInt(in.nextLine());
            setAge(age);

            System.out.println("Введите ваш вес");
            double weight = Double.parseDouble(in.nextLine());
            setWeight(weight);

            System.out.println("Введите ваш рост");
            int growth = Integer.parseInt(in.nextLine());
            setGrowth(growth);

            System.out.println("Вы мужчина или женщина?");
            String gender = in.nextLine();
            setGender(gender);

            System.out.println("Какой у вас дневной образ жизни? Напишите число от 1 до 5");
            System.out.println("\"Сидячий без нагрузок\"--" +
                    "\"Тренировки  1-3 раза в неделю\"--" +
                    "\"Занятия 3-5 дней в неделю\"--" +
                    "\"Интенсивные тренировки 6-7 раз в неделю\"--" +
                    "\"Спортсмены, выполняющие упражнения чаще, чем раз в день(несколько тренировок за день)\"");
            int employment = Integer.parseInt(in.nextLine());
            setEmployment(employment);

        } while (!isCorrectData());
    }

    /**
     * Проверяет корректно ли введены данные пользователем
     * @return true - если все данные введены корректно, false - если данные введены некорректно
     */
    private boolean isCorrectData() {
        if (!name.equals("") && age != 0 && weight != 0.0d && growth != 0 && gender != null && employment != 0) {
            return true;
        } else {
            System.out.println("Вы ввели некорректные данные, попробуйте снова");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.replaceAll("\\s+","");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 122 || age < 0) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            this.weight = 0.0d;
        } else {
            this.weight = weight;
        }
    }

    public int getGrowth() {
        return growth;
    }

    public void setGrowth(int growth) {
        if (growth < 0) {
            this.growth = 0;
        } else {
            this.growth = growth;
        }
    }

    public String getGender() {
        return gender.toString();
    }

    private void setGender(String gender) {
        gender = gender.toLowerCase();
        gender = gender.replaceAll("\\s+","");
        if (gender == "мужчина") {
            this.gender = Gender.male;
        } else if (gender == "женщина"){
            this.gender = Gender.female;
        } else {
            this.gender = null;
        }
    }

    public double getEmployment() {
        return employment;
    }

    private void setEmployment(int employment) {
        if (employment > 0 && employment < 6) {
            switch (employment) {
                case 1:
                    this.employment = 1.2;
                    break;
                case 2:
                    this.employment = 1.375;
                    break;
                case 3:
                    this.employment = 1.55;
                    break;
                case 4:
                    this.employment = 1.725;
                    break;
                case 5:
                    this.employment = 1.9;
                    break;
            }
        } else {
            this.employment = 0;
        }
    }
}
