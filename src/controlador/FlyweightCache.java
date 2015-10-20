/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import modelo.Examen;
import modelo.Materia;
import modelo.Pregunta;
import modelo.Respuesta;

/**
 *
 * @author wilfred
 */
public class FlyweightCache {
    
    private static HashMap<Integer, Materia> materias = new LinkedHashMap<Integer, Materia>();
    private static HashMap<Integer, Respuesta> respuestas = new LinkedHashMap<Integer, Respuesta>();
    private static HashMap<Integer, Pregunta> preguntas = new LinkedHashMap<Integer, Pregunta>();
    private static HashMap<Integer, Examen> examen = new LinkedHashMap<Integer, Examen>();

    public FlyweightCache() {
        PersistenciaBD pbd = new PersistenciaBD();
        for (Materia m : pbd.getMaterias()){
            agregarMateria(m);
        }
        
        for (Respuesta r : pbd.getRespuestas()){
            agregarRespuesta(r);
        }
        
        for (Pregunta p : pbd.getPreguntas()){
            agregarPregunta(p);
        }
        
        for (Examen e : pbd.getExamenes()){
            agregarExamen(e);
        }
    }
    
    public static void agregarExamen(Examen e){
        examen.put(e.getIdExamen(), e);
    }
    
    public static void agregarPregunta(Pregunta p){
        preguntas.put(p.getIdPregunta(), p);
    }
    
    public static void agregarRespuesta(Respuesta r){
        respuestas.put(r.getIdRespuesta(), r);
    }
    
    public static void agregarMateria(Materia m){
        materias.put(m.getIdMateria(), m);
    }
    
    public static Collection<Materia> getMaterias(){        
        return materias.values();
    }
    
    public static Collection<Respuesta> getRespuestas(){
        return respuestas.values();
    }
    
    public static Collection<Pregunta> getPreguntas(){
        return preguntas.values();
    }
    
    public static Collection<Examen> getExamen(){
        return examen.values();
    }
    
    public static void eliminarMateria(Materia m) {
        materias.remove(m.getIdMateria());
    }

    public static void eliminarPregunta(Pregunta p) {
        preguntas.remove(p.getIdPregunta());
    }
    
}
