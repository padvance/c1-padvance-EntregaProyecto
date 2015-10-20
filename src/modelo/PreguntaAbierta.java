package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Wilfred
 * @version 1.0
 * @created 25-ago-2015 21:07:07
 */
public class PreguntaAbierta extends Pregunta {

    private String dificultadPregunta;
    private int pesoParaCuestionario;

    public PreguntaAbierta() {

    }

    public Object Clone() {
        try {
            return this.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(PreguntaAbierta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getCaracteristicaPregunta() {
        return "PreguntaAbierta";
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

    @Override
    public String getAdicional() {
        return getDificultadPregunta() + "|" + getPesoParaCuestionario();
    }
    
    

}
