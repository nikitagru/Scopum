
import com.example.scopum.Diet.DishesFinder;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DietTest {
    private double getCallories(DishesFinder finder) {
        HashMap<String[], double[]> result = finder.getDishDaily();
        Map.Entry<String[], double[]> currentDish = result.entrySet().iterator().next();
        double[] dishCalPFC = currentDish.getValue();

        return dishCalPFC[0];
    }
    @Test
    void simple() {
//        double[] calPFC = new double[] {500.0, 12.2, 14.5, 45.0};
//        ProductsFinder finder = new ProductsFinder(calPFC, null);
//        double result = getCallories(finder);
//        assertTrue(result > 0);
    }

    @Test
    void simpleFasle() {
//        double[] calPFC = new double[] {0.0, 12.2, 14.5, 45.0};
//        ProductsFinder finder = new ProductsFinder(calPFC, null);
//        double result = getCallories(finder);
//        assertTrue(result == 0.0);
    }
}
