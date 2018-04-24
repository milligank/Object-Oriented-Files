package JumpItGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class JumpIt {
	private String fileName; // name of the file
	private int count = 0; // number of valid integers in the file
	private final int MAX_SIZE = 15; // the size of the array
	int [] row = new int[MAX_SIZE];
	FileReader input = null;
	BufferedReader br = null;
	
	
	// constructor to set the game by reading integers from file
	// read only MAX_SIZE integers from the file, bad ints are ignored
	// print out a message if file cannot be opened
	
	
	public JumpIt(String theName) throws Exception { // constructor to set the file name
		String c;
		int i =0;
		
    try {
    	this.fileName = new String(theName);
    	input = new FileReader(this.fileName);
    	br = new BufferedReader(input);
        
    } catch( IOException e ) {
    	System.out.println(e.getMessage());
        System.exit(0);
    }
    System.out.println(String.format("opening the file %s", fileName));
    
    while (((c = br.readLine()) != null)&&(i< MAX_SIZE)) {
    	try {
	    	row[i] = Integer.parseInt(c);
	    	i++;
	    }catch(NumberFormatException e) {
    		System.out.println(e.getMessage() + " invalid input, will be ignored");
    		
    	}
    	if (i == MAX_SIZE) {
    		System.out.println("Only the first 15 integers are considered.");
    		
    	}
    	
    	
    }
    System.out.println(String.format("The file has %d integers.", i));
   
}
	
	
	// return the lowest total cost of the game
	// throws an exception if the first int is not 0
	public int play() throws BadInputException{
		if (row[0] != 0) {
			throw new BadInputException();
			}
		return play(row, 0, count); 
	}
	// print the all integers in the array
	
	private int play(int[] a, int first, int last) {
		last += a[first];
		if (first == a.length -1)
			return last;
		 else if (first == a.length -2)
			return play(a, first + 1, last);
		else {

			int p1 = play(a, first + 1, last);
			int p2 = play(a, first + 2, last);

			return Math.min(p1, p2);
		}
	}
	
	public void printGame() {
		int i =0;
		System.out.print(Integer.toString(row[i]));
		System.out.print(" ");
		i++;
		
		
		while ((i<MAX_SIZE)&&(row[i] != 0)) {
			while(( count < 9)&&(i<MAX_SIZE)&&(row[i] != 0)) {
				System.out.print(Integer.toString(row[i]));
				System.out.print(" ");
				
				i++;
				count++;
			}
	
		System.out.println();
		count =0;
		} // while 
			
				
		
		
	}
	} // MyFile


	
	
