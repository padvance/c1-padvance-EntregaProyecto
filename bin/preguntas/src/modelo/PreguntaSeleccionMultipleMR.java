package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sgomez
 
 */
public class PreguntaSeleccionMultipleMR extends Pregunta {

    private String dificultadPregunta;
    private int pesoParaCuestionario;

    public PreguntaSeleccionMultipleMR() {

    }

    public Object Clone() {
        try {
            return this.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(PreguntaSeleccionMultipleMR.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getCaracteristicaPregunta() {
        return "PreguntaSeleccionMultipleMR";
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
