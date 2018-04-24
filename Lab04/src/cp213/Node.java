package cp213;



/**
 * The individual node of a linked structure that stores <code>T</code> objects.
 * This is a single forward linked structure node.
 *
 * @author Kathleen Milligan
 * @version 2017-05-29
 */
public class Node<T> {
	   
	    private Node<T> next;
		private T element;

	    public Node(T data, Node<T> next) {
	        this.element = data;
	        this.next = next;
	    }

	    public T getElement() {
	    	return element; 
	    }
	    
	    public Node<T> getNext() {
	    	return this.next;
	    }
	    
	    public void setElement(T element) {
    	this.element = element;
		
        }


		@SuppressWarnings({ "unchecked"})
		public void setNext(T next) {
    	this.next = (Node<T>) next;
        }


	}


