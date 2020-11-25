package com.example.scopum.Bot.botapi;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class BotKeyboard {
    public static SendMessage genderButtons(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Мужчина");
        inlineKeyboardButton1.setCallbackData("Мужчина");
        inlineKeyboardButton2.setText("Женщина");
        inlineKeyboardButton2.setCallbackData("Женщина");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(inlineKeyboardButton2);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return new SendMessage().setChatId(chatId).setText("Какой у вас пол?").setReplyMarkup(inlineKeyboardMarkup);
    }

    public static SendMessage employmentButtons(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("1");
        inlineKeyboardButton1.setCallbackData("1.2");
        inlineKeyboardButton2.setText("2");
        inlineKeyboardButton2.setCallbackData("1.375");
        inlineKeyboardButton3.setText("3");
        inlineKeyboardButton3.setCallbackData("1.55");
        inlineKeyboardButton4.setText("4");
        inlineKeyboardButton4.setCallbackData("1.725");
        inlineKeyboardButton5.setText("5");
        inlineKeyboardButton5.setCallbackData("1.9");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        keyboardButtonsRow3.add(inlineKeyboardButton3);
        List<InlineKeyboardButton> keyboardButtonsRow4 = new ArrayList<>();
        keyboardButtonsRow4.add(inlineKeyboardButton4);
        List<InlineKeyboardButton> keyboardButtonsRow5 = new ArrayList<>();
        keyboardButtonsRow5.add(inlineKeyboardButton5);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        rowList.add(keyboardButtonsRow4);
        rowList.add(keyboardButtonsRow5);

        inlineKeyboardMarkup.setKeyboard(rowList);

        StringBuilder sb = new StringBuilder();
        sb.append("Какой у вас дневной образ жизни?\n");
        sb.append("1. Сидячий без нагрузок\n");
        sb.append("2. Тренировки  1-3 раза в неделю\n");
        sb.append("3. Занятия 3-5 дней в неделю\n");
        sb.append("4. Интенсивные тренировки 6-7 раз в неделю\n");
        sb.append("5. Спортсмены, выполняющие упражнения чаще, чем раз в день(несколько тренировок за день)");

        return new SendMessage().setChatId(chatId).setText(sb.toString()).setReplyMarkup(inlineKeyboardMarkup);
    }

    public static SendMessage choiceButtons(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Дневная диета");
        inlineKeyboardButton1.setCallbackData("Дневная диета");
        inlineKeyboardButton2.setText("Многодневная диета");
        inlineKeyboardButton2.setCallbackData("Многодневная диета");
        inlineKeyboardButton3.setText("Тренировка");
        inlineKeyboardButton3.setCallbackData("Тренировка");
        inlineKeyboardButton4.setText("Профессиональная тренировка");
        inlineKeyboardButton4.setCallbackData("Профессиональная тренировка");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow2.add(inlineKeyboardButton2);
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        keyboardButtonsRow3.add(inlineKeyboardButton3);
        List<InlineKeyboardButton> keyboardButtonsRow4 = new ArrayList<>();
        keyboardButtonsRow4.add(inlineKeyboardButton4);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        rowList.add(keyboardButtonsRow4);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return new SendMessage().setChatId(chatId).setText("Выберите, что вы хотели бы сделать:").setReplyMarkup(inlineKeyboardMarkup);
    }

    public static SendMessage tryToGetCal(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Мужчина");
        inlineKeyboardButton1.setCallbackData("Мужчина");
        inlineKeyboardButton2.setText("Женщина");
        inlineKeyboardButton2.setCallbackData("Женщина");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(inlineKeyboardButton2);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return new SendMessage().setChatId(chatId).setText("Какой у вас пол?").setReplyMarkup(inlineKeyboardMarkup);
    }
}
