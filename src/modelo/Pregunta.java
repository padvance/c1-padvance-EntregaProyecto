package modelo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Wilfred
 * @version 1.0
 * @created 25-ago-2015 21:07:06
 */
public abstract class Pregunta implements TipoPregunta {

    private String descripcionPregunta;
    private int idPregunta;
    private ArrayList<Respuesta> respuestasPregunta;
    public Materia m_Materia;
    public Respuesta m_Respuesta;

    public Pregunta() {

    }
    
    public Object Clone() {
        try {
            return this.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Pregunta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param id
     */
    public void consultarPregunta(int id) {

    }

    /**
     *
     * @param id
     */
    public void eliminarPregunta(int id) {

    }

    public String getCaracteristicaPregunta() {
        return "SIMPLE";
    }

    /**
     *
     * @param id
     * @param des
     * @param tipo
     * @param dif
     * @param peso
     */
    public void modificarPregunta(int id, String des, TipoPregunta tipo, String dif, int peso) {

    }

    public String getDescripcionPregunta() {
        return descripcionPregunta;
    }

    public void setDescripcionPregunta(String descripcionPregunta) {
        this.descripcionPregunta = descripcionPregunta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public ArrayList<Respuesta> getRespuestasPregunta() {
        return respuestasPregunta;
    }

    public void setRespuestasPregunta(ArrayList<Respuesta> respuestasPregunta) {
        this.respuestasPregunta = respuestasPregunta;
    }

    public Materia getM_Materia() {
        if (m_Materia == null){
            m_Materia = new Materia();
        }
        return m_Materia;
    }

    public void setM_Materia(Materia m_Materia) {
        this.m_Materia = m_Materia;
    }

    public Respuesta getM_Respuesta() {
        if (m_Respuesta == null){
            m_Respuesta = new Respuesta();
        }
        return m_Respuesta;
    }

    public void setM_Respuesta(Respuesta m_Respuesta) {
        this.m_Respuesta = m_Respuesta;
    }
    
    public abstract String getAdicional();

    @Override
    public String toString() {
        return getIdPregunta() + "|" + getDescripcionPregunta() + "|" + getAdicional() + "|" + getM_Materia().getIdMateria()+ "|" + getM_Respuesta().getIdRespuesta() + "|" + getCaracteristicaPregunta();
    }
    
    

}
