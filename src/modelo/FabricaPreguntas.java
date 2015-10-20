package modelo;

/**
 * @author Wilfred
 * @version 1.0
 * @created 25-ago-2015 21:07:05
 */
public class FabricaPreguntas {

    public FabricaPreguntas() {
    }

    public Pregunta getPregunta(String tipo) {
        switch(tipo){
            case "PreguntaAbierta": return new PreguntaAbierta();
            case "PreguntaSeleccionMultipleUR": return new PreguntaSeleccionMultipleUR();
            case "PreguntaSeleccionMultipleMR": return new PreguntaSeleccionMultipleMR();
            case "PreguntaBooleana": return new PreguntaBooleana();
            case "PreguntaCompletar": return new PreguntaCompletar();
        }
        return null;
    }

}
