package com.example.scopum.Bot.botapi;

import com.example.scopum.model.User;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

public class BotContext {
    private final ChatBot bot;  //телеграм бот
    private final User user;    //пользователь, с которым работает бот
    private final String input; //последний ввод пользователя
    private final CallbackQuery callBack;   //объект callBack(кнопки и прочее)


    public static BotContext of(ChatBot bot, String input, User user, CallbackQuery callBack) {return new BotContext(input, user, bot, callBack); }

    public BotContext(String input, User user, ChatBot bot, CallbackQuery callBack) {
        this.input = input;
        this.user = user;
        this.bot = bot;
        this.callBack = callBack;
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

    public String getInput() {
        return this.input;
    }

}
