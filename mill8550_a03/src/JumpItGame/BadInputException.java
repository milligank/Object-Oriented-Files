package JumpItGame;

public class BadInputException extends Exception {
	public BadInputException() {
		super("The first int should be 0"); // or anything you like
}
	public BadInputException(String message){
		super(message);
}

}