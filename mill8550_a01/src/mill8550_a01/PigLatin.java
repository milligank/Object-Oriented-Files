/**
@author
Kathleen Milligan
160458550
@version
JavaSE 1.8
@date
17-01-2018
*/



package mill8550_a01;
import java.util.Scanner;


public class PigLatin {
	
	public static void main (String args[])
	{
		Scanner sc = new Scanner(System.in);
		String word; 
		String pigLatin = "";
		char first;
		boolean c = false;
		String line;
		
		System.out.print("Enter name to translate: ");
		line = sc.nextLine();
	   sc = new Scanner(line); 
	   
	   // loop through all the words in the line
	   while (sc.hasNext())
	   {
		   word = sc.next();
		   first = word.charAt(0); 
		   if (('A' <= first) && (first <= 'Z' ))
		   {
	   		first  = Character.toLowerCase(first);
	   		c = true;
		   	}
			else 
				c = false; 
		
		// test if first letter is a vowel
			if (first == 'a' || first =='e' || first == 'i' || first == 'o' || first == 'u')
				
				pigLatin = word + "ay";
			else   // for constants
			{
				if (c)
				{
					pigLatin = "" + Character.toUpperCase(word.charAt(1));
					pigLatin = pigLatin + word.substring(2) + first + "ay";
	   			}
	   			else
	   				pigLatin = word.substring(1) + first + "ay";
			}
		   
			System.out.print(pigLatin + " "); 
		}
	}

}	

