package com.example.scopum.Diet;
import com.example.scopum.Bot.Message;

import com.example.scopum.Bot.botapi.BotContext;

import java.util.ArrayList;
import java.util.List;

public class ProductFinder {
    /**
     * поиск совпадения блюда в БД
     * @param input ввод пользователя
     * @param product итерируемый объект продуктов
     * @return Объект продукта
     */
    public Product getCalPFC(String input, Iterable<Product> product){
        Product result = null;
        for (Product prod : product) {
            if (input.equals(prod.getName())) {
                result = prod;
            }
        }
        return result;
    }

}

