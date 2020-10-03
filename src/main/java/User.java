import java.util.Scanner;

public class User {
    private String name;
    private int age;
    private double weight;
    private int growth;
    private boolean correctData;

    public User() {
        init();
    }

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

        } while (!isCorrectData());
    }

    private boolean isCorrectData() {
        if (!name.equals("") && age != 0 && weight != 0.0d && growth != 0) {
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

    public boolean getCorrectData() {
        return correctData;
    }
}
