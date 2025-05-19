package namedEntity.category;

import namedEntity.category.Person;

public class LastName extends Person{
    protected String formacanonica;
    protected String origen;
    
    public LastName(String name, String category, int frequency, String idpersona, String formacanonica,
            String origen) {
        super(name, category, frequency, idpersona);
        this.formacanonica = formacanonica;
        this.origen = origen;
    }
    public String getFormacanonica() {
        return formacanonica;
    }
    public void setFormacanonica(String formacanonica) {
        this.formacanonica = formacanonica;
    }
    public String getOrigen() {
        return origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }
}
