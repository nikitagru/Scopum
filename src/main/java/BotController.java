import Diet.DailyDiet;

public class BotController implements BotFunctionality {

    public BotController() {
        System.out.println("Привет! Меня зовут Scopum. " +
                "Я бот, который поможет тебе орагнизовать в твоем обычном дне элементы здорового образа жизни" +
                "Давай познакомимся!");
    }

    @Override
    public void dailyDiet(double weight, int growth, int age, String gender, double employment) {
        DailyDiet dailyDiet = new DailyDiet(weight, growth, age, gender, employment);
    }

    @Override
    public void longDiet() {

    }

    @Override
    public void normalTraining() {

    }

    @Override
    public void professionalTraining() {

    }

}
