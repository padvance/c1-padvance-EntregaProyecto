/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Wilfred
 */
public class FacadePregunta {
    
    public Pregunta generarPregunta(String tipo, String dif, String peso, String id, String descr){
        return generarPregunta(tipo, dif, Integer.parseInt(peso), Integer.parseInt(id), descr);
    }
    
    public Pregunta generarPregunta(String tipo, String dif, int peso, int id, String descr){
        FabricaPreguntas fp = new FabricaPreguntas();
        Pregunta p;
        if (tipo.indexOf("PreguntaAbierta") >= 0){
            p = fp.getPregunta("PreguntaAbierta");
            PreguntaAbierta pa = (PreguntaAbierta) p;
            pa.setDificultadPregunta(dif);
            pa.setPesoParaCuestionario(peso);
        }else if (tipo.indexOf("PreguntaBooleana") >= 0){
            p = fp.getPregunta("PreguntaBooleana");
            PreguntaBooleana pa = (PreguntaBooleana) p;
            pa.setDifultadPregunta(dif);
            pa.setPesoParaCuestionario(peso);
        }else if (tipo.indexOf("PreguntaCompletar") >= 0){
            p = fp.getPregunta("PreguntaCompletar");
            PreguntaCompletar pa = (PreguntaCompletar) p;
            pa.setDificultadPregunta(dif);
            pa.setPersoParaCuestionario(peso);
        }else if (tipo.indexOf("PreguntaSeleccionMultipleUR") >= 0){
            p = fp.getPregunta("PreguntaSeleccionMultipleUR");
            PreguntaSeleccionMultipleUR pa = (PreguntaSeleccionMultipleUR) p;
            pa.setDificultadPregunta(dif);
            pa.setPesoParaCuestionario(peso);
        }else{
            p = fp.getPregunta("PreguntaSeleccionMultipleMR");
            PreguntaSeleccionMultipleMR pa = (PreguntaSeleccionMultipleMR) p;
            pa.setDificultadPregunta(dif);
            pa.setPesoParaCuestionario(peso);
        }
        p.setIdPregunta(id);
        p.setDescripcionPregunta(descr);
        
        return p;
    }
    
}
