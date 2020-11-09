package com.example.scopum.Bot;

import com.example.scopum.User;

public class BotContext {
    private final ChatBot bot;
    private final User user;
    private final String input;

    public static BotContext of(ChatBot bot, String input, User user) {return new BotContext(input, user, bot); }

    public BotContext(String input, User user, ChatBot bot) {
        this.input = input;
        this.user = user;
        this.bot = bot;
    }

    public ChatBot getBot() {
        return bot;
    }

    public User getUser() {
        return user;
    }
}
