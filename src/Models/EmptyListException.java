/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

public class EmptyListException extends RuntimeException {
    
// construtor sem argumentos
public EmptyListException()
{
    this( "List" ); // chama outro construtor de EmptyListException
} // fim do construtor EmptyListException sem argumentos

public EmptyListException( String name ) 
{
   super( name + " is empty" ); // chama construtor de superclasse
} // fim de construtor EmptyListException de um argumento

} // fim da classe EmptyListException
