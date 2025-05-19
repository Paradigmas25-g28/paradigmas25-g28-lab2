package namedEntity.category;

import namedEntity.category.Place;

public class Other extends Place{
    protected String comentarios;
    public Other(String name, String category, int frequency, String pais, String ciudad, String direccion, String otro,
            String comentarios) {
        super(name, category, frequency, pais, ciudad, direccion, otro);
        this.comentarios = comentarios;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

}
