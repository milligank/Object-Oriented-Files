package cp213;



/**
 * A simple linked stack structure of <code>Node T</code> objects. Only the
 * <code>T</code> data contained in the stack is visible through the standard
 * stack methods.
 *
 * @author Kathleen Milligan
 * @version 2017-05-29
 */
public class Stack<T> {
	
    private Node<T> top;
    
    public boolean isEmpty() {
	return this.top == null;
    }

    
    public T peek() {
	return this.top.getElement();
    }

    
    public T pop() {
    	
	final T data = this.top.getElement();
	this.top = this.top.getNext();
	return data;
    }

    
    public void push(T data) {
	final Node<T> node = new Node<T>(data, this.top);
	this.top = (Node<T>) node;
    }
	
}