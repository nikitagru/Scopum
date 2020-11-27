package com.example.scopum.Bot.botapi;

import com.example.scopum.Bot.StrConst;
import com.example.scopum.Bot.BotController;
import org.json.simple.parser.ParseException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public enum BotState {

    Start {
        @Override
        public void enter(BotContext context) {
            sendMessage(context, StrConst.hello());
        }

        @Override
        public BotState nextState() {
            return Age;
        }
    },
    Age {
        @Override
        public void enter(BotContext context) {
            sendMessage(context, "Сколько вам лет?");
        }

        @Override
        public void handleInput(BotContext context) {
            context.getUser().setAge(Integer.parseInt(context.getInput()));
        }

        @Override
        public BotState nextState() {
            return Weight;
        }
    },
    Weight {
        @Override
        public void enter(BotContext context) {
            sendMessage(context, "Какой у вас вес?");
        }

        @Override
        public void handleInput(BotContext context) {
            context.getUser().setWeight(Double.parseDouble(context.getInput()));
        }

        @Override
        public BotState nextState() {
            return Growth;
        }
    },
    Growth {
        @Override
        public void enter(BotContext context) {
            sendMessage(context, "Какой у вас рост?");
        }

        @Override
        public void handleInput(BotContext context) {
            context.getUser().setGrowth(Integer.parseInt(context.getInput()));
        }

        @Override
        public BotState nextState() {
            return Gender;
        }
    },
    Gender {
        @Override
        public void enter(BotContext context) {
            setKeyboardInput(BotKeyboard.genderButtons(context.getUser().getChatId()));
            sendMessage(context, "Какой у вас пол?");
        }

        @Override
        public void handleInput(BotContext context) {
            context.getUser().setGender(context.getCallBack().getData());
        }

        @Override
        public BotState nextState() {
            return Employment;
        }
    },
    Employment {
        @Override
        public void enter(BotContext context) {
            setKeyboardInput(BotKeyboard.employmentButtons(context.getUser().getChatId()));
            sendMessage(context, "Какой у вас образ жизни?");
        }

        @Override
        public void handleInput(BotContext context) {
            context.getUser().setEmployment(Double.parseDouble(context.getCallBack().getData()));
        }

        @Override
        public BotState nextState() {
            return CalPFC;
        }
    },
    CalPFC {
        @Override
        public void handleInput(BotContext context) {

            String[] userCalPFC = context.getInput().split("_");
            double[] finUserCalPfc = new double[4];

            for(int i = 0; i < 4; i++) {
                finUserCalPfc[i] = Double.parseDouble(userCalPFC[i]);
            }

            context.getUser().setCalPFC(finUserCalPfc);
        }

        @Override
        public void enter(BotContext context)  {
            sendMessage(context, "Укажите сколько КБЖУ вы сегодня употребили в формате: К_Б_Ж_У (без пробелов и через подчеркивание)");
        }

        @Override
        public BotState nextState() {
            return AllergyProducts;
        }
    },
    AllergyProducts {
        @Override
        public void handleInput(BotContext context) {
            if(context.getCallBack().getData().equals("Да")) {
                sendMessage(context, "Введите список продуктов через пробел в начальной форме. Вместо \"огурцы\" напишите просто \"огурец\"");
                context.getUser().setAllergyProducts(context.getInput());
            } else {
                context.getUser().setAllergyProducts(null);
            }
        }

        @Override
        public void enter(BotContext context) {
            setKeyboardInput(BotKeyboard.tryToGetAllergy(context.getUser().getChatId()));
            sendMessage(context, "Имеете ли вы аллергию на какие-нибудь продукты?");
        }

        @Override
        public BotState nextState() {
            return Approved;
        }
    },
    Approved(false) {
        @Override
        public void enter(BotContext context) {
            sendMessage(context, "Спасибо!");
        }

        @Override
        public BotState nextState() {
            return Choice;
        }
    },
    Choice {
        @Override
        public void handleInput(BotContext context) {
            context.getUser().setBotFunction(context.getCallBack().getData());
        }

        @Override
        public void enter(BotContext context) {
            setKeyboardInput(BotKeyboard.choiceButtons(context.getUser().getChatId()));
            sendMessage(context, "Выберите, что вы хотели бы сделать:");
        }

        @Override
        public BotState nextState() {
            return BotFunction;
        }
    },
    BotFunction {
        @Override
        public void handleInput(BotContext context) {

        }

        @Override
        public void enter(BotContext context) throws ParseException, InterruptedException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
            if (!context.getUser().getBotFunction().equals("end")) {
                BotController botController = new BotController();
                botController.start(context);
            }
        }

        @Override
        public BotState nextState() {
           return BotFunction;
        }
 };


    private static BotState[] states;
    private final boolean inputNeeded;
    private SendMessage keyboardInput;
    private String botFunction;

    public String getBotFunction() {
        return botFunction;
    }

    public void setBotFunctionUser(String botFunction) {
        this.botFunction = botFunction;
    }

    public void setKeyboardInput(SendMessage keyboardInput) {
        this.keyboardInput = keyboardInput;
    }

    BotState() {
        this.inputNeeded = true;
    }

    BotState(boolean inputNeeded) {
        this.inputNeeded = inputNeeded;
    }

    public static BotState getInitialState() {
        return byId(0);
    }

    public static BotState byId(int id) {
        if (states == null) {
            states = BotState.values();
        }

        return states[id];
    }

    protected void sendMessage(BotContext context, String text) {
        if (keyboardInput == null) {
            SendMessage message = new SendMessage()
                    .setChatId(context.getUser().getChatId())
                    .setText(text);

            try {
                context.getBot().execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            try {
                context.getBot().execute(keyboardInput);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean isInputNeeded() { return inputNeeded; }

    public void handleInput(BotContext context) {

    }

    public abstract void enter(BotContext context) throws ParseException, InterruptedException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public abstract BotState nextState();

}
