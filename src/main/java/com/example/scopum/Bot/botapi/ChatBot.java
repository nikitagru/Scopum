package com.example.scopum.Bot.botapi;



import com.example.scopum.Diet.Dish;
import com.example.scopum.model.User;
import com.example.scopum.service.DishService;
import com.example.scopum.service.UserService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Component
@PropertySource("classpath:telegram.properties")
public class ChatBot extends TelegramLongPollingBot {

    @Value("${bot.userName}")
    private String botName;

    @Value("${bot.token}")
    private String botToken;

    private final UserService userService;

    private final DishService dishService;

    public ChatBot(UserService userService, DishService dishService) {
        this.userService = userService;
        this.dishService = dishService;
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
        final String text;
        final Long chatId;
        if (update.hasCallbackQuery()) {        // если была нажата кнопка и т.д
            chatId = update.getCallbackQuery().getMessage().getChatId();
            text = update.getCallbackQuery().getData();
        } else {
            text = update.getMessage().getText();
            chatId = update.getMessage().getChatId();
        }

        User user = userService.findByChatId(chatId);       //ищет в БД пользователя по chatId

        Iterable<Dish> dishes = dishService.findAll();

        BotContext context;
        BotState state;

        if (user == null) {     //если не нашли пользователя(пользователь первый раз общается с ботом)
            state = BotState.getInitialState();

            user = new User(chatId, state.ordinal());
            userService.addUser(user);

            context = BotContext.of(this, text, user, update.getCallbackQuery(), dishes);

            try {
                state.enter(context);
            } catch (ParseException | IOException | InterruptedException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            context = BotContext.of(this, text, user, update.getCallbackQuery(), dishes);
            state = BotState.byId(user.getStateId());
        }


        state.handleInput(context);

        do {
            if (context.getUser().isCorrect()) {        //если пользователь ввел корректное сообщение
                state = state.nextState();

                try {
                    state.enter(context);
                } catch (ParseException | InterruptedException | IOException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } while (!state.isInputNeeded());

        if (user.getBotFunction() != null && user.getBotFunction().equals("end")) {     // если бот закончил работу с какой-то из своих основных функций
            user.setStateId(state.getChoiceMenu().ordinal());
            user.setBotFunction("");
        } else {
            user.setStateId(state.ordinal());
        }


        userService.updateUser(user);
    }
}
