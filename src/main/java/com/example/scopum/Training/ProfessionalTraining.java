package com.example.scopum.Training;

import com.example.scopum.Bot.botapi.BotContext;
import com.example.scopum.Bot.botapi.BotKeyboard;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProfessionalTraining extends Training{

    private BotContext context;

    public ProfessionalTraining(BotContext context) {
        this.context = context;
    }

    public void formatProfessionalTraining() throws IOException, InterruptedException {
        BotKeyboard botKeyboard = new BotKeyboard();
        SendMessage keyboardInput = botKeyboard.professionalTraining(context.getUser().getChatId());

        try {
            context.getBot().execute(keyboardInput);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void invokeTraining(String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method training = this.getClass().getDeclaredMethod(methodName, null);
        training.invoke(this,null);
    }


    private void badmintonTraining() throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в бадминтон полезно будет выполнять следующие упражнения:\n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
        context.getUser().setBotFunction("end");
    }

    private void basketballTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в бадминтон полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
        context.getUser().setBotFunction("end");
    }

    private void billiardsTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в бильярд полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
        context.getUser().setBotFunction("end");
    }

    private void boxTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для бокса полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
        context.getUser().setBotFunction("end");
    }

    private void cycling() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для велоспорта полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
        context.getUser().setBotFunction("end");
    }

    private void cyberSportTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в киберспорт полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
        context.getUser().setBotFunction("end");
    }

    private void tableTennisTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в настольный теннис полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
        context.getUser().setBotFunction("end");
    }

    private void footballTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в футбол полезно будет выполнять следующие упражнения:\n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
        context.getUser().setBotFunction("end");
    }

    private void hockeyTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для игры в хоккей полезно будет выполнять следующие упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
        context.getUser().setBotFunction("end");
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
