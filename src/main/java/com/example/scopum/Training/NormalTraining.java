package com.example.scopum.Training;

import com.example.scopum.Bot.botapi.BotContext;
import com.example.scopum.Bot.botapi.BotKeyboard;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NormalTraining extends Training {

    private BotContext context;

    public NormalTraining(BotContext context) {
        this.context = context;
    }

    public void formatNormalTraining() throws IOException, InterruptedException {
        BotKeyboard botKeyboard = new BotKeyboard();
        SendMessage keyboardInput = botKeyboard.normalTraining(context.getUser().getChatId());

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

    private void bodyTraining() throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для развития вашего тела подойдут эти упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
        context.getUser().setBotFunction("end");
    }

    private void slimingTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для похудения вам подойдут эти упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей - Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса - Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
        sendMessage(sb.toString());
        context.getUser().setBotFunction("end");
    }

    private void armsTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для развития мышц рук вам подойдут эти упражнения: \n");
        sb.append("Подтягивания - Отжимания - Использование_гантелей");
        sendMessage(sb.toString());
        context.getUser().setBotFunction("end");
    }

    private void pressTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для развития мышц пресса вам подойдут эти упражнения: \n");
        sb.append("Основная_планка - Боковая_планка - Качание_пресса - Растягивание_мышц_пресса");
        sendMessage(sb.toString());
        context.getUser().setBotFunction("end");
    }

    private void legsTraining() throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        sb.append("Я думаю, что для развития мышц ног вам подойдут эти упражнения:\n");
        sb.append("Приседания - Выпады_ногами - Зашагивания - Тяга_на_одной_ноге");
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
