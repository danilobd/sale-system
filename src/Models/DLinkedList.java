/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

public class DLinkedList {
    
    protected Node header, trailer;
    protected int size;
	
    public DLinkedList()
    {
    	size = 0;
    }
    
    public void addFirst(Node no){
         
    	if (this.size == 0) { //lista vazia
    		header = no;
    		trailer = no;
    	}
    	else //lista n�o � vazia
    	{
    		no.setNext(header);
    		header.setPrevious(no);
    		header = no;    	
    		
    	}    	        
    	size = size + 1; //atualiza o tamanho    
    	System.out.println("Adicionou elemento. Tamanho atual: " + size);
  
   
   }

    public void deleteLast(){
            trailer = trailer.getPrevious();
            trailer.setNext(null);	
            size = size-1;
    }

    public void deleteFirst(){
            header = header.getNext();
            //header.setPrevious(null);
            size = size-1;
    }
    
    public void addLast(Node no){
        
    	if (this.size == 0) { //lista vazia
    		header = no;
    		trailer = no;
    	}
    	else //lista n�o � vazia
    	{
    		no.setPrevious(trailer);
    		trailer.setNext(no);
    		trailer = no;    	   		
    	}    	        
    	size = size + 1; //atualiza o tamanho    
    	System.out.println("Adicionou elemento. Tamanho atual: " + size);
   
   }

    public void addAt(Node no, int pos){ //insere na posi��o - 0 � posi��o inicial
	
        if (pos == 0 ) 
		addFirst(no);		
        else{ 
            
            if (pos == size) //inserindo no final
                    addLast(no);
            else {  				
                //chegar na posi��o desejada
                //come�ando do posi��o zero

                Node anterior, proximo;
                anterior = header;

                //chegando na posi��o indicada
                for (int i=1; i<pos; i++) 
                        anterior = anterior.getNext();    					

                proximo = anterior.getNext();				
                no.setPrevious(anterior);
                no.setNext(proximo);

                anterior.setNext(no);
                proximo.setPrevious(no);

                size = size + 1; //atualiza o tamanho    
                System.out.println("Adicionou elemento na posi��o " + pos + ". Tamanho atual: " + size);
            }          
        }
}

    public void deleteAt(String tipo,int qt){ //deleta na posi��o - 0 � posi��o inicial
        
        int op=2;
        int pos=0;
        
        while(op!=4){
            if("agua".equals(tipo)){

                op=4;
            }
            else if("gas".equals(tipo)){
                op=4;
            }
           pos++;
        }
        
        if (qt == 1 ) {
            deleteFirst();		
        }else{ 
            if (pos == size-1){ //inserindo no final
                    deleteLast();
            } else {  				
                    //chegar na posi��o desejada
                    //come�ando do posi��o zero

                    Node anterior, proximo;
                    anterior = header;

                    //chegando na posi��o indicada
                    for (int i=1; i<=pos; i++) 
                            anterior = anterior.getNext();    					

                    proximo = anterior.getNext();
                    anterior = anterior.getPrevious();

                    anterior.setNext(proximo);
                    proximo.setPrevious(anterior); 

                    size = size -1; //atualiza o tamanho    
                    System.out.println("Removeu elemento na posição " + pos + ". Tamanho atual: " + size);				
                }
        }
    }

 
 
    public String toString(){
        
        Node noAux = header;
        String s = "{";
        int i = 1;
        
        while(noAux.getNext()!=null){
            if(i==1)
                s+="[.] ";
            s+=" <- ";
            s+=noAux.getElement();
            s+=" -> ";
            i++;
            noAux = noAux.getNext();
        }
            
        return s+=" <- " + noAux.getElement() + " -> [.]}";
    }

}