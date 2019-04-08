
package Models;

public class Node {
	
    protected String element;
    protected Node next, previous;

    public Node(String element, Node next, Node previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }

    public String getElement() {
	return element;
    }
    
    public void setElement(String element) {
            this.element = element;
    }
    
    public Node getNext() {
            return next;
    }
    
    public void setNext(Node next) {
            this.next = next;
    }
    
    public Node getPrevious() {
            return previous;
    }
    
    public void setPrevious(Node previous) {
            this.previous = previous;
    } 
	
}