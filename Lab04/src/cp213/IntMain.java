package cp213;

/**
 * Test for IntStack class.
 * 
 * @author dbrown
 * @version 2017-05-29
 */
public class IntMain {

    /**
     * @param args
     *            unused
     */
    public static void main(String[] args) {
	IntStack stack1 = new IntStack();

	System.out.println("Pushing onto stack:");

	for (int i = 0; i < 10; i++) {
	    System.out.println(i);
	    stack1.push(i);
	}
	System.out.println("Popping from stack:");

	while (!stack1.isEmpty()) {
	    System.out.println(stack1.pop());
	}
    }

}
