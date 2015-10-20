package modelo;

/**
    @author Sgomez
 * 
 */
public class Materia {

    private String descripcionMateria;
    private int idMateria;

    public Materia() {

    }

    /**
     *
     * @param id
     */
    public void consultarMateria(int id) {

    }

    /**
     *
     * @param id
     * @param des
     */
    public void crearMateria(int id, String des) {

    }

    /**
     *
     * @param id
     */
    public void eliminarMateria(int id) {

    }

    /**
     *
     * @param id
     */
    public void modificarMateria(int id) {

    }

    public String getDescripcionMateria() {
        return descripcionMateria;
    }

    public void setDescripcionMateria(String descripcionMateria) {
        this.descripcionMateria = descripcionMateria;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public String toString() {
        return getIdMateria() + " " + getDescripcionMateria();
    }
    
}
