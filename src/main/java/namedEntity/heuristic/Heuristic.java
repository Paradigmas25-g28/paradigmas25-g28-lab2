package namedEntity.heuristic;

import java.util.Map;

public abstract class Heuristic {
  // public para poder consultar hasmap
  public static Map<String, String> categoryMap = Map.of(
      "Microsft", "Company",
      "Apple", "Company",
      "Google", "Company",
      "Musk", "Person",
      "Biden", "Person",
      "Trump", "Person",
      "Messi", "Person",
      "Federer", "Person",
      "USA", "Country",
      "Russia", "Country");

  public String getCategory(String entity) {
    return categoryMap.get(entity);
  }

  // INFO: Aca deberia devolver NamedEntity post cambio del Map de arriba que
  // deberia tomar <String,NamedEntity>
  public String getNamedEntity(String entity) {
    return categoryMap.get(entity);
  }

  public abstract boolean isEntity(String word);

}
