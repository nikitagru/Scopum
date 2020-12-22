package com.example.scopum.Bot.botapi;

import com.example.scopum.Diet.Dish;
import com.example.scopum.Diet.Product;
import com.example.scopum.model.User;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

/**
 * Контекст приложения на данный момент: бот, конкретный пользователь и данные, связанные с ним
 */
public class BotContext {
    private final ChatBot bot;  //телеграм бот
    private final User user;    //пользователь, с которым работает бот
    private final String input; //последний ввод пользователя
    private CallbackQuery callBack;   //объект callBack(кнопки и прочее)
    private final Iterable<Dish> dishes;    // коллекция всех блюд
    private final Iterable<Product> products;


    public Iterable<Dish> getDishes() {
        return dishes;
    }

    public Iterable<Product> getProducts() {
        return products;
    }

    public static BotContext of(ChatBot bot, String input, User user, CallbackQuery callBack, Iterable<Dish> dishes, Iterable<Product> products) {
        return new BotContext(input, user, bot, callBack, dishes, products);
    }

    public BotContext(String input, User user, ChatBot bot, CallbackQuery callBack, Iterable<Dish> dishes, Iterable<Product> products) {
        this.input = input;
        this.user = user;
        this.bot = bot;
        this.callBack = callBack;
        this.dishes = dishes;
        this.products = products;
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
