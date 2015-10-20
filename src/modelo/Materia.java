package modelo;

/**
 * @author Wilfred
 * @version 1.0
 * @created 25-ago-2015 21:07:06
 */
public class Materia {

    private String descripcionMateria;
    private int idMateria;

    public Materia() {

    }
    
    public Materia(String base){
        String[] split = base.split("\\|");
        idMateria = Integer.parseInt(split[0]);
        descripcionMateria = split[1];
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
        return getIdMateria() + "|" + getDescripcionMateria();
    }
    
}
