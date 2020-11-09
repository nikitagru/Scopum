package com.example.scopum.Bot;


import com.example.scopum.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@PropertySource("classpath:telegram.properties")
public class ChatBot extends TelegramLongPollingBot {

    @Value("${bot.userName}")
    private String botName;

    @Value("${bot.token}")
    private String botToken;

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }

        final String text = update.getMessage().getText();
        final Long chatId = update.getMessage().getChatId();

        BotContext context;
        BotState state;

        state = BotState.getInitialState();
        User user = new User(chatId, state.ordinal());

        context = BotContext.of(this, text, user);
        state.enter(context);
    }
}
