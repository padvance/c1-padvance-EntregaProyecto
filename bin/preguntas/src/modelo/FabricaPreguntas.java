package modelo;

/**
 
 * @author Sgomez
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
