package com.example.scopum.Bot.botapi;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public class UserKeyboard {
    public void createKeyboard() {
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
    }
}
