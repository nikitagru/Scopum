import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface BotFunctionality {
    /**
     * Составление разового дневного рациона питания
     */
    void dailyDiet(double weight, int growth, int age, String gender, double employment) throws IOException, ParseException;

    /**
     * Составление продолжительной диеты
     */
    void longDiet();

    /**
     * Составление тренировки для обычного человека
     */
    void normalTraining();

    /**
     * Составление тренировки для спортсмена
     */
    void professionalTraining();


}
