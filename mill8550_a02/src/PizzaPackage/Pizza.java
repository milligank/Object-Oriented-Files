/**
 * 
 * @author Kathleen Milligan 160458550
 * @version 1.8
 * @date 2018-02-01
 */


package PizzaPackage;

public class Pizza {
	private PizzaSize size;
	protected int numPepTops;
	protected int numHamTops;
	protected int numCheeseTops;
	private double cost;
	protected String description;
	
	private final double COST_S = 10.00;
	private final double COST_M = 12.00;
	private final double COST_L = 14.00;
	private final double COST_TOP = 2.00;
	
	
	public Pizza(){
		size = PizzaSize.medium;
		numCheeseTops = 1;
		numHamTops = 0;
		numPepTops =0;		
				
	}
	
	
	public String getDescription() {
		
		size = getSize();
		numHamTops = getHamTops();
		numCheeseTops = getCheeseTops();
		numPepTops = getPepTops();
		cost = calCost(size, numPepTops, numCheeseTops, numHamTops);
		
		description = "Size: " + size + "\nNumber of ham toppings: " + numHamTops +  "\nNumber of Cheese toppings: " + numCheeseTops + " \nNumber of Pepperoni toppings: " + numPepTops + "\nCost: " + cost;
		
		return description;
	}

	public void setPepTops(int i) {
		if ((i > 2)||(i < 0))  {
			i = 0;			
		}else {
			this.numPepTops = i;
		}	
		
	}
	
	public int getPepTops() {
		return numPepTops;
	}
	
	public void setCheeseTops(int i) {
		if ((i > 2)||(i<= 0)) {
			i = 1;			
		}else {
			this.numCheeseTops = i;
		}
		
		
	}
	
	public int getCheeseTops() {
		return numCheeseTops;
	}
	
	public void setHamTops(int i) {
		if ((i > 2)||(i < 0))  {
			i = 0;			
		}else {
			this.numHamTops = i;
		}
		
		
	}
	
	public int getHamTops() {
		return numHamTops;
	}

	public void setSize(PizzaSize size) {
	
			this.size = size;
		
		
	}
	
	public PizzaSize getSize() {
		return size;
	}
	
	
	public double calCost(PizzaSize size, int numHamTops, int numPepTops, int numCheeseTops) {
		switch(size) {
		case small:
			cost = COST_S;
			break;
		default:
			break;
		}
		
		switch(size) {
		case medium:
			cost = COST_M;
			break;
		default:
			break;
		}
		
		switch(size) {
		case large:
			cost = COST_L;
			break;
		default:
			break;
		}
		
		cost = cost + (COST_TOP * numHamTops) + (COST_TOP * numCheeseTops) + (COST_TOP * numPepTops);
		
		return cost;
			
		}


	
	
}
