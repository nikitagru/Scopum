package com.example.scopum.Bot.botapi;

import com.example.scopum.Bot.StrConst;
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

        return new SendMessage().setChatId(chatId).setText(StrConst.askEmployment()).setReplyMarkup(inlineKeyboardMarkup);
    }

    public static SendMessage choiceButtons(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Дневная диета");
        inlineKeyboardButton1.setCallbackData("DailyDiet");
        inlineKeyboardButton2.setText("Многодневная диета");
        inlineKeyboardButton2.setCallbackData("LongDiet");
        inlineKeyboardButton3.setText("Тренировка");
        inlineKeyboardButton3.setCallbackData("NormalTraining");
        inlineKeyboardButton4.setText("Профессиональная тренировка");
        inlineKeyboardButton4.setCallbackData("ProfessionalTraining");

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

    public static SendMessage tryToGetAllergy(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Да");
        inlineKeyboardButton1.setCallbackData("Да");
        inlineKeyboardButton2.setText("Нет");
        inlineKeyboardButton2.setCallbackData("Нет");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(inlineKeyboardButton2);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);

        inlineKeyboardMarkup.setKeyboard(rowList);

        return new SendMessage().setChatId(chatId).setText("Имеете ли вы аллергию на какие-нибудь продукты?").setReplyMarkup(inlineKeyboardMarkup);
    }

    public static SendMessage normalTraining(long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Комплекс упражнений для развития тела");
        inlineKeyboardButton1.setCallbackData("1");
        inlineKeyboardButton2.setText("Комплекс упражнений для похудения");
        inlineKeyboardButton2.setCallbackData("2");
        inlineKeyboardButton3.setText("Упражнения для развития мышц рук");
        inlineKeyboardButton3.setCallbackData("3");
        inlineKeyboardButton4.setText("Упражнения для развития мышц пресса");
        inlineKeyboardButton4.setCallbackData("4");
        inlineKeyboardButton5.setText("Упражнения для развития мышц ног");
        inlineKeyboardButton5.setCallbackData("5");

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

    public static SendMessage professionalTraining(long chatId) {
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
        inlineKeyboardButton1.setCallbackData("1");
        inlineKeyboardButton2.setText("Баскетбол");
        inlineKeyboardButton2.setCallbackData("2");
        inlineKeyboardButton3.setText("Бильярд");
        inlineKeyboardButton3.setCallbackData("3");
        inlineKeyboardButton4.setText("Бокс");
        inlineKeyboardButton4.setCallbackData("4");
        inlineKeyboardButton5.setText("Велоспорт");
        inlineKeyboardButton5.setCallbackData("5");
        inlineKeyboardButton6.setText("Киберспорт");
        inlineKeyboardButton6.setCallbackData("6");
        inlineKeyboardButton7.setText("Настольный теннис");
        inlineKeyboardButton7.setCallbackData("7");
        inlineKeyboardButton8.setText("Футбол");
        inlineKeyboardButton8.setCallbackData("8");
        inlineKeyboardButton9.setText("Хоккей");
        inlineKeyboardButton9.setCallbackData("9");

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
}
