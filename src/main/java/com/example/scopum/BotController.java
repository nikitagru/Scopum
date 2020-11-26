package com.example.scopum;

import com.example.scopum.Bot.botapi.BotContext;
import com.example.scopum.model.User;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;

public interface BotController {
    /**
     * Составление разового дневного рациона питания
     */
    void dailyDiet(BotContext context) throws ParseException, IOException, SQLException, ClassNotFoundException;

    /**
     * Составление продолжительной диеты
     */
    void longDiet(BotContext context);

    /**
     * Составление тренировки для обычного человека
     */
    void normalTraining(BotContext context) throws IOException, InterruptedException;

    /**
     * Составление тренировки для спортсмена
     */
    void professionalTraining(BotContext context) throws IOException, InterruptedException;


}
