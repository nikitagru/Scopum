package com.example.scopum.Bot.botapi;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface Keyboard {

    /**
     * Кнопки выбора пола
     * @param chatId чат id пользователя
     * @return Возвращает сообщение с кнопками выбора пола
     */
    SendMessage genderButtons(long chatId);

    /**
     * Кнопки выбора уровня дневной занятости
     * @param chatId чат id пользователя
     * @return Возвращает сообщение с кнопками выбора уровня занятости
     */
    SendMessage employmentButtons(long chatId);

    /**
     * Кнопки выбора основных функций бота
     * @param chatId чат id пользователя
     * @return Возвращает сообщение с кнопками выбора функции бота
     */
    SendMessage choiceButtons(long chatId);
}
