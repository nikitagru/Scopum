package com.example.scopum.Training;

import com.example.scopum.Bot.botapi.BotContext;
import com.example.scopum.Bot.botapi.BotKeyboard;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.Scanner;

public class ProfessionalTraining extends Training{

    private BotContext context;

    public ProfessionalTraining(BotContext context) {
        this.context = context;
    }

    public void formatProfessionalTraining() throws IOException, InterruptedException {
        SendMessage keyboardInput = BotKeyboard.professionalTraining(context.getUser().getChatId());

        try {
            context.getBot().execute(keyboardInput);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        String answer = context.getCallBack().getData();

        switch (answer) {
            case "1":
                badminton();
                break;
            case "2":
                basketball();
                break;
            case "3":
                billiards();
                break;
            case "4":
                boxing();
                break;
            case "5":
                cycling();
                break;
            case "6":
                eSport();
                break;
            case "7":
                tableTennis();
                break;
            case "8":
                football();
                break;
            case "9":
                hockey();
                break;
        }
    }

    private void badminton() throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в бадминтон полезно будет выполнять следующие упражнения:\n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");

        sendMessage(sb.toString());
    }

    private void basketball() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в бадминтон полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");

        sendMessage(sb.toString());
    }

    private void billiards() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в бильярд полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
    }

    private void boxing() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для бокса полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
    }

    private void cycling() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для велоспорта полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
    }

    private void eSport() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в киберспорт полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
    }

    private void tableTennis() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в настольный теннис полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
    }

    private void football() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в футбол полезно будет выполнять следующие упражнения:\n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
    }

    private void hockey() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в хоккей полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
    }

    private void sendMessage(String text) {
        SendMessage message = new SendMessage().setChatId(context.getUser().getChatId())
                .setText(text);

        try {
            context.getBot().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
