import java.io.File;
import java.util.ArrayList;
import java.util.List;

import feed.Article;
import feed.Feed;
import httpRequest.httpRequester;
import namedEntity.TableOfNamedEntity;
import namedEntity.heuristic.QuickHeuristic;
import namedEntity.heuristic.RandomHeuristic;
import parser.RssParser;
import parser.SubscriptionParser;
import subscription.SingleSubscription;
import subscription.Subscription;

public class FeedReaderMain {

  private static void printHelp() {
    System.out.println("Please, call this program in correct way: FeedReader [-ne]");
  }

  public static void main(String[] args) {
    System.out.println("************* FeedReader version 1.0 *************");
    if (args.length == 0) {

      // INFO: Leer el archivo de suscription por defecto;
      SubscriptionParser parser = new SubscriptionParser();
      parser.parse("config/subscriptions.json");

      // INFO: Llamar al httpRequester para obtenr el feed del servidor
      httpRequester requester = new httpRequester();

      QuickHeuristic qh = new QuickHeuristic();
      List<Feed> feedl = new ArrayList<Feed>();
      for (SingleSubscription subscription : parser.getSubscriptions()) {
        // INFO: Llamar al Parser especifico para extrar los datos necesarios por la
        // aplicacion
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

              // INFO: Llamar al constructor de Feed
              Feed feed = new Feed(siteName);

              for (Article article : rssParser.getArticles()) {
                feed.addArticle(article);
              }

              feedl.add(feed);

              // INFO: LLamar al prettyPrint del Feed para ver los articulos del feed en forma
              // legible y amigable para el usuario
              for (Feed xfeed : feedl) {
                xfeed.prettyPrint();
              }

            } catch (Exception e) {
              System.err.println("Error al procesar el feed RSS para el topic: " + topic);
              e.printStackTrace();
            }
          }
        }
      }

    } else if (args.length == 1) {

      // INFO: Leer el archivo de suscription por defecto;
      SubscriptionParser parser = new SubscriptionParser();
      parser.parse("config/subscriptions.json");

      // INFO: Llamar al httpRequester para obtenr el feed del servidor
      httpRequester requester = new httpRequester();

      List<Feed> feedl = new ArrayList<Feed>();
      for (SingleSubscription subscription : parser.getSubscriptions()) {
        // INFO: Llamar al Parser especifico para extrar los datos necesarios por la
        // aplicacion
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

              // INFO: Llamar al constructor de Feed
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

      // INFO: Llamar a la heuristica para que compute las entidades nombradas de cada
      // articulos del feed
      QuickHeuristic qh = new QuickHeuristic();
      List<Feed> feedlpapa = feedl;
      for (Feed feed : feedlpapa) {

        TableOfNamedEntity tablita = new TableOfNamedEntity();
        tablita.TheRealFunction(feed, qh);

        // INFO: LLamar al prettyPrint de la tabla de entidades nombradas del feed.

        tablita.prettyPrint();
      }

    } else if (args.length == 2) {
      // INFO: Leer el archivo de suscription por defecto;
      SubscriptionParser parser = new SubscriptionParser();
      parser.parse("config/subscriptions.json");

      // INFO: Llamar al httpRequester para obtenr el feed del servidor
      httpRequester requester = new httpRequester();

      List<Feed> feedl = new ArrayList<Feed>();
      for (SingleSubscription subscription : parser.getSubscriptions()) {
        // INFO: Llamar al Parser especifico para extrar los datos necesarios por la
        // aplicacion
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

              // INFO: Llamar al constructor de Feed
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

      // INFO: Llamar a la heuristica para que compute las entidades nombradas de cada
      // articulos del feed
      if (args[1].equals("-qh")) {
        QuickHeuristic qh = new QuickHeuristic();
        List<Feed> feedlpapa = feedl;
        for (Feed feed : feedlpapa) {

          TableOfNamedEntity tablita = new TableOfNamedEntity();
          tablita.TheRealFunction(feed, qh);

          // INFO: LLamar al prettyPrint de la tabla de entidades nombradas del feed.

          tablita.prettyPrint();
        }
      } else if (args[1].equals("-rh")) {
        RandomHeuristic rh = new RandomHeuristic();
        List<Feed> feedlpapa = feedl;
        for (Feed feed : feedlpapa) {

          TableOfNamedEntity tablita = new TableOfNamedEntity();
          tablita.TheRealFunction(feed, rh);

          // INFO: LLamar al prettyPrint de la tabla de entidades nombradas del feed.

          tablita.prettyPrint();
        }
      } else {
        System.err.println("Segundo argumento no valido");
        return;
      }

    } else {
      printHelp();
    }
  }

}
