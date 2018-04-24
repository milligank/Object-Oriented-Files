package cp213;

/**
 * Test for generic Stack class.
 * 
 * @author dbrown
 * @version 2017-05-29
 */
public class Main {

    /**
     * @param args
     *            unused
     */
    public static void main(String[] args) {
	Stack<Integer> stack1 = new Stack<Integer>();

	System.out.println("Pushing onto stack:");

	for (int i = 0; i < 10; i++) {
	    System.out.println(i);
	    stack1.push(i);
	}
	System.out.println("Popping from stack:");

	while (!stack1.isEmpty()) {
	    System.out.println(stack1.pop());
	}
	System.out.println("----------------------------");
	Stack<String> stack2 = new Stack<String>();

	System.out.println("Pushing onto stack:");

	for (char c = 'a'; c < 'j'; c++) {
	    System.out.println(c);
	    stack2.push(new String() + c);
	}
	System.out.println("Popping from stack:");

	while (!stack2.isEmpty()) {
	    System.out.println(stack2.pop());
	}

    }

}
