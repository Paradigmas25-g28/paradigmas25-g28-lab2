package parser;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import subscription.SingleSubscription;
import subscription.Subscription;

import feed.Article;

import httpRequest.httpRequester;


/*
 * Esta clase implementa el parser de feed de tipo reddit (json)
 * pero no es necesario su implemntacion 
 * */

public class RedditParser extends JsonParser {

  private List<Article> articles;

  @Override
  public void parse(String path) {
    this.articles = new ArrayList<>();
    try {
      String oneJSON = Files.readString(new File(path).toPath());
    
      JSONObject json = new JSONObject(oneJSON);
      JSONArray children = json.getJSONObject("data").getJSONArray("children");

      for (int i = 0; i < children.length(); i++) {
        JSONObject postData = children.getJSONObject(i).getJSONObject("data");

        String title = postData.optString("title", "No title");
        String description = postData.optString("selftext", ""); 
        long timestamp = postData.optLong("created_utc", System.currentTimeMillis() / 1000);
        Date pubDate = new Date(timestamp * 1000); 
        String link = postData.optString("url", "");
      

          articles.add(new Article(title, description, pubDate, link));
      }
    } catch (Exception e) {
      System.err.println("Error al parsear json: " + e.getMessage());
      this.articles = null;
    }
  }

  public List<Article> getArticles() {
    return articles;
  }

  public static void main(String[] args) {
    SubscriptionParser parser = new SubscriptionParser();
    parser.parse("config/subscriptions.json");

    httpRequester requester = new httpRequester();

    String urlFormat = parser.getSingleSubscription(0).getUrl();
    String topic = parser.getSingleSubscription(0).getUrlParams(0);
    String urlFinal = String.format(urlFormat, topic);
    System.out.println(urlFinal);

    System.out.println(requester.getFeedRedditToFile(urlFinal));

    File file = requester.getFeedRedditToFile(urlFinal);

    RedditParser redditparser = new RedditParser();
    redditparser.parse(file.getPath());

    // Imprimo lo que me devuelve RedditParser

    for (Article xArticle : redditparser.getArticles())
      xArticle.prettyPrint();
  }
}
