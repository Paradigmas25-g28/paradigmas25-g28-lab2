package namedEntity.category.place;

import namedEntity.category.Place;

public class Pais extends Place {
    protected String lenguaOficial;
    protected Integer poblacion;
    public Pais(String name, String category, int frequency, String pais, String ciudad, String direccion, String otro,
      Integer poblacion, String lenguaOficial) {
        super(name, category, frequency, pais, ciudad, direccion, otro);
        this.poblacion = poblacion;
        this.lenguaOficial = lenguaOficial;
  }
    public Integer getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }
    public String getLenguaOficial() {
        return lenguaOficial;
    }
    public void setLenguaOficial(String lenguaOficial) {
        this.lenguaOficial = lenguaOficial;
    }

}
