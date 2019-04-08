/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

public class Fila {
    protected Nodef head;
    protected Nodef tail; 	
    protected int size;
    private int quant;
    
    public Fila() {
        size = 0;
        head = null;
        tail = null;
        quant = 0;
    }

    public int getSize() {
    	return size;
    }
    
    public void enqueue(Nodef newHead) {
        newHead.setNext(head);
        head = newHead;        
        size += 1;
        quant +=1;
        if (size == 1)
            tail = head;
    }
       
    public boolean isEmpty() {
        return (head == null);        
    }
    
    @Override
    public String toString() {    
        Nodef atual = head;
        String retorno = "";
        retorno += "Fim\n";
        while (atual != null) { 
           
        	retorno += atual.getElement() + "\n";
            atual = atual.getNext();
        }
        retorno += "In�cio";
        
        return retorno;
    }  
    
    //retorna o primeiro da lista sem remov�-lo
    public Nodef getFirst() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException( "Objeto" );
        }
        return tail;
    }
    
    //tira da fila
    public Nodef dequeue() throws EmptyListException {
        Nodef nodeRemovido = tail;
        if (isEmpty()) {
            throw new EmptyListException( "Objeto" );
        }
        if (size == 1) { 
            head = null;
            tail = null;
            size--;
        }    
        else {
            //tem que percorrer a lista            
            Nodef atual = head;
            
            while (atual.getNext() != tail) 
                atual = atual.getNext();
                    
            tail = atual;
            atual.setNext(null);
            size--;
        }
        return nodeRemovido;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
   
    
}
