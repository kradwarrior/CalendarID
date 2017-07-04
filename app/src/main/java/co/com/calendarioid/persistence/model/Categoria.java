package co.com.calendarioid.persistence.model;

/**
 * Created by desarrollo on 13/06/2017.
 */

public class Categoria {

    private	Integer id;
    private	String imagen;
    private	String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
