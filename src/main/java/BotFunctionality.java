import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface BotFunctionality {
    /**
     * Составление разового дневного рациона питания
     */
    void dailyDiet(User user) throws ParseException, IOException;

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
