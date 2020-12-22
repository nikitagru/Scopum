package com.example.scopum.Diet;
import com.example.scopum.Bot.Message;

import com.example.scopum.Bot.botapi.BotContext;

import java.util.ArrayList;
import java.util.List;

public class ProductFinder {
    //private List<Product> products;
    private BotContext context;

    public ProductFinder(BotContext context) {
        this.context = context;
    }
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

