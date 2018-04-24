/**
 * 
 * @author Kathleen Milligan 160458550
 * @version 1.8
 * @date 2018-02-01
 */


package PizzaPackage;

public class SpecialPizza extends Pizza{
	
	public void setHamTops(int i) {
		if (i < 0)  {
			i = 0;			
		}else {
			this.numHamTops = i;
		}
		
		
	}
	
	public void setCheeseTops(int i) {
		if (i<= 0) {
			i = 1;			
		}else {
			this.numCheeseTops = i;
		}
		
		
	}
	
	public void setPepTops(int i) {
		if (i < 0)  {
			i = 0;			
		}else {
			this.numPepTops = i;
		}	
		
	}
	
	public String bellsAndWhistles() {
		super.getDescription();
		return description.concat("\nthank you for ordering you special pizza");
		
		
	}

}
