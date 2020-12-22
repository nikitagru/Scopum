package com.example.scopum.Bot;

import com.example.scopum.Bot.botapi.BotContext;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Состояния основных функций бота(Основные функции)
 */
public enum BotControllerState {
    DailyDiet{
        @Override
        public void enter(BotContext context, BotController controller) {
            controller.createDailyDiet(context);
        }
    },
    Analyzer {
        @Override
        public void enter(BotContext context, BotController controller) {
            controller.createAnalyzer(context);
        }
    };

    /**
     * Вход в метод обработки одной из основных функций
     * @param context контекст приложения
     * @param controller контроллер бота
     * @throws IOException
     * @throws InterruptedException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public abstract void enter(BotContext context, BotController controller) throws IOException, InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException;


}

