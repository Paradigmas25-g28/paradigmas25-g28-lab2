package namedEntity.category;

import namedEntity.NamedEntity;

public class Place extends NamedEntity{
   
    protected String pais;
    protected String ciudad;
    protected String direccion;
    protected String otro;
    public Place(String name, String category, int frequency, String pais, String ciudad, String direccion, String otro) {
        super(name, category, frequency);
        this.pais = pais;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.otro = otro;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getOtro() {
        return otro;
    }
    public void setOtro(String otro) {
        this.otro = otro;
    }
}
