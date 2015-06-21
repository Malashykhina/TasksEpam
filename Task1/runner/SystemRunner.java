package runner;
import java.util.ArrayList;
import coffeeEnums.*;
import coffeeLogic.*;
public class SystemRunner {
	
	public static void main(String[] args) {
		ArrayList<Coffee> allCaffee=new ArrayList<Coffee>();
		allCaffee.add(new Coffee(CoffeeState.BEAN, Packaging.CAN, TypeOfCoffee.ARABICA, 50, 0.5));
		allCaffee.add(new Coffee(CoffeeState.BEAN, Packaging.CAN, TypeOfCoffee.ROBUSTA, 54.4, 0.5));
		allCaffee.add(new Coffee(CoffeeState.GROUND, Packaging.CAN, TypeOfCoffee.ARABICA, 60, 0.5));
		allCaffee.add(new Coffee(CoffeeState.GROUND, Packaging.CAN, TypeOfCoffee.ROBUSTA, 54.4, 0.4));
		allCaffee.add(new Coffee(CoffeeState.INSTANT, Packaging.STICK, TypeOfCoffee.ARABICA, 5, 0.05));
		allCaffee.add(new Coffee(CoffeeState.GROUND, Packaging.STICK, TypeOfCoffee.ROBUSTA, 4.4, 0.05));
		allCaffee.add(new Coffee(CoffeeState.GROUND, Packaging.STICK, TypeOfCoffee.ARABICA, 10, 0.15));
		allCaffee.add(new Coffee(CoffeeState.GROUND, Packaging.STICK, TypeOfCoffee.ROBUSTA, 14.4, 0.15));
		
		CoffeeVan cv = new CoffeeVan(180,1.96,allCaffee);
		System.out.println(cv);
		cv.sort();
		System.out.println(cv);
		
		ArrayList<Coffee> get=cv.findAllOfQuality(0, 100);
		for (Coffee c : get){
			System.out.println(c);
		}

	}


}
