package com.example.scopum.Bot;

import com.example.scopum.Bot.botapi.BotContext;
import com.example.scopum.Diet.Product;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

/**
 * Сообщение, отправляемое пользователю
 */
public class Message {
    private String fullRecipe;          //полный текст рецепта с КБЖУ
    private String remUserCalPFC;       //количество оставшихся дневных КБЖУ
    private String ProductCalPFC;

    public String getRemUserCalPFC() {
        return remUserCalPFC;
    }

    public void setRemUserCalPFC(double[] remCalPFC) {
        StringBuilder sb = new StringBuilder();
        sb.append("Вам осталось необходимо употребить:\n");
        sb.append(remCalPFC[0] + " " + "калорий\n");
        sb.append(remCalPFC[1] + " " + "белков\n");
        sb.append(remCalPFC[2] + " " + "жиров\n");
        sb.append(remCalPFC[3] + " " + "углеводов");

        this.remUserCalPFC = sb.toString();
    }

    public void setFullRecipe(String dishName, String recipe, String ingredients, double[] calPFC) {
        StringBuilder sb = new StringBuilder();
        sb.append("Могу предложить вам этот рецепт:\n");
        sb.append(dishName + "\n");
        sb.append(recipe + "\n");
        sb.append(ingredients + "\n");
        sb.append("КБЖУ данного рецепта:\n");
        sb.append(calPFC[0] + " " + "белков" + "\n");
        sb.append(calPFC[1] + " " + "жиров" + "\n");
        sb.append(calPFC[2] + " " + "углеводов" + "\n");
        sb.append(calPFC[3] + " " + "калорий" + "\n");

        this.fullRecipe = sb.toString();
    }

    public String getFullRecipe() {
        return fullRecipe;
    }

    /**
     * Отправление сообщения пользователю
     * @param context контекст приложения
     * @param message текст сообщения
     */
    public void sendMessage(BotContext context, String message) {
        SendMessage sendMessage = new SendMessage().setChatId(context.getUser().getChatId())
                .setText(message);

        try {
            context.getBot().execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(BotContext context, String message, File photo) {
        SendPhoto sendMessage = new SendPhoto().setChatId(context.getUser().getChatId())
                                                .setCaption(message)
                                                .setPhoto(photo);

        try {
            context.getBot().execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Оповещение о некорректном вводе пользователя
     * @param context контекст приложения
     */
    public void informAboutIncorrectUserInput(BotContext context) {
        SendMessage sendMessage = new SendMessage().setChatId(context.getUser().getChatId())
                .setText("Вы ввели некорректное значение, попробуйте снова");
        try {
            context.getBot().execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void setProductCalPFC (Product product)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(product.getName() + "\n");
        sb.append("КБЖУ:" + "\n");
        sb.append(product.getCalories() + " Калорий" + "\n");
        sb.append(product.getProteins() + " Белков" + "\n");
        sb.append(product.getFat() + " Жиров" + "\n");
        sb.append(product.getCarbohydrates() + " Углеводов" + "\n");
        this.ProductCalPFC = sb.toString();

    }

    public String getProductCalPFC() {
        return ProductCalPFC;
    }
}
