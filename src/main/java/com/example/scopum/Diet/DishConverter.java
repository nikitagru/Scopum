package com.example.scopum.Diet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DishConverter {
    /**
     * Конвертирует массив JSON-объектов в массив словарей
     * @param productsArray массив JSON-объектов
     * @return массив словарей
     */
    public static List<HashMap> convertToArray(List<Object> productsArray){
        List<HashMap> converteredProduct = new ArrayList<>();       // массив сконвертированных словарей(вовзращаемое значение)

        for (int i = 0; i < productsArray.size(); i++) {
            Object temp = productsArray.get(i);        // получение i-го блюда
            temp = temp.toString();
            Dish dish = new Dish((String) temp);
            converteredProduct.add(dish.getDish());        // конвертация блюда в словарь
        }

        return converteredProduct;
    }


}
