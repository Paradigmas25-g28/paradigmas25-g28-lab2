package parser;

/*
 * Esta clase implementa el parser del  archivo de suscripcion (json)
 * Leer https://www.w3docs.com/snippets/java/how-to-parse-json-in-java.html
 * */
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import org.json.JSONTokener;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionParser extends GeneralParser {

    private List<Subscription> subscriptions = new ArrayList<>();

    @Override
    public void parse(String path) {
        try {
            // Lee archivo JSON usando FileReader y JSONTokener
            FileReader reader = new FileReader("config/subscription.json");
            JSONArray subscriptionArray = new JSONArray(new JSONTokener(reader));
            for (int i = 0; i < subscriptionArray.length(); i++) {
                JSONObject subscription = subscriptionArray.getJSONObject(i);

                // Leer datos del objeto JSON
                String url = subscription.getString("url");
                String urlType = subscription.getString("urlType");

                System.out.println("URL: " + url);
                System.out.println("URL Type: " + urlType);
                subscriptions.add(new Subscription(url, urlType));
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error al parsear el archivo JSON: " + e.getMessage());
        }
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }
}
