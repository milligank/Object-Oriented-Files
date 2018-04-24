package cp213;

/**
 * The individual node of a linked structure that stores int. This is a single
 * forward linked structure node.
 * 
 * @author dbrown
 * @version 2017-05-29
 */
public class IntNode {

    // The T data.
    private int element = 0;
    // Link to the next Node.
    private IntNode next = null;

    /**
     * Creates a new node with data and link to next.
     *
     * @param data
     *            the data to store in the node.
     * @param next
     *            the next node to link to.
     */
    public IntNode(final int data, final IntNode next) {
	this.element = data;
	this.next = next;
    }

    /**
     * Returns the node data.
     *
     * @return The int object that is the data portion of the node.
     */
    public int getElement() {
	return this.element;
    }

    /**
     * Returns the next node in the linked structure.
     *
     * @return The node that follows this node.
     */
    public IntNode getNext() {
	return this.next;
    }

    /**
     * Sets the data element of this node to a new int object.
     *
     * @param element
     *            The new int data.
     */
    public void setElement(final int element) {
	this.element = element;
    }

    /**
     * Sets the link element of this node to a new node.
     *
     * @param next
     *            The new node link.
     */
    public void setNext(final IntNode next) {
	this.next = next;
    }

}
