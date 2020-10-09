package Diet;

import Bot.JSONParse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.List;

public class ProductsFinder extends JSONParse {

    private JSONParse jsonObj = new JSONParse();

    private List<HashMap> productsCalPFC;

    public ProductsFinder() throws ParseException {
        jsonObj.productsInit("e:\\JavaProjects\\Scopum\\Scopum\\src\\main\\java\\Diet\\Dishes.json");
        productsCalPFC = jsonObj.convertJson();
    }
}
