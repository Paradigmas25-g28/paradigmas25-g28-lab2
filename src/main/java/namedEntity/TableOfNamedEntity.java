package namedEntity;

import utils.Tripla;
import java.util.List;

import feed.Article;
import feed.Feed;
import namedEntity.heuristic.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TableOfNamedEntity {
  List<Tripla> dataTableTopic;
  List<Tripla> dataTableCategory;
  Map<String, Integer> table;

  public TableOfNamedEntity() {
    this.dataTableTopic = new ArrayList<Tripla>();
    this.dataTableCategory = new ArrayList<Tripla>();
    this.table = new HashMap<String, Integer>();
  }

  private static List<String> ListKeys = Arrays.asList(
      "NamedEntity",
      "persona",
      "apellido",
      "nombre",
      "título",
      "lugar",
      "país",
      "ciudad",
      "dirección",
      "otro",
      "organización",
      "producto",
      "evento",
      "fecha",
      "tema",
      "deportes",
      "fútbol",
      "básquet",
      "tenis",
      "fórmula 1",
      "otros",
      "cultura",
      "cine",
      "música",
      "política",
      "nacional",
      "internacional");

  public void InitialiceTable() {
    for (String elem : ListKeys) {
      table.put(elem, 0);
    }
  }

  public void TheRealFunction(Feed feed, Heuristic hh) {

    for (Article article : feed.getArticleList()) {
      // INFO: solo deja NE mapeadas en diccionario de heuristica

      article.computeNamedEntities(hh);

      List<NamedEntity> listEntities = article.getListArticles();

      table.put("NamedEntity", listEntities.size());

      for (NamedEntity ne : listEntities) {

        // INFO: Aca tambien deberia ser NamedEntity pero esta hardcode para String ya
        // que hay que cambiar Heuristic.java

        if(!(ne.getCategory == null && ne.getTopic==null)){
        Tripla triplaNeT = new Tripla(ne.getName(), ne.getCategory(), ne.getFrequency().toString());
        Tripla triplaNeC = new Tripla(ne.getName(), ne.getTopic(), ne.getFrequency().toString());
        datatTableCategory.add(triplaNeC); 
        datatTableTopic.add(triplaNeT); 
        }
      }
      System.out.println(datatTableCategory.toString());
      System.out.println(datatTableCategory.toString());
    }
  }

  // Funcion Tester
  public void main(String[] args) {

  }
}
