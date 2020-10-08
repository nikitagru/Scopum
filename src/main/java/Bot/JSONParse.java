package Bot;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    public List<HashMap> convertJson() {
        products = resultJson.entrySet();
        List<Object> produc = new ArrayList<>();

        products.forEach(entry -> produc.add(entry));

        List<HashMap> converteredProduct = new ArrayList<>();

        for (int i = 0; i < produc.size(); i++) {
            Object temp = produc.get(i);
            temp = temp.toString();
            converteredProduct.add(convertToMap((String) temp));
        }

        return converteredProduct;
    }

    private HashMap<String, double[]> convertToMap(String product) {
        String[] prodcutCalPFC = product.split("=");
        prodcutCalPFC[1] = prodcutCalPFC[1].substring(1);
        prodcutCalPFC[1] = prodcutCalPFC[1].replaceAll("}", "");

        String[] caloriesPFC = prodcutCalPFC[1].split(",");
        double[] calPFC = new double[4];

        for (int i = 0; i < 4; i++) {
            caloriesPFC[i] = caloriesPFC[i].replaceAll("\"","");
            String value = caloriesPFC[i].split(":")[1];
            calPFC[i] = Double.parseDouble(value);
        }

        HashMap<String, double[]> result = new HashMap<>();
        result.put(prodcutCalPFC[0], calPFC);

        return result;
    }
}
