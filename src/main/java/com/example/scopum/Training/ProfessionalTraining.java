package com.example.scopum.Training;

import com.example.scopum.Bot.botapi.BotContext;
import com.example.scopum.Bot.botapi.BotKeyboard;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

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
                badmintonTraining();
                break;
            case "2":
                basketballTraining();
                break;
            case "3":
                billiardsTraining();
                break;
            case "4":
                boxTraining();
                break;
            case "5":
                cycling();
                break;
            case "6":
                cyberSportTraining();
                break;
            case "7":
                tableTennisTraining();
                break;
            case "8":
                footballTraining();
                break;
            case "9":
                hockeyTraining();
                break;
        }
    }

    private void badmintonTraining() throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в бадминтон полезно будет выполнять следующие упражнения:\n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");

        sendMessage(sb.toString());
    }

    private void basketballTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в бадминтон полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");

        sendMessage(sb.toString());
    }

    private void billiardsTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в бильярд полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
    }

    private void boxTraining() throws InterruptedException {
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

    private void cyberSportTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в киберспорт полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
    }

    private void tableTennisTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в настольный теннис полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
    }

    private void footballTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в футбол полезно будет выполнять следующие упражнения:\n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
    }

    private void hockeyTraining() throws InterruptedException {
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
