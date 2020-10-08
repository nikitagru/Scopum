package Diet;

import Bot.JSONParse;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class ProductsFinder extends JSONParse {

    private JSONParse jsonObj = new JSONParse();

    private JSONObject products = jsonObj.productsInit("e:\\JavaProjects\\Scopum\\Scopum\\src\\main\\java\\Diet\\Dishes.json");

    public ProductsFinder() throws ParseException {
        jsonObj.convertJson();
    }


}
