package com.example.scopum.Bot.botapi;



import com.example.scopum.model.User;
import com.example.scopum.service.UserService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

@Component
@PropertySource("classpath:telegram.properties")
public class ChatBot extends TelegramLongPollingBot {

    @Value("${bot.userName}")
    private String botName;

    @Value("${bot.token}")
    private String botToken;

    private final UserService userService;

    public ChatBot(UserService userService) {
        this.userService = userService;
    }

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
//        if (!update.hasMessage() || !update.getMessage().hasText()) {
//            return;
//        }
        final String text;
        final Long chatId;
        if (update.hasCallbackQuery()) {
            text = update.getCallbackQuery().getData();
            chatId = update.getCallbackQuery().getMessage().getChatId();
        } else {
            text = update.getMessage().getText();
            chatId = update.getMessage().getChatId();
        }


        User user = userService.findByChatId(chatId);

        BotContext context;
        BotState state;

        if (user == null) {
            state = BotState.getInitialState();

            user = new User(chatId, state.ordinal());
            userService.addUser(user);

            context = BotContext.of(this, text, user, update.getCallbackQuery());

            try {
                state.enter(context);
            } catch (IOException | InterruptedException | ParseException e) {
                e.printStackTrace();
            }
        } else {
            context = BotContext.of(this, text, user, update.getCallbackQuery());
            state = BotState.byId(user.getStateId());
        }

        state.handleInput(context);

        do {
            state = state.nextState();
            try {
                state.enter(context);
            } catch (IOException | InterruptedException | ParseException e) {
                e.printStackTrace();
            }
        } while (!state.isInputNeeded());

        user.setStateId(state.ordinal());

        userService.updateUser(user);
    }
}
