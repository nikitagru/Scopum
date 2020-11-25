package com.example.scopum;

import com.example.scopum.Bot.botapi.BotContext;
import com.example.scopum.model.User;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface BotFunctionality {
    /**
     * Составление разового дневного рациона питания
     */
    void dailyDiet(BotContext context) throws ParseException, IOException;

    /**
     * Составление продолжительной диеты
     */
    void longDiet(BotContext context);

    /**
     * Составление тренировки для обычного человека
     */
    void normalTraining() throws IOException, InterruptedException;

    /**
     * Составление тренировки для спортсмена
     */
    void professionalTraining() throws IOException, InterruptedException;


}
