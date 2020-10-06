package Diet;

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

public class FindProducts {

    private HashMap calPFC = new HashMap<String, String>();

    private HashMap dishes = new HashMap<String, HashMap>();

    public void productsInit() throws ParseException {
        StringBuilder jsonStrBuilder = new StringBuilder();
        Scanner inputScanner;

        try {
            inputScanner = new Scanner(new File("e:\\JavaProjects\\Scopum\\Scopum\\src\\main\\java\\Diet\\Dishes.json"));
            while(inputScanner.hasNext()) // Цикл чтения из файла
                jsonStrBuilder.append(inputScanner.next());
            inputScanner.close();
        }
        catch(FileNotFoundException e){
            System.err.println(e.toString());
        }

        JSONParser jsonParser = new JSONParser();
        JSONObject resultJson; // Объект со всеми данными из JSON файла
        try{
            resultJson = (JSONObject) jsonParser.parse(jsonStrBuilder.toString());
        }
        catch(ParseException e){
            System.err.println(e.toString());
        }

        resultJson = (JSONObject) jsonParser.parse(jsonStrBuilder.toString());

    }


//    public String findDailyProducts(double[] calPFC) {
//
//
//
//    }
}
