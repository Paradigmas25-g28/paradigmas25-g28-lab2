package namedEntity.category;

import namedEntity.category.Place;

public class Ciudad extends Place {
    protected String capital;
    protected Integer poblacion;
    protected String pais;
    public Ciudad(String name, String category, int frequency, String pais, String ciudad, String direccion,
            String otro, String capital, Integer poblacion, String pais2) {
        super(name, category, frequency, pais, ciudad, direccion, otro);
        this.capital = capital;
        this.poblacion = poblacion;
        pais = pais2;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public Integer getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
