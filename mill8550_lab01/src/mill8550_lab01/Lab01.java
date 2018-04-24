package mill8550_lab01;
import java.util.Scanner;
public class Lab01 {
	 /**
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
    	
    	if (b==0) return a;
    	   return gcd(b,a%b);

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        
        System.out.print("Enter a (0 to quit): ");
        a = keyboard.nextInt();
        
        
        // Read an integer from the keyboard.
        while (a != 0) {
        	// gcd function call
        	
        	 System.out.print("Enter b: ");
             b = keyboard.nextInt();
        	
             c = Lab01.gcd( a, b );
             System.out.print("the GCD is " + c);
             
             System.out.println();
             
        	 System.out.print("Enter a (0 to quit): ");
        	 a = keyboard.nextInt();
        	 
     
        }
       
   

    }


}
