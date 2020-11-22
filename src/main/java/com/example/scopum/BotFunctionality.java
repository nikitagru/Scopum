package com.example.scopum;

import com.example.scopum.controller.User;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface BotFunctionality {
    /**
     * Составление разового дневного рациона питания
     */
    void dailyDiet(User user) throws ParseException, IOException;

    /**
     * Составление продолжительной диеты
     */
    void longDiet(User user);

    /**
     * Составление тренировки для обычного человека
     */
    void normalTraining() throws IOException, InterruptedException;

    /**
     * Составление тренировки для спортсмена
     */
    void professionalTraining() throws IOException, InterruptedException;


}
