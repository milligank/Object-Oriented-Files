package cp213;

/**
 * A simple linked stack structure of int. Only the int data contained in the
 * stack is visible through the standard stack methods.
 * 
 * @author dbrown
 * @version 2017-05-29
 */
public class IntStack {

    // The top node of the stack.
    private IntNode top = null;

    /**
     * Returns whether the stack is empty or not.
     *
     * @return <code>true</code> if the stack is empty, <code>false</code>
     *         otherwise.
     */
    public boolean isEmpty() {
	return this.top == null;
    }

    /**
     * Returns a reference to the top data element of the stack without removing
     * that data from the stack.
     *
     * @return The int at the top of the stack.
     */
    public int peek() {
	return this.top.getElement();
    }

    /**
     * Returns the top data element of the stack and removes that element from
     * the stack. The next node in the stack becomes the new top node.
     *
     * @return The int at the top of the stack.
     */
    public int pop() {
	final int data = this.top.getElement();
	this.top = this.top.getNext();
	return data;
    }

    /**
     * Adds a int to the top of the stack.
     *
     * @param data
     *            The int to add to the top of the stack.
     */
    public void push(final int data) {
	final IntNode node = new IntNode(data, this.top);
	this.top = node;
    }
}
