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
import java.text.DecimalFormat;

public class ChildHeight {
	public static void main(String[] args)
	{	
		
		DecimalFormat df = new DecimalFormat("###.#");
		Scanner sc = new Scanner(System.in);
			String fin;
		do{
			
			System.out.print("Enter child gender (M/F): ");
			String gender = sc.next();
			
			System.out.print("Enter 'feet' for feet or 'inches' for inches: ");
			String measure = sc.next();
			
			System.out.print("Enter Mothers height: ");
			double mHeight = sc.nextDouble();
			
			System.out.print("Enter Fathers height: ");
			double fHeight = sc.nextDouble();
			
			double Hfemale_child = ((fHeight * 12/13) + mHeight) / 2;
			double Hmale_child = ((mHeight * 13/12) + fHeight) / 2;
			
			if (gender.equals("F")) {
				System.out.println("your child is estimated to grow: " + (df.format(Hfemale_child))+ " " + measure);
			
			}else if (gender.equals("M")) {
				System.out.println("your child is estimated to grow: " + (df.format(Hmale_child)) + " " + measure);
			}
			System.out.println("Do you want to continue? (Y/N): ");
			fin = sc.next();
		
		}while(!fin.equals("N"));
	}

}
