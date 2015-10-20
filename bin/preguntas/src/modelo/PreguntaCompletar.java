package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sgomez
 * 
 */
public class PreguntaCompletar extends Pregunta {

    private String dificultadPregunta;
    private int persoParaCuestionario;

    public PreguntaCompletar() {

    }

    public Object Clone() {
        try {
            return this.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(PreguntaCompletar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getCaracteristicaPregunta() {
        return "PreguntaCompletar";
    }

    public String getDificultadPregunta() {
        return dificultadPregunta;
    }

    public void setDificultadPregunta(String dificultadPregunta) {
        this.dificultadPregunta = dificultadPregunta;
    }

    public int getPersoParaCuestionario() {
        return persoParaCuestionario;
    }

    public void setPersoParaCuestionario(int persoParaCuestionario) {
        this.persoParaCuestionario = persoParaCuestionario;
    }

}
