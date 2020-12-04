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

    public SendMessage tryToGetAllergy(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> buttons;

        buttons = initializeButton(2);

        setData(buttons.get(0), "Да", "Да");
        setData(buttons.get(1), "Нет", "Нет");

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(buttons);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return new SendMessage().setChatId(chatId).setText("Имеете ли вы аллергию на какие-нибудь продукты?").setReplyMarkup(inlineKeyboardMarkup);
    }

    public SendMessage normalTraining(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Комплекс упражнений для развития тела");
        inlineKeyboardButton1.setCallbackData(normalTrainings[0]);
        inlineKeyboardButton2.setText("Комплекс упражнений для похудения");
        inlineKeyboardButton2.setCallbackData(normalTrainings[1]);
        inlineKeyboardButton3.setText("Упражнения для развития мышц рук");
        inlineKeyboardButton3.setCallbackData(normalTrainings[2]);
        inlineKeyboardButton4.setText("Упражнения для развития мышц пресса");
        inlineKeyboardButton4.setCallbackData(normalTrainings[3]);
        inlineKeyboardButton5.setText("Упражнения для развития мышц ног");
        inlineKeyboardButton5.setCallbackData(normalTrainings[4]);

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

        return new SendMessage().setChatId(chatId).setText("Вы выбрали раздел тренировки! Чем хотите заняться сегодня?").setReplyMarkup(inlineKeyboardMarkup);
    }

    public SendMessage professionalTraining(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton7 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton8 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton9 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Бадминтон");
        inlineKeyboardButton1.setCallbackData(professionalTrainings[0]);
        inlineKeyboardButton2.setText("Баскетбол");
        inlineKeyboardButton2.setCallbackData(professionalTrainings[1]);
        inlineKeyboardButton3.setText("Бильярд");
        inlineKeyboardButton3.setCallbackData(professionalTrainings[2]);
        inlineKeyboardButton4.setText("Бокс");
        inlineKeyboardButton4.setCallbackData(professionalTrainings[3]);
        inlineKeyboardButton5.setText("Велоспорт");
        inlineKeyboardButton5.setCallbackData(professionalTrainings[4]);
        inlineKeyboardButton6.setText("Киберспорт");
        inlineKeyboardButton6.setCallbackData(professionalTrainings[5]);
        inlineKeyboardButton7.setText("Настольный теннис");
        inlineKeyboardButton7.setCallbackData(professionalTrainings[6]);
        inlineKeyboardButton8.setText("Футбол");
        inlineKeyboardButton8.setCallbackData(professionalTrainings[7]);
        inlineKeyboardButton9.setText("Хоккей");
        inlineKeyboardButton9.setCallbackData(professionalTrainings[8]);

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
        List<InlineKeyboardButton> keyboardButtonsRow6 = new ArrayList<>();
        keyboardButtonsRow6.add(inlineKeyboardButton6);
        List<InlineKeyboardButton> keyboardButtonsRow7 = new ArrayList<>();
        keyboardButtonsRow6.add(inlineKeyboardButton7);
        List<InlineKeyboardButton> keyboardButtonsRow8 = new ArrayList<>();
        keyboardButtonsRow8.add(inlineKeyboardButton8);
        List<InlineKeyboardButton> keyboardButtonsRow9 = new ArrayList<>();
        keyboardButtonsRow9.add(inlineKeyboardButton9);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        rowList.add(keyboardButtonsRow4);
        rowList.add(keyboardButtonsRow5);
        rowList.add(keyboardButtonsRow6);
        rowList.add(keyboardButtonsRow7);
        rowList.add(keyboardButtonsRow8);
        rowList.add(keyboardButtonsRow9);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return new SendMessage().setChatId(chatId).setText("Вы выбрали раздел профессиональной тренировки! Для начала выберите вид спорта, которым занимаетесь:").setReplyMarkup(inlineKeyboardMarkup);
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
