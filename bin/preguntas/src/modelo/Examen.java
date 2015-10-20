package modelo;

import java.util.ArrayList;

/**
 *@author Sgomez
 * @version 1.0
 * @created 25-ago-2015 21:07:04
 */
public class Examen {

    private String descripcionExamen;
    private int idExamen;
    private ArrayList<Pregunta> preguntasExamen;

    public Examen() {

    }

    /**
     *
     * @param id
     */
    public void consultarExamen(int id) {

    }

    /**
     *
     * @param id
     * @param des
     * @param preguntas
     */
    public void crearExamen(int id, String des, ArrayList<Pregunta> preguntas) {

    }

    /**
     *
     * @param id
     */
    public void eliminarExamen(int id) {

    }

    /**
     *
     * @param id
     * @param des
     * @param preguntas
     */
    public void modificarExamen(int id, String des, ArrayList<Pregunta> preguntas) {

    }

    public String getDescripcionExamen() {
        return descripcionExamen;
    }

    public void setDescripcionExamen(String descripcionExamen) {
        this.descripcionExamen = descripcionExamen;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public ArrayList<Pregunta> getPreguntasExamen() {
        return preguntasExamen;
    }

    public void setPreguntasExamen(ArrayList<Pregunta> preguntasExamen) {
        this.preguntasExamen = preguntasExamen;
    }

    @Override
    public String toString() {
        return getIdExamen() + " " + getDescripcionExamen();
    }
    
    
}
