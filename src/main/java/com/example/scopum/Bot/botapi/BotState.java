package com.example.scopum.Bot.botapi;

import com.example.scopum.Bot.BotVisualizer;
import com.example.scopum.Bot.BotController;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public enum BotState {

    Start {
        @Override
        public void enter(BotContext context) {
            sendMessage(context, BotVisualizer.getHelloMsg());
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
            context.getUser().setAge(context.getInput(), context);
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
            context.getUser().setWeight(context.getInput(), context);
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
            context.getUser().setGrowth(context.getInput(), context);
        }

        @Override
        public BotState nextState() {
            return Gender;
        }
    },
    Gender {
        @Override
        public void enter(BotContext context) {
            BotKeyboard botKeyboard = new BotKeyboard();
            setKeyboardInput(botKeyboard.genderButtons(context.getUser().getChatId()));
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
            BotKeyboard botKeyboard = new BotKeyboard();
            setKeyboardInput(botKeyboard.employmentButtons(context.getUser().getChatId()));
            sendMessage(context, "Какой у вас образ жизни?");
        }

        @Override
        public void handleInput(BotContext context) {
            context.getUser().setEmployment(Double.parseDouble(context.getCallBack().getData()));
        }

        @Override
        public BotState nextState() {
            return Calories;
        }
    },
    Calories {
        @Override
        public void handleInput(BotContext context) {
            context.getUser().setCalories(context.getInput(), context);
        }

        @Override
        public void enter(BotContext context)  {
            sendMessage(context, "Укажите сколько калорий вы сегодня употребили(если не знаете, то просто пишете 0)");
        }

        @Override
        public BotState nextState() {
            return Proteins;
        }
    },
    Proteins {
        @Override
        public void handleInput(BotContext context) {
            context.getUser().setProteins(context.getInput(), context);
        }

        @Override
        public void enter(BotContext context) throws InterruptedException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
            sendMessage(context, "Укажите сколько белков вы сегодня употребили(если не знаете, то просто пишите 0)");
        }

        @Override
        public BotState nextState() {
            return Fat;
        }
    },
    Fat {
        @Override
        public void handleInput(BotContext context) {
            context.getUser().setFat(context.getInput(), context);
        }

        @Override
        public void enter(BotContext context) throws InterruptedException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
            sendMessage(context, "Укажите сколько жиров вы сегодня употребили(если не знаете, то просто пишите 0)");
        }

        @Override
        public BotState nextState() {
            return Carbohydrates;
        }
    },
    Carbohydrates {
        @Override
        public void handleInput(BotContext context) {
            context.getUser().setCarbohydrates(context.getInput(), context);
        }

        @Override
        public void enter(BotContext context) throws InterruptedException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
            sendMessage(context, "Укажите сколько углеводов вы сегодня употребили(если не знаете, то просто пишите 0)");
        }

        @Override
        public BotState nextState() {
            return AllergyProducts;
        }
    },
    AllergyProducts {
        @Override
        public void handleInput(BotContext context) {
            context.getUser().setAllergyProducts(context.getInput(), context);
        }

        @Override
        public void enter(BotContext context) {
            sendMessage(context, "Имеете ли вы аллергию на какие-нибудь продукты? Если нет, то так и напишите. Если да, то перечислите все продукты через пробел в начальной форме. Вместо \"огурцы\" напишите просто \"огурец\"");
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
            return UserKeyboardInput;
        }
    },
    UserKeyboardInput(false) {
        @Override
        public void enter(BotContext context) {
            UserKeyboard userKeyboard = new UserKeyboard(context);
            setReplyKeyboardMarkup(userKeyboard.createKeyboard());
        }

        @Override
        public BotState nextState() {
            return Choice;
        }
    },
    Choice {
        @Override
        public void handleInput(BotContext context) {
            if (!context.getInput().equals("")) {       // если не была нажата кнопка основного меню функций
                context.getUser().clickButton(context.getInput());
                context.getUser().setStateId(this.getUserKeyboardInputMenu().ordinal());
            } else {
                context.getUser().setBotFunction(context.getCallBack().getData());
            }
        }

        @Override
        public void enter(BotContext context) {
            BotKeyboard botKeyboard = new BotKeyboard();
            setKeyboardInput(botKeyboard.choiceButtons(context.getUser().getChatId()));

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
        public void enter(BotContext context) throws InterruptedException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
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


    private static BotState[] states;       //массив состояний бота
    private final boolean isInputNeeded;
    private SendMessage keyboardInput;      //тип сообщения, где присутствует клавиатура у сообщения бота
    private SendMessage replyKeyboardMarkup;

    public void setKeyboardInput(SendMessage keyboardInput) {
        this.keyboardInput = keyboardInput;
    }

    public void setReplyKeyboardMarkup(SendMessage replyKeyboardMarkup) {
        this.replyKeyboardMarkup = replyKeyboardMarkup;
    }

    BotState() {
        this.isInputNeeded = true;
    }

    BotState(boolean inputNeeded) {
        this.isInputNeeded = inputNeeded;
    }

    /**
     * Возвращает начальное состояние бота
     * @return Самое первое состояние
     */
    public static BotState getInitialState() {
        return byId(0);
    }

    public static BotState byId(int id) {
        if (states == null) {
            states = BotState.values();
        }

        return states[id];
    }

    /**
     * Возвращает бота в меню выбора функции
     * @return Ожидание ввода
     */
    public BotState getChoiceMenu() {
        return Approved;
    }

    public BotState getUserKeyboardInputMenu() {
        return UserKeyboardInput;
    }

    /**
     * Отправляет сообщение пользователю
     * @param context контекст приложения
     * @param text текст сообщения
     */
    protected void sendMessage(BotContext context, String text) {
        if (keyboardInput == null && replyKeyboardMarkup == null) {
            SendMessage message = new SendMessage()
                    .setChatId(context.getUser().getChatId())
                    .setText(text);

            try {
                context.getBot().execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (replyKeyboardMarkup != null) {
            try {
                context.getBot().execute(replyKeyboardMarkup);
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

    public boolean isInputNeeded() { return isInputNeeded; }

    /**
     * Обработка ввода от пользователя
     * @param context контекст приложения
     */
    public void handleInput(BotContext context) {

    }

    /**
     * Вход в состояние
     * @param context контекст приложения
     * @throws InterruptedException
     * @throws IOException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public abstract void enter(BotContext context) throws InterruptedException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException;

    /**
     * Переходит в следующее состояние
     * @return Следующее состояние
     */
    public abstract BotState nextState();

}
