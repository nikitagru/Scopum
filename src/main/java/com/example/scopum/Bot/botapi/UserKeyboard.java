package com.example.scopum.Bot.botapi;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

/**
 * Клавиатура пользователя
 */
public class UserKeyboard {
    private BotContext context;
    public UserKeyboard(BotContext context) {
        this.context = context;
    }

    /**
     * Создание клавиатуры у пользователя
     * @return Объект сообщения
     */
    public SendMessage createKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow firstRow = new KeyboardRow();
        KeyboardRow secondRow = new KeyboardRow();

        replyKeyboardMarkup.setResizeKeyboard(true);

        firstRow.add("Включить трекинг");
        firstRow.add("Выключить трекинг");

        secondRow.add("Отменить последний подсчет КБЖУ");

        keyboardRows.add(firstRow);
        keyboardRows.add(secondRow);

        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return new SendMessage().setChatId(context.getUser().getChatId()).setText("Спасибо!").setReplyMarkup(replyKeyboardMarkup);
    }
}
