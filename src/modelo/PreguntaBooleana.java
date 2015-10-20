package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Wilfred
 * @version 1.0
 * @created 25-ago-2015 21:07:07
 */
public class PreguntaBooleana extends Pregunta {

    private String difultadPregunta;
    private int pesoParaCuestionario;

    public PreguntaBooleana() {

    }

    public Object Clone() {
        try {
            return this.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(PreguntaBooleana.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getCaracteristicaPregunta() {
        return "PreguntaBooleana";
    }

    public String getDifultadPregunta() {
        return difultadPregunta;
    }

    public void setDifultadPregunta(String difultadPregunta) {
        this.difultadPregunta = difultadPregunta;
    }

    public int getPesoParaCuestionario() {
        return pesoParaCuestionario;
    }

    public void setPesoParaCuestionario(int pesoParaCuestionario) {
        this.pesoParaCuestionario = pesoParaCuestionario;
    }
    
    @Override
    public String getAdicional() {
        return getDifultadPregunta() + "|" + getPesoParaCuestionario();
    }

}
