package mill8550_lab06;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
	 public static void main( String[] args ) {
	        Scanner keyboard = new Scanner(System.in);


	        while( true ) {
	            System.out.print("Enter an integer (Quit to stop): ");

	            try {
	            	int x = keyboard.nextInt();
	                
	            } catch( InputMismatchException e ) {
	            	String i = keyboard.nextLine();
	            	if(i.equals("Quit")) {
                    System.exit(0);
               }
	                System.out.println("That is not an integer!");
	                
	                
	            }
	        }
	    }
	}
