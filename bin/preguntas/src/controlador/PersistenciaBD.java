/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Examen;
import modelo.FabricaPreguntas;
import modelo.Materia;
import modelo.Pregunta;
import modelo.PreguntaAbierta;
import modelo.PreguntaBooleana;
import modelo.PreguntaCompletar;
import modelo.PreguntaSeleccionMultipleMR;
import modelo.PreguntaSeleccionMultipleUR;
import modelo.Respuesta;

/**
 *@author Sgomez
 */
public class PersistenciaBD {
    
    private Conexion conexion = Conexion.getInstancia();
    
    public boolean agregarMateria(Materia m){
        String sql = "insert into materia (descri_materia) values (?)";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, m.getDescripcionMateria());
            stm.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean agregarRespuesta(Respuesta r){
        String sql = "insert into respuesta (descri_respuesta, veracidad_respuesta) values (?, ?)";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, r.getDescripcionRespuesta());
            stm.setString(2, r.isVeracidadRespuesta()+"");
            stm.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean agregarPregunta(Pregunta r){
        String sql = "insert into pregunta (descri_pregunta, tipo_pregunta, materia_idmateria, respuesta_idrespuesta, dificultad_pregunta, peso_pregunta) values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, r.getDescripcionPregunta());
            stm.setString(2, r.getCaracteristicaPregunta());
            stm.setInt(3, r.getM_Materia().getIdMateria());
            stm.setInt(4, r.getM_Respuesta().getIdRespuesta());
            if (r instanceof PreguntaAbierta){
                stm.setString(5, ((PreguntaAbierta)r).getDificultadPregunta());
                stm.setInt(6, ((PreguntaAbierta)r).getPesoParaCuestionario());
            }else if (r instanceof PreguntaBooleana){
                stm.setString(5, ((PreguntaBooleana)r).getDifultadPregunta());
                stm.setInt(6, ((PreguntaBooleana)r).getPesoParaCuestionario());
            }else if (r instanceof PreguntaCompletar){
                stm.setString(5, ((PreguntaCompletar)r).getDificultadPregunta());
                stm.setInt(6, ((PreguntaCompletar)r).getPersoParaCuestionario());
            }else if (r instanceof PreguntaSeleccionMultipleMR){
                stm.setString(5, ((PreguntaSeleccionMultipleMR)r).getDificultadPregunta());
                stm.setInt(6, ((PreguntaSeleccionMultipleMR)r).getPesoParaCuestionario());
            }else if (r instanceof PreguntaSeleccionMultipleUR){
                stm.setString(5, ((PreguntaSeleccionMultipleUR)r).getDificultadPregunta());
                stm.setInt(6, ((PreguntaSeleccionMultipleUR)r).getPesoParaCuestionario());
            }
            stm.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean agregarExamen(Examen r){
        String sql = "insert into examen (descri_examen) values (?)";
        try {
            PreparedStatement stm = conexion.prepareStatement(sql);
            stm.setString(1, r.getDescripcionExamen());
            stm.execute();
            r.setIdExamen(getLastID());
            return agregarRespuestasExamen(r);
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    private boolean agregarRespuestasExamen(Examen r){
        String sql = "insert into examen_has_pregunta (examen_idexamen, pregunta_idpregunta) values (?, ?)";
        try {
            for (Pregunta p : r.getPreguntasExamen()){
                PreparedStatement stm = conexion.prepareStatement(sql);
                stm.setInt(1, r.getIdExamen());
                stm.setInt(2, p.getIdPregunta());
                stm.execute();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private int getLastID(){
        try {
            String query = "SELECT LAST_INSERT_ID()";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return -1;
    }
    
    
    public Stack<Materia> getMaterias(){
        try {
            Stack<Materia> materias = new Stack<Materia>();
            String query = "SELECT idmateria, descri_materia from materia ";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Materia m = new Materia();
                m.setIdMateria(rs.getInt(1));
                m.setDescripcionMateria(rs.getString(2));
                materias.add(m);
            }
            return materias;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public Stack<Respuesta> getRespuestas(){
        try {
            Stack<Respuesta> respuestas = new Stack<Respuesta>();
            String query = "SELECT idrespuesta, descri_respuesta, veracidad_respuesta from respuesta";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Respuesta r = new Respuesta();
                r.setIdRespuesta(rs.getInt(1));
                r.setDescripcionRespuesta(rs.getString(2));
                r.setVeracidadRespuesta(rs.getBoolean(3));
                respuestas.add(r);
            }
            return respuestas;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public Stack<Pregunta> getPreguntas(){
        try {
            FabricaPreguntas fp = new FabricaPreguntas();
            Stack<Pregunta> preguntas = new Stack<Pregunta>();
            String query = "SELECT tipo_pregunta, idpregunta, descri_pregunta, materia_idmateria, respuesta_idrespuesta, dificultad_pregunta, peso_pregunta from pregunta";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Pregunta r = fp.getPregunta(rs.getString(1));
                r.setIdPregunta(rs.getInt(2));
                r.setDescripcionPregunta(rs.getString(3));
//                r.setM_Materia(new Materia().setIdMateria(rs.getInt(4)));
//                r.setM_Respuesta(new Respuesta().setIdRespuesta(rs.getInt(5)));
                if (r instanceof PreguntaAbierta){
                    ((PreguntaAbierta)r).setDificultadPregunta(rs.getString(6));
                    ((PreguntaAbierta)r).setPesoParaCuestionario(rs.getInt(7));
                }else if (r instanceof PreguntaBooleana){
                    ((PreguntaBooleana)r).setDifultadPregunta(rs.getString(6));
                    ((PreguntaBooleana)r).setPesoParaCuestionario(rs.getInt(7));
                }else if (r instanceof PreguntaCompletar){
                    ((PreguntaCompletar)r).setDificultadPregunta(rs.getString(6));
                    ((PreguntaCompletar)r).setPersoParaCuestionario(rs.getInt(7));
                }else if (r instanceof PreguntaSeleccionMultipleMR){
                    ((PreguntaSeleccionMultipleMR)r).setDificultadPregunta(rs.getString(6));
                    ((PreguntaSeleccionMultipleMR)r).setPesoParaCuestionario(rs.getInt(7));
                }else if (r instanceof PreguntaSeleccionMultipleUR){
                    ((PreguntaSeleccionMultipleUR)r).setDificultadPregunta(rs.getString(6));
                    ((PreguntaSeleccionMultipleUR)r).setPesoParaCuestionario(rs.getInt(7));
                }
                preguntas.add(r);
            }
            return preguntas;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public Stack<Examen> getExamenes(){
        try {
            Stack<Examen> examenes = new Stack<Examen>();
            String query = "SELECT idexamen, descri_examen from examen";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Examen r = new Examen();
                r.setIdExamen(rs.getInt(1));
                r.setDescripcionExamen(rs.getString(2));
                examenes.add(r);
            }
            return examenes;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
}
