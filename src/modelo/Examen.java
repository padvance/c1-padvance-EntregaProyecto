package modelo;

import java.util.ArrayList;

/**
 * @author Wilfred
 * @version 1.0
 * @created 25-ago-2015 21:07:04
 */
public class Examen {

    private String descripcionExamen;
    private int idExamen;
    private ArrayList<Pregunta> preguntasExamen;

    public Examen() {
        preguntasExamen = new ArrayList<>();
    }
    
    public Examen(String base){
        String[] split = base.split("\\|");
        idExamen = Integer.parseInt(split[0]);
        descripcionExamen = split[1];
        preguntasExamen = new ArrayList<>();
        for (String pre : split[2].split(";")){
            Pregunta p = new Pregunta() {

                @Override
                public String getAdicional() {
                    return "";
                }
            };
            p.setIdPregunta(Integer.parseInt(pre));
            preguntasExamen.add(p);
        }
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
    
    private String getPreguntas(){
        String del = "";
        for (Pregunta p : getPreguntasExamen()){
            del += p.getIdPregunta()+";";
        }
        del = del.isEmpty() ? "" : del.substring(0, del.length()-1);
        return del;
    }

    @Override
    public String toString() {
        return getIdExamen() + "|" + getDescripcionExamen() +"|"+ getPreguntas();
    }
    
    
}
