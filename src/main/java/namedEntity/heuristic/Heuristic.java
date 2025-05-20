package namedEntity.heuristic;
import namedEntity.NamedEntity;
import namedEntity.category;
import namedEntity.topics;
import namedEntity.category.organization.Company;
import namedEntity.category.organization.Organization;
import namedEntity.category.person.Person;
import namedEntity.category.person.Name;
import namedEntity.category.person.LastName;
import namedEntity.category.person.Title;
import namedEntity.category.place.Ciudad;
import namedEntity.category.place.Direction;
import namedEntity.category.place.Pais;

import java.util.Map;

public abstract class Heuristic {
  // public para poder consultar hasmap
  static Name n_musk = (new Name("elon", "hebrew", "ELON"));
  static LastName ln_musk = (new LastName("musk", "english"));
  static Title t_musk = (new Title("Phisics", true));
  static Name n_messi = (new Name("lionel andres", "frances", "goat"));
  static LastName ln_messi = (new LastName("messi", "italiano"));
  static Title t_messi = (new Title("football player", false));
  static Name n_biden = (new Name ("joseph robinette", "biblico", "JOE"));
  static LastName ln_biden = (new LastName ("biden", "irlandes"));
  static Title t_biden = (new Title ("Law", true));
  static Name n_trump = (new Name ("donald","gaelic", "DONALD"));
  static LastName ln_trump = (new LastName("trump", "german"));
  static Title t_trump = (new Title("economist", true));
  static Name n_federer = (new Name("roger", "german", "ROGER"));
  static LastName ln_federer = (new LastName("federer", "swiss"));
  static Title t_federer = (new Title("tennis player", false));

  static Ciudad c_USA;
  static Pais p_USA;
  static Direction d_USA;
  static Other o_USA;
  static Ciudad c_Russia;
  static Pais p_Russia;
  static Direction d_Russia;
  static Other o_Russia;

  public static Map<String, NamedEntity> categoryMap = Map.of(
      "Microsft", (new Company("Microsoft", "Other", 0, "microsoft", 0, "tech")),
      "Apple", (new Company("Apple", "Other", 0, "apple", 0, "tech")),
      "Google", (new Company("Google", "Other", 0, "google", 0, "tech")),
      "Musk", (new Person("Musk", "", 0, "", n_musk, ln_musk, t_musk)),
      "Biden", (new Person("Biden", "International Politics", 0, "", n_biden, ln_biden, t_biden)),
      "Trump", (new Person("Trump", "International Politics", 0, "", n_trump, ln_trump, t_trump)),
      "Messi", (new Person("Messi", "Football", 0, "", n_messi, ln_messi, t_messi)),
      "Federer", (new Person("Federer", "Tennis", 0, "", n_federer, ln_federer, t_federer)),
      "USA", "Country",
      "Russia", "Country");

  // public String getCategory(String entity) {
  //   return categoryMap.get(entity);
  //}
  // INFO: Aca deberia devolver NamedEntity post cambio del Map de arriba que
  // deberia tomar <String,NamedEntity>
  public NamedEntity getNamedEntity(String entity) {
    return categoryMap.get(entity);
  }

  public abstract boolean isEntity(String word);

}
