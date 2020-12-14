package com.example.scopum.Diet;

import java.util.HashMap;

public class Dish {
    private double[] calPFC;
    private String name;

    public Dish(String product) {
        initDish(product);
    }

    /**
     * Инициализация блюда
     * @param product Строка блюда(название и бжук)
     */
    private void initDish(String product) {
        product = product.replaceAll("_", " ");     // замена _ на пробел
        product = product.replaceAll("__", "\n");       // замена __ на перенос строки

        String[] prodcutCalPFC = product.split("=");        // 0 - название, 1 - БЖУК
        this.name = prodcutCalPFC[0];
        prodcutCalPFC[1] = prodcutCalPFC[1].substring(1);
        prodcutCalPFC[1] = prodcutCalPFC[1].replaceAll("}", "");        // удаление обрамляющих скобок у БЖУК

        String[] caloriesPFC = prodcutCalPFC[1].split(",");     // разделение всех строк БЖУК
        this.calPFC = new double[4];

        for (int i = 0; i < 4; i++) {
            caloriesPFC[i] = caloriesPFC[i].replaceAll("\"","");
            String value = caloriesPFC[i].split(":")[1];
            calPFC[i] = Double.parseDouble(value);      // добавление в массив одно из БЖУК
        }
    }

    /**
     * Получение блюда в сконвертрованном виде
     * @return Словарь, где ключ - название, значение - БЖУК
     */
    public HashMap<String, double[]> getDish() {
        HashMap<String, double[]> result = new HashMap<>();
        result.put(name, calPFC);

        return result;
    }
}
