package com.example.scopum.Bot;

import com.example.scopum.Bot.botapi.BotContext;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public enum BotControllerState {
    DailyDiet{
        @Override
        public void enter(BotContext context, BotController controller) throws ParseException {
            controller.createDailyDiet(context);
        }
    },
    LongDiet {
        @Override
        public void enter(BotContext context, BotController controller) {
            controller.createLongDiet(context);
        }
    },
    NormalTraining {
        @Override
        public void enter(BotContext context, BotController controller) throws IOException, InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
            controller.createNormalTraining(context);
        }
    },
    ProfessionalTraining {
        @Override
        public void enter(BotContext context, BotController controller) throws IOException, InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
            controller.createProfessionalTraining(context);
        }
    };

    /**
     * Вход в метод обработки одной из основных функций
     * @param context контекст приложения
     * @param controller контроллер бота
     * @throws ParseException
     * @throws IOException
     * @throws InterruptedException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public abstract void enter(BotContext context, BotController controller) throws ParseException, IOException, InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException;


}

