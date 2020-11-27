package com.example.scopum.Bot;

import com.example.scopum.Bot.botapi.BotContext;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public enum BotControllerState {
    DailyDiet{
        @Override
        public void nextState() {

        }

        @Override
        public void enter(BotContext context, BotController controller) throws ParseException {
            controller.createDailyDiet(context);
        }

        @Override
        public void handleInput() {

        }
    },
    LongDiet {
        @Override
        public void nextState() {

        }

        @Override
        public void enter(BotContext context, BotController controller) {
            controller.createLongDiet(context);
        }

        @Override
        public void handleInput() {
        }
    },
    NormalTraining {
        @Override
        public void nextState() {

        }

        @Override
        public void enter(BotContext context, BotController controller) throws IOException, InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
            controller.createNormalTraining(context);
        }

        @Override
        public void handleInput() {

        }
    },
    ProfessionalTraining {
        @Override
        public void nextState() {

        }

        @Override
        public void enter(BotContext context, BotController controller) throws IOException, InterruptedException {
            controller.createProfessionalTraining(context);
        }

        @Override
        public void handleInput() {
        }
    };

    public abstract void nextState();
    public abstract void enter(BotContext context, BotController controller) throws ParseException, IOException, InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public void handleInput() {

    }
}
