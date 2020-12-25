package com.example.scopum.Bot.botapi;



import com.example.scopum.Diet.Dish;
import com.example.scopum.Diet.Product;
import com.example.scopum.model.User;
import com.example.scopum.service.DishService;
import com.example.scopum.service.ProductService;
import com.example.scopum.service.UserService;
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
    private final ProductService productService;

    public ChatBot(UserService userService, DishService dishService, ProductService productService) {
        this.userService = userService;
        this.dishService = dishService;
        this.productService = productService;
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
            text = "";
        } else {
            text = update.getMessage().getText();
            chatId = update.getMessage().getChatId();
        }

        User user = userService.findByChatId(chatId);       //ищет в БД пользователя по chatId

        Iterable<Dish> dishes = dishService.findAll();
        Iterable<Product> products = productService.findAll();

        BotContext context;
        BotState state;

        if (user == null) {     //если не нашли пользователя(пользователь первый раз общается с ботом)
            state = BotState.getInitialState();

            user = new User(chatId, state.ordinal());
            userService.addUser(user);

            context = BotContext.of(this, text, user, update.getCallbackQuery(), dishes, products);

            try {
                state.enter(context);
            } catch (IOException | InterruptedException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            context = BotContext.of(this, text, user, update.getCallbackQuery(), dishes, products);
            state = BotState.byId(user.getStateId());
        }

        state.handleInput(context);
        userService.updateUser(user);
        do {
            if (context.getUser().isCorrect()) {        //если пользователь ввел корректное сообщение
                state = state.nextState();

                try {
                    state.enter(context);
                } catch (InterruptedException | IOException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
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
