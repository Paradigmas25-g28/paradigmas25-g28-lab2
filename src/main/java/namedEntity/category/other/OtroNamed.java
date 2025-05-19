package namedEntity.category.other;

import namedEntity.NamedEntity;

public class OtroNamed extends NamedEntity{
    protected String comentarios;
    
    public OtroNamed(String name, String category, int frequency, String comentarios) {
        super(name, category, frequency);
        this.comentarios = comentarios;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
