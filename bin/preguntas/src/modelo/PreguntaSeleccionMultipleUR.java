package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sgomez
 
 */
public class PreguntaSeleccionMultipleUR extends Pregunta {

    private String dificultadPregunta;
    private int pesoParaCuestionario;

    public PreguntaSeleccionMultipleUR() {

    }

    public Object Clone() {
        try {
            return clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(PreguntaSeleccionMultipleUR.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getCaracteristicaPregunta() {
        return "PreguntaSeleccionMultipleUR";
    }

    public String getDificultadPregunta() {
        return dificultadPregunta;
    }

    public void setDificultadPregunta(String dificultadPregunta) {
        this.dificultadPregunta = dificultadPregunta;
    }

    public int getPesoParaCuestionario() {
        return pesoParaCuestionario;
    }

    public void setPesoParaCuestionario(int pesoParaCuestionario) {
        this.pesoParaCuestionario = pesoParaCuestionario;
    }

}
