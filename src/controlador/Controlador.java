/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.Collection;
import modelo.Examen;
import modelo.Materia;
import modelo.Pregunta;
import modelo.Respuesta;

/**
 *
 */
public class Controlador {
    private ClienteTCP ctcp;
    private static Controlador c = new Controlador();

    public static Controlador getInstancia(){
        return c;
    }
    
    public Controlador() {
        ctcp = new ClienteTCP();
        new FlyweightCache();
    }
    
    public void agregarMateria(Materia m){
        ctcp.escribirServidor("001"+m);
        m.setIdMateria(Integer.parseInt(ctcp.leerServidor()));
        FlyweightCache.agregarMateria(m);
    }
    
    public Collection<Materia> getMaterias(){
        return FlyweightCache.getMaterias();
    }
    
    public void agregarRespuesta(Respuesta r){
       ctcp.escribirServidor("019"+r);
       r.setIdRespuesta(Integer.parseInt(ctcp.leerServidor()));
       FlyweightCache.agregarRespuesta(r);
    }
    
    public Collection<Respuesta> getRespuestas(){
        return FlyweightCache.getRespuestas();
    }
    
    public void agregarPreguntas(Pregunta p){
        ctcp.escribirServidor("003"+p);
        p.setIdPregunta(Integer.parseInt(ctcp.leerServidor()));
        FlyweightCache.agregarPregunta(p);
    }
    
    public Collection<Pregunta> getPreguntas(){
        return FlyweightCache.getPreguntas();
    }
    
    public void agregarExamen(Examen e){
        ctcp.escribirServidor("020"+e);
        e.setIdExamen(Integer.parseInt(ctcp.leerServidor()));
        FlyweightCache.agregarExamen(e);
    }
    
    public Collection<Examen> getExamenes(){
        return FlyweightCache.getExamen();
    }
    
    public void modificarMateria(Materia m){
        ctcp.escribirServidor("005"+m);
        FlyweightCache.agregarMateria(m);
    }
    
    public void modificarPreguntas(Pregunta p){
        ctcp.escribirServidor("007"+p);
        FlyweightCache.agregarPregunta(p);
    }
    
    public void modificarRespuesta(Respuesta r){
       ctcp.escribirServidor("0021"+r);
       FlyweightCache.agregarRespuesta(r);
    }
    
    public void modificarExamen(Examen e){
        ctcp.escribirServidor("022"+e);
        FlyweightCache.agregarExamen(e);
    }
    
    public void eliminarMateria(Materia m){
        ctcp.escribirServidor("013"+m);
        FlyweightCache.eliminarMateria(m);
    }
    
    public void eliminarPreguntas(Pregunta p){
        ctcp.escribirServidor("015"+p);
        FlyweightCache.eliminarPregunta(p);
    }
}
