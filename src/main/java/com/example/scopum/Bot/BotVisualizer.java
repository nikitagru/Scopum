package com.example.scopum.Bot;

public class BotVisualizer {

    public static String getHelloMsg() {
        StringBuilder sb = new StringBuilder();
        sb.append("Привет! Меня зовут Scopum.\n");
        sb.append("Я бот, который поможет тебе орагнизовать в твоем обычном дне элементы здорового образа жизни.\n");
        sb.append("Давай познакомимся!");

        return sb.toString();
    }

    public static String getEmploymentMsg() {
        StringBuilder sb = new StringBuilder();
        sb.append("Какой у вас дневной образ жизни?\n");
        sb.append("1. Сидячий без нагрузок\n");
        sb.append("2. Тренировки  1-3 раза в неделю\n");
        sb.append("3. Занятия 3-5 дней в неделю\n");
        sb.append("4. Интенсивные тренировки 6-7 раз в неделю\n");
        sb.append("5. Спортсмены, выполняющие упражнения чаще, чем раз в день(несколько тренировок за день)");

        return sb.toString();
    }
}
