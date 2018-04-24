/**
 * 
 * @author Kathleen Milligan 160458550
 * @version 1.8
 * @date 2018-02-01
 */


package PizzaPackage;
import PizzaPackage.PizzaSize;

public class Driver {
	/**
	* @param args
	*/
	public static void main(String[] args) {
	//order a regular pizza
	Pizza pizza = new Pizza();
	System.out.println("Order a pizza\n");
	System.out.println(pizza.getDescription());
	System.out.println("\nChanging my order\n");
	pizza.setSize(PizzaSize.large);
	pizza.setPepTops(3);
	pizza.setHamTops(1);
	pizza.setCheeseTops(2);
	System.out.println(pizza.getDescription());
	// order a special pizza
	System.out.println("\nOrder a special pizza");
	SpecialPizza specialPizza = new SpecialPizza();
	specialPizza.setSize(PizzaSize.small);
	specialPizza.setCheeseTops(3);
	specialPizza.setHamTops(4);
	specialPizza.setPepTops(1);
	System.out.println(specialPizza.bellsAndWhistles());
	}
}

