package parser;

/*
 * Esta clase implementa el parser del  archivo de suscripcion (json)
 * Leer https://www.w3docs.com/snippets/java/how-to-parse-json-in-java.html
 * */
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONTokener;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionParser extends GeneralParser {

    private JSONArray subscriptionArray = null;

    @Override
    public void parse(String path) {
        try {
            // Lee archivo JSON usando FileReader y JSONTokener
            FileReader reader = new FileReader("config/subscription.json");
            this.subscriptionArray = new JSONArray(new JSONTokener(reader));

        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        }
    }

    // Getters
    public JSONObject gJson(int i) {
        if (this.subscriptionArray == null) {
            throw new FileNotFoundException("Json no encontrado");
        }
        return this.subscriptionArray.getJSONObject(i);
    }

    public String gURL(JSONObject json) {
        return json.getString("url");
    }

    public String gURLtype(JSONObject json) {
        return json.getString("urlType");
    }

    public String gDownload(JSONObject json) {
        return json.getString("Download");
    }

    public JSONObject gURLparams(JSONObject json) {
        return json.getJSONObject("UrlParams");
    }
}
