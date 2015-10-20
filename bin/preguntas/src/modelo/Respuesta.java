package modelo;

/**
 * @author Wilfred
 * @version 1.0
 * @created 25-ago-2015 21:07:08
 */
public class Respuesta {

    private String descripcionRespuesta;
    private int idRespuesta;
    private boolean veracidadRespuesta;

    public Respuesta() {

    }

    public String getDescripcionRespuesta() {
        return descripcionRespuesta;
    }

    public void setDescripcionRespuesta(String descripcionRespuesta) {
        this.descripcionRespuesta = descripcionRespuesta;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public boolean isVeracidadRespuesta() {
        return veracidadRespuesta;
    }

    public void setVeracidadRespuesta(boolean veracidadRespuesta) {
        this.veracidadRespuesta = veracidadRespuesta;
    }

    @Override
    public String toString() {
        return getIdRespuesta() + " " + getDescripcionRespuesta();
    }
    
    

}
