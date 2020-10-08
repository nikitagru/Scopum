package Bot;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class JSONParse {

    public HashMap<String, double[]> products = new HashMap<String, double[]>();
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

    public HashMap<String, double[]> convertJson() {
        String result = resultJson.toJSONString();

        String[] resultTable = result.split(":");

        System.out.println(resultTable);
        return products;
    }


//    public String findDailyProducts(double[] calPFC) {
//
//
//
//    }
}
