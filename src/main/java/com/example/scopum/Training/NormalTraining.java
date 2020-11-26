package com.example.scopum.Training;

import com.example.scopum.Bot.botapi.BotContext;
import com.example.scopum.Bot.botapi.BotKeyboard;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.Scanner;

public class NormalTraining extends Training {

    private BotContext context;

    public NormalTraining(BotContext context) {
        this.context = context;
    }

    public void formatNormalTraining() throws IOException, InterruptedException {
        SendMessage keyboardInput = BotKeyboard.normalTraining(context.getUser().getChatId());

        try {
            context.getBot().execute(keyboardInput);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        String answer = context.getCallBack().getData();

        switch (answer) {
            case "1":
                developmentBody();
                break;
            case "2":
                theSlim();
                break;
            case "3":
               armsMuscles();
                break;
            case "4":
                abdominalMuscles();
                break;
            case "5":
                legsMuscles();
                break;
        }
    }

    private void developmentBody() throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для развития вашего тела подойдут эти упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
    }

    private void theSlim() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для похудения вам подойдут эти упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
    }

    private void armsMuscles() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для развития мышц рук вам подойдут эти упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей");
        sendMessage(sb.toString());
    }

    private void abdominalMuscles() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для развития мышц пресса вам подойдут эти упражнения: \n");
        sb.append("Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса");

        sendMessage(sb.toString());
    }

    private void legsMuscles() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для развития мышц ног вам подойдут эти упражнения:\n");
        sb.append("Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");

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
