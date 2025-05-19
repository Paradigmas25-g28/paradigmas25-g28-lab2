package namedEntity.category.person;

import namedEntity.category.Person;

public class Title extends Person{
    public Title(String name, String category, int frequency, String idpersona, String formacanonica,
            Boolean profesional) {
        super(name, category, frequency, idpersona);
        this.formacanonica = formacanonica;
        this.profesional = profesional;
    }
    protected String formacanonica;
    protected Boolean profesional;
    public String getFormacanonica() {
        return formacanonica;
    }
    public void setFormacanonica(String formacanonica) {
        this.formacanonica = formacanonica;
    }
    public Boolean getProfesional() {
        return profesional;
    }
    public void setProfesional(Boolean profesional) {
        this.profesional = profesional;
    }

}
