package namedEntity.category.other;

import namedEntity.NamedEntity;

public class Other extends NamedEntity{
    protected String comentarios;
    
    public Other(String name, String category, String topic, int frequency, String comentarios) {
        super(name, category, topic, frequency);
        this.comentarios = comentarios;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
