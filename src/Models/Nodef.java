/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

public class Nodef {
    private String element;
    private Nodef next;
    
    public Nodef(String element){
        this.element = element;
        this.next = null;
        
    }
    
    public String getElement(){
        return element;
    }
 
    public Nodef getNext(){
        return next;
    }
 
    public void setElement(String element) {
        this.element = element;
    }    
    
    public void setNext(Nodef next) {
        this.next = next;
    }   
}