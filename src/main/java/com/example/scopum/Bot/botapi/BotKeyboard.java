package com.example.scopum.Bot.botapi;

import com.example.scopum.Bot.BotVisualizer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class BotKeyboard implements Keyboard{

    private static final String[] normalTrainings = {"bodyTraining", "slimingTraining", "armsTraining", "pressTraining", "legsTraining"};
    private static final String[] professionalTrainings = {"badmintonTraining", "basketballTraining", "billiardsTraining", "boxTraining", "cycling", "cyberSportTraining", "tableTennisTraining", "footballTraining", "hockeyTraining" };

    public static String[] getNormalTrainings() {
        return normalTrainings;
    }

    public static String[] getProfessionalTrainings() {
        return professionalTrainings;
    }

    public SendMessage genderButtons(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> buttons;

        buttons = initializeButton(2);

        buttons.get(0).setText("Мужчина");
        buttons.get(0).setCallbackData("Мужчина");
        buttons.get(1).setText("Женщина");
        buttons.get(1).setCallbackData("Женщина");

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(buttons);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return new SendMessage().setChatId(chatId).setText("Какой у вас пол?").setReplyMarkup(inlineKeyboardMarkup);
    }

    public SendMessage employmentButtons(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> buttons;
        buttons = initializeButton(5);

        setData(buttons.get(0), "1", "1.2");
        setData(buttons.get(1), "2", "1.375");
        setData(buttons.get(2), "3", "1.55");
        setData(buttons.get(3), "4", "1.725");
        setData(buttons.get(4), "5", "1.9");

        inlineKeyboardMarkup.setKeyboard(createGrid(buttons));

        return new SendMessage().setChatId(chatId).setText(BotVisualizer.askEmployment()).setReplyMarkup(inlineKeyboardMarkup);
    }

    public SendMessage choiceButtons(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> buttons;

        buttons = initializeButton(4);

        setData(buttons.get(0), "Дневная диета", "DailyDiet");
        setData(buttons.get(1), "Многодневная диета", "LongDiet");
        setData(buttons.get(2), "Тренировка", "NormalTraining");
        setData(buttons.get(3), "Профессиональная тренировка", "ProfessionalTraining");

        inlineKeyboardMarkup.setKeyboard(createGrid(buttons));

        return new SendMessage().setChatId(chatId).setText("Выберите, что вы хотели бы сделать:").setReplyMarkup(inlineKeyboardMarkup);
    }

    private List<InlineKeyboardButton> initializeButton(int count) {
        List<InlineKeyboardButton> buttons = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            buttons.add(new InlineKeyboardButton());
        }

        return buttons;
    }

    private void setData(InlineKeyboardButton button, String buttonCaption, String buttonCallBack) {
        button.setText(buttonCaption);
        button.setCallbackData(buttonCallBack);
    }

    private List<List<InlineKeyboardButton>> createGrid(List<InlineKeyboardButton> buttons) {
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        for (int i = 0; i < buttons.size(); i++) {
            List<InlineKeyboardButton> inlineButton = new ArrayList<>();
            inlineButton.add(buttons.get(i));
            rowList.add(inlineButton);
        }

        return rowList;
    }
}
