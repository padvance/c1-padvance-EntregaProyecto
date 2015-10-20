/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.Stack;
import modelo.Examen;
import modelo.Materia;
import modelo.Pregunta;
import modelo.Respuesta;

/**
 *
 */
public class Controlador {
    private PersistenciaBD pbd;

    public Controlador() {
        pbd = new PersistenciaBD();
    }
    
    public boolean agregarMateria(Materia m){
        return pbd.agregarMateria(m);
    }
    
    public Stack<Materia> getMaterias(){
        return pbd.getMaterias();
    }
    
    public boolean agregarRespuesta(Respuesta r){
        return pbd.agregarRespuesta(r);
    }
    
    public Stack<Respuesta> getRespuestas(){
        return pbd.getRespuestas();
    }
    
    public boolean agregarPreguntas(Pregunta p){
        return pbd.agregarPregunta(p);
    }
    
    public Stack<Pregunta> getPreguntas(){
        return pbd.getPreguntas();
    }
    
    public boolean agregarExamen(Examen e){
        return pbd.agregarExamen(e);
    }
    
    public Stack<Examen> getExamenes(){
        return pbd.getExamenes();
    }
}
