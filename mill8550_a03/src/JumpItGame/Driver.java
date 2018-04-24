package JumpItGame;

public class Driver {
	public static void main(String[] args) throws Exception {
		JumpIt game4 = new JumpIt("file4.txt");
		game4.printGame();
		System.out.println("play game");
		try {
		System.out.println("the cost is " + game4.play());
		System.out.println("");
		} catch (BadInputException e){
		System.out.println(e.getMessage());
		System.out.println("");
		}
		JumpIt game3 = new JumpIt("file3.txt");
		game3.printGame();
		System.out.println("play game");
		try {
		System.out.println("the cost is " + game3.play());
		System.out.println("");
		} catch (BadInputException e){
		System.out.println(e.getMessage());
		System.out.println("");
		}
		JumpIt game1 = new JumpIt("myIntegers.txt");
		game1.printGame();
		System.out.println("play game");
		try {
		System.out.println("the cost is " + game1.play());
		System.out.println("");
		} catch (BadInputException e){
		System.out.println(e.getMessage());
		System.out.println("");
		}
		}
}
