package namedEntity.category.person;

import namedEntity.category.Person;

class Name extends Person{
  protected String forma_canonica;
  protected String origen;
  protected String formas_alternativas;


  public Name(String name, String category, int frequency, String idpersona, String forma_canonica, String origen,
        String formas_alternativas) {
    super(name, category, frequency, idpersona);
    this.forma_canonica = forma_canonica;
    this.origen = origen;
    this.formas_alternativas = formas_alternativas;
}

  public String getForma_canonica() {
    return forma_canonica;
  }

  public void setForma_canonica(String forma_canonica) {
    this.forma_canonica = forma_canonica;
  }

  public String getOrigen() {
    return origen;
  }

  public void setOrigen(String origen) {
    this.origen = origen;
  }

  public String getFormas_alternativas() {
    return formas_alternativas;
  }

  public void setFormas_alternativas(String formas_alternativas) {
    this.formas_alternativas = formas_alternativas;
  }
}