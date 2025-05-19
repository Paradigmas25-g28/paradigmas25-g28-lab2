package namedEntity.category.place;

import namedEntity.category.Place;

public class Direction extends Place{
    protected String ciudad;

    public Direction(String name, String category, int frequency, String pais, String ciudad, String direccion,
            String otro, String ciudad2) {
        super(name, category, frequency, pais, ciudad, direccion, otro);
        ciudad = ciudad2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}
