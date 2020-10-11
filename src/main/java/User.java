import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class User {
    private String name; // Имя пользователя
    private int age; // Возраст пользователя
    private double weight; // Вес пользователя
    private int growth; // Рост пользователя
    private Gender gender; // Пол пользователя
    private double employment; // Уровень занятости пользователя(1-5)
    private boolean isCorrect = true;
    private List<String> allergyProducts;

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
            setAge(in.nextLine());

            System.out.println("Введите ваш вес");

            setWeight(in.nextLine());

            System.out.println("Введите ваш рост");

            setGrowth(in.nextLine());

            System.out.println("Вы мужчина или женщина?");
            String gender = in.nextLine();
            setGender(gender);

            System.out.println("Какой у вас дневной образ жизни? Напишите число от 1 до 5");
            System.out.println("\"Сидячий без нагрузок\"--" +
                    "\"Тренировки  1-3 раза в неделю\"--" +
                    "\"Занятия 3-5 дней в неделю\"--" +
                    "\"Интенсивные тренировки 6-7 раз в неделю\"--" +
                    "\"Спортсмены, выполняющие упражнения чаще, чем раз в день(несколько тренировок за день)\"");

            setEmployment(in.nextLine());

            System.out.println("Вы имеете аллергию на какие-нибудь продукты?(да/нет)");
            String allergy = in.nextLine();
            allergy = allergy.replaceAll(" ", "");
            allergy = allergy.toLowerCase();
            if (allergy.equals("да")) {
                setAllergyProducts();
            }

        } while (!isCorrectData());
    }

    private void setAllergyProducts() {
        System.out.println("Введите список продуктов через пробел в начальной форме. Вместо \"огурцы\" напишите просто \"огурец\"");
        Scanner in = new Scanner(System.in);
        String allergyProd = in.nextLine();

        this.allergyProducts = Arrays.asList(allergyProd.split(" "));
    }

    public List<String> getAllergyProducts() {
        return this.allergyProducts;
    }

    /**
     * Проверяет корректно ли введены данные пользователем
     * @return true - если все данные введены корректно, false - если данные введены некорректно
     */
    private boolean isCorrectData() {
        return isCorrect;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        name = name.replaceAll("\\s+","");
        if (name != null && !name.equals("")) {
            this.name = name;
        } else {
            System.out.println("В качестве имени была введена пустая строка. Пожалуйста, напишите корректное имя");
            Scanner newIn = new Scanner(System.in);
            setName(newIn.nextLine());
        }

    }

    public int getAge() {
        return age;
    }

    private void setAge(String ageIn) {
        int age = 0;
        if (ageIn != null && !ageIn.equals("")) {
            age = Integer.parseInt(ageIn);
            if (age > 122 || age <= 0) {
                System.out.println("Вы ввели некорректный возраст, попробуйте снова");
                Scanner newIn = new Scanner(System.in);
                setAge(newIn.nextLine());
            }
            this.age = age;
        } else {
            System.out.println("Вы ввели некорректный возраст, попробуйте снова");
            Scanner newIn = new Scanner(System.in);
            setAge(newIn.nextLine());
        }
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(String weightIn) {
        double weight;
        if (weightIn != null && !weightIn.equals("")) {
            weight = Double.parseDouble(weightIn);
            if (weight <= 0.0d) {
                System.out.println("Вы ввели некорректный вес, попробуйте снова");
                Scanner newIn = new Scanner(System.in);
                setWeight(newIn.nextLine());
            }
            this.weight = weight;
        } else {
            System.out.println("Вы ввели некорректный вес, попробуйте снова");
            Scanner newIn = new Scanner(System.in);
            setWeight(newIn.nextLine());
        }
    }

    public int getGrowth() {
        return growth;
    }

    private void setGrowth(String growthIn) {
        int growth;
        if (growthIn != null && !growthIn.equals("")) {
            growth = Integer.parseInt(growthIn);
            if (growth <= 0) {
                System.out.println("Вы ввели некорректный рост, попробуйте снова");
                Scanner newIn = new Scanner(System.in);
                setGrowth(newIn.nextLine());
            }
            this.growth = growth;
        } else {
            System.out.println("Вы ввели некорректный рост, попробуйте снова");
            Scanner newIn = new Scanner(System.in);
            setGrowth(newIn.nextLine());
        }
    }

    public String getGender() {
        return gender.toString();
    }

    private void setGender(String gender) {
        if (gender != null && !gender.equals("")) {
            gender = gender.toLowerCase();
            gender = gender.replaceAll("\\s+","");
            if (gender.equals("мужчина")) {
                this.gender = Gender.male;
            } else if (gender.equals("женщина")){
                this.gender = Gender.female;
            } else {
                System.out.println("Вы ввели некорретный пол, попробуйте снова");
                Scanner newIn = new Scanner(System.in);
                setGender(newIn.nextLine());
            }
        } else {
            System.out.println("Вы ввели некорретный пол, попробуйте снова");
            Scanner newIn = new Scanner(System.in);
            setGender(newIn.nextLine());
        }
    }

    public double getEmployment() {
        return employment;
    }

    private void setEmployment(String employmentIn) {
        int employment;
        if (employmentIn != null && !employmentIn.equals("")) {
            employment = Integer.parseInt(employmentIn);
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
                System.out.println("Вы ввели некорретное значение, введите число от 1-5");
                Scanner newIn = new Scanner(System.in);
                setEmployment(newIn.nextLine());
            }
        } else {
            System.out.println("Вы ввели некорретное значение, введите число от 1-5");
            Scanner newIn = new Scanner(System.in);
            setEmployment(newIn.nextLine());
        }
    }
}
