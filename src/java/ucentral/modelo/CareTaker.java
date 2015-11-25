/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucentral.modelo;

import java.util.Stack;

/**
 *
 * @author wvelascot
 */
public class CareTaker {
    
    private Stack<Memento> estados = new Stack<Memento>();
    
    public void addMemento(Memento m){
        estados.add(m);
    }
    
    public Memento getMemento(int idx){
        return estados.get(idx);
    }
    
    public Memento getAnterior(){
        if (estados.size() > 1){
            return estados.get(estados.size() - 2);
        }
        return estados.lastElement();
    }
    
    
}
