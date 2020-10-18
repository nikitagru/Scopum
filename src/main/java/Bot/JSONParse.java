package Bot;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class JSONParse {

    public Set products = new Set() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public Object[] toArray(Object[] objects) {
            return new Object[0];
        }

        @Override
        public boolean add(Object o) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection collection) {
            return false;
        }

        @Override
        public boolean addAll(Collection collection) {
            return false;
        }

        @Override
        public boolean retainAll(Collection collection) {
            return false;
        }

        @Override
        public boolean removeAll(Collection collection) {
            return false;
        }

        @Override
        public void clear() {

        }
    };
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
        //products = resultJson.entrySet();       // конвертация объекта JSON в множество Set
        List<Object> produc = new ArrayList<>();        // массив всех блюд

        resultJson.entrySet().forEach(entry -> produc.add(entry));       // добавление в массив блюд

        List<HashMap> converteredProduct = new ArrayList<>();       // массив сконвертированных словарей(вовзращаемое значение)

        for (int i = 0; i < produc.size(); i++) {
            Object temp = produc.get(i);        // получение i-го блюда
            temp = temp.toString();
            converteredProduct.add(convertToMap((String) temp));        // конвертация блюда в словарь
        }

        return converteredProduct;
    }

    /**
     * Конвертация JSON объекта рецептов
     * @return Возвращает массив словарей, где ключ - название блюда, значение - рецепт и ингридиенты
     */
    public List<HashMap> convertRecipes() {
        products = resultJson.entrySet();       // конвертация объекта JSON в множество Set
        List<Object> rec = new ArrayList<>();        // массив всех рецептов

        products.forEach(entry -> rec.add(entry));      // добавление в массив рецептов

        List<HashMap> converteredProduct = new ArrayList<>();       // сконвертированные рецепты(вовзращаемое значение)

        for (int i = 0; i < rec.size(); i++) {
            Object temp = rec.get(i);       // получение i-го рецепта
            temp = temp.toString();
            converteredProduct.add(convertToMapRecipes((String) temp));     // конвертация рецепта в словарь
        }

        return converteredProduct;
    }

    /**
     * Конвертация блюда в словарь
     * @param product Строка блюда(название и бжук)
     * @return Возвращает словарь, где ключ - название блюда, значение - БЖУК
     */
    private HashMap<String, double[]> convertToMap(String product) {
        product = product.replaceAll("_", " ");     // замена _ на пробел
        product = product.replaceAll("__", "\n");       // замена __ на перенос строки

        String[] prodcutCalPFC = product.split("=");        // 0 - название, 1 - БЖУК
        prodcutCalPFC[1] = prodcutCalPFC[1].substring(1);
        prodcutCalPFC[1] = prodcutCalPFC[1].replaceAll("}", "");        // удаление обрамляющих скобок у БЖУК

        String[] caloriesPFC = prodcutCalPFC[1].split(",");     // разделение всех строк БЖУК
        double[] calPFC = new double[4];

        for (int i = 0; i < 4; i++) {
            caloriesPFC[i] = caloriesPFC[i].replaceAll("\"","");
            String value = caloriesPFC[i].split(":")[1];
            calPFC[i] = Double.parseDouble(value);      // добавление в массив одно из БЖУК
        }

        HashMap<String, double[]> result = new HashMap<>();
        result.put(prodcutCalPFC[0], calPFC);

        return result;
    }

    /**
     * Конвертация рецептов в словарь
     * @param product Строка рецепта(название и рецепт с ингридиентами)
     * @return Возвращает словарь, где ключ - название блюда, значение - рецепт и ингридиенты
     */
    private HashMap<String, String[]> convertToMapRecipes(String product) {
        product = product.replaceAll("__", "\n");
        product = product.replaceAll("_", " ");

        String[] recipe = product.split("=");       // первое значение - название блюда, второе - рецепт и ингредиенты
        recipe[1] = recipe[1].substring(1);
        recipe[1] = recipe[1].replaceAll("}", "");

        String ingrText = recipe[1].substring(recipe[1].lastIndexOf(",") + 1);
        String recText = recipe[1].substring(0, recipe[1].lastIndexOf(","));

        String[] recipeIngr = new String[]{recText, ingrText};     // получение элементов через запятую
        String[] recipeText = new String[2];        // текст рецепта и ингредиенты (1 - рецепт, 2 - ингредиенты)

        for (int i = 0; i < 2; i++) {
            recipeIngr[i] = recipeIngr[i].replaceAll("\"","");
            String value = recipeIngr[i].split(":")[1];
            recipeText[i] = value;
        }

        HashMap<String, String[]> result = new HashMap<>();
        result.put(recipe[0], recipeText);      // первое значение - название блюда, второе - рецепт и ингредиенты

        return result;
    }
}
