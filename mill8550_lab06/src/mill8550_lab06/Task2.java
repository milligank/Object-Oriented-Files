package mill8550_lab06;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
	
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter amount of times you wish to print word ");
		int n = keyboard.nextInt();
		String str = "hello";
			try {
           	 StringPrinter(n, str);
           	 
           } catch( InputMismatchException e ) {
               System.out.println(e.getMessage());
           }
		
               
	
	}
	
	
	public static void StringPrinter(int n, String str) throws Exception {
		int i;
		
		
		if (n < 0) {
			throw new Exception("integer must be positive");
		}
		
		
		for(i=0; i<n; i++) {
			System.out.print(str);
			
		}
	}
}
