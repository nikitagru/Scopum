package com.example.scopum.Bot.botapi;

import com.example.scopum.Diet.Dish;
import com.example.scopum.model.User;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

public class BotContext {
    private final ChatBot bot;  //телеграм бот
    private final User user;    //пользователь, с которым работает бот
    private final String input; //последний ввод пользователя
    private CallbackQuery callBack;   //объект callBack(кнопки и прочее)
    private final Iterable<Dish> dishes;    // коллекция всех блюд

    public Iterable<Dish> getDishes() {
        return dishes;
    }



    public static BotContext of(ChatBot bot, String input, User user, CallbackQuery callBack, Iterable<Dish> dishes) {return new BotContext(input, user, bot, callBack, dishes); }

    public BotContext(String input, User user, ChatBot bot, CallbackQuery callBack, Iterable<Dish> dishes) {
        this.input = input;
        this.user = user;
        this.bot = bot;
        this.callBack = callBack;
        this.dishes = dishes;
    }

    public CallbackQuery getCallBack() {
        return callBack;
    }
    public ChatBot getBot() {
        return bot;
    }

    public User getUser() {
        return user;
    }

    /**
     * Получение последнего введенного сообщения от пользователя.
     * @return текст сообщения
     */
    public String getInput() {
        return this.input;
    }
}
