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
        public void enter(BotContext context, BotController controller) throws IOException, InterruptedException {
            controller.createProfessionalTraining(context);
        }
    };


    public abstract void enter(BotContext context, BotController controller) throws ParseException, IOException, InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException;


}

