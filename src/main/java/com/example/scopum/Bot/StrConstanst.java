package com.example.scopum.Bot;

public class StrConstanst {

    public static void hello() {
        System.out.println("Привет! Меня зовут Scopum. " +
                "Я бот, который поможет тебе орагнизовать в твоем обычном дне элементы здорового образа жизни. " +
                "Давай познакомимся!");
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

    public static void askEmployment() {
        System.out.println("Какой у вас дневной образ жизни? Напишите число от 1 до 5");
        System.out.println("\"Сидячий без нагрузок\"--" +
                "\"Тренировки  1-3 раза в неделю\"--" +
                "\"Занятия 3-5 дней в неделю\"--" +
                "\"Интенсивные тренировки 6-7 раз в неделю\"--" +
                "\"Спортсмены, выполняющие упражнения чаще, чем раз в день(несколько тренировок за день)\"");
    }

    public static void askCalPFC() {
        System.out.println("Вы знаете какое количество КБЖУ вы сегодня уже употребили?(Да/Нет)");
    }
}
