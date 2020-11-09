package Training;
/**
 * Распределение тренировок между мужчинами и женщинами
 * Есть вопросы - стоит спросить!!!
 */
abstract public class Training {
    protected double computeTrainingCal(String gender, double weight, int growth, int age, double employment) {
        if (gender == "male") {
            double result = (1 * weight) + (0.05 * growth) - (0.01 * age) * employment;
            return result;
        } else {
            double result = (1 * weight) + (0.01 * growth) - (0.01 * age) * employment;
            return result;
        }
    }

    //protected double[] computeUserCalTRN(String gender, double weight, int growth, int age, double employment) {}
}
