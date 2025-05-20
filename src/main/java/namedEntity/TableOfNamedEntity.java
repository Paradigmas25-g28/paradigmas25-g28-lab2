package namedEntity;

import utils.Tripla;
import java.util.List;

import feed.Article;
import feed.Feed;
import namedEntity.heuristic.*;
import java.util.Map;
import java.util.ArrayList;
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

  public void InitialiceTable() {
    table.put("NamedEntity", 0);
    // INFO: hacer lo que queda con persona,deportes, y todos los topics y
    // categorys;
  }

  public void TheRealFunction(Feed feed, Heuristic hh) {

    for (Article article : feed.getArticleList()) {
      for (NamedEntity ne : article.getListArticles()) {

        // INFO: Aca tambien deberia ser NamedEntity pero esta hardcode para String ya
        // que hay que cambiar Heuristic.java
        String nepapa = hh.getNamedEntity(ne.getName());

        if (nepapa != null) {
          Tripla triplaNeT = new Tripla(ne.getName(), ne.getCategory(), ne.getFrequency().toString());
          Tripla triplaNeC = new Tripla(ne.getName(), ne.getTopic(), ne.getFrequency().toString());
          // Si el category esta en la tabla de jerarquia (que hay q hacer)
          if (table.containsKey(triplaNeC.getSecond())) {
            // INFO: Hay que crear la tabla Iicializada con el arbol de jerarquia y puesto
            // ocurrencias en 0
          }
          // Si el topic esta en la tabla de jerarquia (que hay q hacer)
          if (table.containsKey(triplaNeT.getSecond())) {
            // INFO: Hay que crear la tabla Iicializada con el arbol de jerarquia y puesto
            // ocurrencias en 0
            // INFO: aqui se deberian guardar las triplas en sus respectivas listas.
            //
          }
        }
        // INFO: luego de llenar las listas en el for este de afuera las imprimo en
        // forma de tabla con la info de c/u.
      }
    }
  }

  // Funcion Tester
  public void main(String[] args) {

  }
}
