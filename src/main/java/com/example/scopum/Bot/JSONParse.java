package com.example.scopum.Bot;

import com.example.scopum.Diet.DishConverter;
import com.example.scopum.Diet.Reciptes;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class JSONParse {

    private JSONObject resultJson;

    /**
     * Инициализирует список блид
     * @param path путь до файла JSON
     * @return Возвращает JSON объект блюд
     * @throws ParseException Ошибка конвертации
     */
    public JSONObject productsInit(String path) throws ParseException {
        StringBuilder jsonStrBuilder = new StringBuilder();
        Scanner inputScanner;

        try {
            inputScanner = new Scanner(new File(path));
            while(inputScanner.hasNext()) // Цикл чтения из файла
                jsonStrBuilder.append(inputScanner.next());
            inputScanner.close();
        }
        catch(FileNotFoundException e){
            System.err.println(e.toString());
        }

        org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();

        try{
            resultJson = (JSONObject) jsonParser.parse(jsonStrBuilder.toString());
        }
        catch(ParseException e){
            System.err.println(e.toString());
        }

        resultJson = (JSONObject) jsonParser.parse(jsonStrBuilder.toString());

        return resultJson;
    }

    /**
     * Конвертация JSON объекта продуктов
     * @return Возвращает массив словарей, где ключ - название блюда, значение - БЖУК
     */
    public List<HashMap> convertJson() {
        List<Object> produc = new ArrayList<>();        // массив всех блюд

        resultJson.entrySet().forEach(entry -> produc.add(entry));       // добавление в массив блюд

        return DishConverter.convertToArray(produc);
    }

    /**
     * Конвертация JSON объекта рецептов
     * @return Возвращает массив словарей, где ключ - название блюда, значение - рецепт и ингридиенты
     */
    public List<HashMap> convertRecipes() {
        List<Object> rec = new ArrayList<>();        // массив всех рецептов

        resultJson.entrySet().forEach(entry -> rec.add(entry));      // добавление в массив рецептов

        return Reciptes.convertToArray(rec);      // сконвертированные рецепты(вовзращаемое значение)
    }


}
