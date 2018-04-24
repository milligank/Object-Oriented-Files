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

public class Device {
	public static final int ORIGINYEAR = 1980;
	 public static void main(String args[]) {
		 Scanner sc = new Scanner(System.in);
		
		 System.out.print("Enter days (0 to quit): ");
		 int days = sc.nextInt();
		 
		while(days != 0){
			 int year = getYear(days);
			 System.out.println("input days: " + days);
			 System.out.println("in year: " + year );
			 System.out.print("Enter days (0 to quit): ");
			 days = sc.nextInt();
		}
	 
	 }
	 /**
	 * Calculates the year given days since ORIGINYEAR.
	 * @param days
	 * number of days since January 1, 1980 (int >= 0)
	 * @return the year
	 */
	 public static int getYear(int days) {
		
		int year = ORIGINYEAR;
		boolean is_leap = leapYear(year);
		//checks to see if its a leap year or not, then subtracts those days from the year
		while(((is_leap) && (days>365)) || ((!is_leap) && (days > 365))){
			if (is_leap) {
				days -= 366;
			
			}else {
				days -=365;				
			}
			year += 1;
			is_leap = leapYear(year);
					
		}
		
		
		return year;
		
	}
	 /**
	 * Determines whether or not a year is a leap year.
	 *
	 * @param year
	 * The year to test int year
	 * @return true is year is a leap year, false otherwise.
	 */
	public static boolean leapYear(final int year) {
		
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			return true;
		} else {
			return false;
		}
	
	}

}
