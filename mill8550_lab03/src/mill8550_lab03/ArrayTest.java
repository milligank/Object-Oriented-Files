package mill8550_lab03;

public class ArrayTest {
	 public static void main(String[] args) {
		    int[] first = { 1, 3, 5, 7, 9 };
		    int[] second = first;
		    int[][] third = new int [1][];
		    System.out.println("first:");

		    for (int element: first) {
		      System.out.println(element*2);
		    }
		    //for (int i = 0; i < first.length; i++) {
		    	//first[i] = first[i]*2;
		       // System.out.println(first[i]);
		   // }

		    System.out.println("second:");

		    for (int element1: second) {
		      System.out.println(element1);
		     
		    third[0] = first;
		    System.out.println("third");
		    
		    for (int i=0; i< third.length; i++) {
		    	System.out.println(third[i]);
		   
		    	}
		    
		    }
		  }
		}
