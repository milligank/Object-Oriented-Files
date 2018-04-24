package mill8550_lab02;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String args[]) {
        // Read from the keyboard.
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a series of integers. Press 'q' to quit.");
        int result = 0;
 
        while (!s.hasNext("q")){
        	if (s.hasNextInt()) {
                result += s.nextInt();
        	}
        	else {
        		System.out.println("Error, enter valid integer or q to quit");
        		s.next();
        	}
        }
        
        s.close(); 
        
        System.out.println("The total is " + result);
        
        try {
			file();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


	 public static void file() throws FileNotFoundException {
		 String line;
		 int count = 0;
		
		 File file = new File("src/mill8550_lab02/ScannerTest.java");
	     Scanner source = new Scanner(file);
	     
	     while (source.hasNext()) {
	    	 line = source.nextLine();
	    	 System.out.println(line);
	    	 count += 1;
	    	 
	    System.out.println(count); 
	     
	     }
	  
	 }
	 
	 
	 
}