/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucentral.modelo;

/**
 *
 * @author wvelascot
 */
public class Memento {
    
    private String descriExamen;

    public Memento(Examen examen) {
        this.descriExamen = examen.getDescriExamen();
    }

    public String getDescriExamen() {
        return descriExamen;
    }

}
