package com.example.scopum.Bot;

public class BotVisualizer {

    public static String hello() {
        StringBuilder sb = new StringBuilder();
        sb.append("Привет! Меня зовут Scopum.\n");
        sb.append("Я бот, который поможет тебе орагнизовать в твоем обычном дне элементы здорового образа жизни.\n");
        sb.append("Давай познакомимся!");

        return sb.toString();
    }
    public static void starting() {
        System.out.println("Ваши параметры сохранены!");
        System.out.println("Что бы вы хотели сделать?");
        System.out.println(" Дневная диета \r\n Многодневная диета \r\n Тренировка \r\n Профессиональная тренировка");
    }

    public static void incorrectInput() {
        System.out.println("Некорректно введенный запрос. Повторите попытку");
    }

    public static void incorrectOrSpace(){
        incorrectInput();
        System.out.println("В качестве имени была введена пустая строка.");
    }

    public static String askEmployment() {
        StringBuilder sb = new StringBuilder();
        sb.append("Какой у вас дневной образ жизни?\n");
        sb.append("1. Сидячий без нагрузок\n");
        sb.append("2. Тренировки  1-3 раза в неделю\n");
        sb.append("3. Занятия 3-5 дней в неделю\n");
        sb.append("4. Интенсивные тренировки 6-7 раз в неделю\n");
        sb.append("5. Спортсмены, выполняющие упражнения чаще, чем раз в день(несколько тренировок за день)");

        return sb.toString();
    }

    public static String askCalPFC() {
        return "Вы знаете какое количество КБЖУ вы сегодня уже употребили?(Да/Нет)";
    }
}
