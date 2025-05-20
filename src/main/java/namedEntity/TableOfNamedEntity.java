package namedEntity;

import utils.Tripla;
import java.util.List;

import feed.Article;
import feed.Feed;
import httpRequest.httpRequester;
import namedEntity.heuristic.*;
import parser.RssParser;
import parser.SubscriptionParser;
import subscription.SingleSubscription;

import java.util.Map;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TableOfNamedEntity {
  List<Tripla> dataTableTopic = new ArrayList<Tripla>();;
  List<Tripla> dataTableCategory;
  Map<String, Integer> table;

  public TableOfNamedEntity() {
    this.dataTableTopic = new ArrayList<Tripla>();
    this.dataTableCategory = new ArrayList<Tripla>();
    this.table = new HashMap<String, Integer>();
  }

  private static List<String> ListKeys = Arrays.asList(
      "NamedEntity",
      "Person",
      "Place",
      "Other Category",
      "Company",
      "Product",
      "Event",
      "Date",
      "Topic",
      "Other Topic",
      "Sports",
      "Football",
      "Basketball",
      "Tennis",
      "Formula1",
      "Other Sport",
      "Culture",
      "Film",
      "Music",
      "Other Culture",
      "Politics",
      "National Politics",
      "International Politics",
      "Other Politics");

  public void InitialiceTable() {
    for (String elem : ListKeys) {
      table.put(elem, 0);
    }
  }

  public void TheRealFunction(Feed feed, Heuristic hh) {

    for (Article article : feed.getArticleList()) {

      article.computeNamedEntities(hh);

      List<NamedEntity> listEntities = article.getListArticles();

      InitialiceTable();

      table.put("NamedEntity", listEntities.size());

      for (NamedEntity ne : listEntities) {
        Integer frequency = ne.getFrequency();
        NamedEntity nepapa = hh.getNamedEntity(ne.getName());
        if (nepapa != null) {

          String category = nepapa.getCategory();
          String topic = nepapa.getTopic();
          // Integer frequency = nepapa.getFrequency();
          System.out.println(frequency);
          String name = nepapa.getName();

          table.put(category, table.get(category) + frequency);
          table.put(topic, table.get(topic) + frequency);

          Tripla triplaNeT = new Tripla(name, category, frequency.toString());
          Tripla triplaNeC = new Tripla(name, topic, frequency.toString());

          dataTableCategory.add(triplaNeC);
          dataTableTopic.add(triplaNeT);

          System.err.println("NAME -> " + name);
          System.err.println("FREQ -> " + frequency);
          System.err.println(category);

          System.err.println("Tabla[" + category + "] : " +
              table.get(category).toString());
          System.err.println(topic);
          System.err.println("Tabla[" + topic + "] : " + table.get(topic).toString());
          System.err.println("----------------------------------------------------------------------");
        }
      }
    }
  }

  public static void prettyPrint(String str) {

  }

  // Funcion Tester
  public static void main(String[] args) {
    System.out.println("Compilo");

    QuickHeuristic qh = new QuickHeuristic();
    List<Feed> feedl = new ArrayList<Feed>();
    SubscriptionParser parser = new SubscriptionParser();
    parser.parse("config/subscriptions.json");
    httpRequester requester = new httpRequester();

    for (SingleSubscription subscription : parser.getSubscriptions()) {
      if (subscription.getUrlType().equalsIgnoreCase("rss")) {
        String urlFormat = subscription.getUrl();

        for (String topic : subscription.getUrlParams()) {
          try {
            String finalUrl = String.format(urlFormat, topic);

            System.out.println("Descargando RSS desde: " + finalUrl);
            File rssXml = requester.getFeedRssToFile(finalUrl);

            RssParser rssParser = new RssParser();
            rssParser.parse(rssXml.getPath());

            String siteName = subscription.getUrlType().toUpperCase() + " - " + topic;

            Feed feed = new Feed(siteName);

            for (Article article : rssParser.getArticles()) {
              feed.addArticle(article);
            }
            feedl.add(feed);

          } catch (Exception e) {
            System.err.println("Error al procesar el feed RSS para el topic: " + topic);
            e.printStackTrace();
          }
        }
      }
    }

    List<Feed> feedlpapa = feedl;
    for (Feed feed : feedlpapa) {

      TableOfNamedEntity tablita = new TableOfNamedEntity();
      tablita.TheRealFunction(feed, qh);

      // System.out.println("Tabla global de ocurrencias de entidades nombradas");
      // tablita.prettyPrint("Global");
      // System.out.println("Tabla de ocurrencias de categorias y topicos");
      // tablita.prettyPrint("Class");
      // System.out.println("Tabla de ocurrencias de categorias y topicos");

    }

  }
}
