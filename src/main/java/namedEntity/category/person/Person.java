package namedEntity.category.person;

import namedEntity.NamedEntity;

public class Person extends NamedEntity {

    protected String idpersona;

    public Person(String name, String category, int frequency, String idpersona) {
        super(name, category, frequency);
        this.idpersona = idpersona;
    }

    public String getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(String idpersona) {
        this.idpersona = idpersona;
    }
    
    }
