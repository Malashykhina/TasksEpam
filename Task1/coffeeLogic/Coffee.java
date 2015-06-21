package coffeeLogic;
import coffeeEnums.*;

public class Coffee implements Comparable<Coffee> {
	private CoffeeState stateOfCoffee;
	private Packaging packagingOfCoffee;
	private TypeOfCoffee typeOfCoffee;
	private double price;
	private double weight;
	
	public Coffee( CoffeeState stateOfCoffee,Packaging packagingOfCoffee,
			TypeOfCoffee typeOfCoffee,double price,double weight){
		this.stateOfCoffee=stateOfCoffee;
		this.packagingOfCoffee=packagingOfCoffee;
		this.typeOfCoffee=typeOfCoffee;
		this.price=price;
		this.weight=weight;
	}
	
	@Override
	public int compareTo(Coffee arg0) {
		double answer=this.getPrice()/this.getWeight()-arg0.getPrice()/arg0.getWeight();
		if (answer>0) { return 1;}
		else { 
			if (answer<0) {return -1;}
			else { return 0;}
		}
	}
	
	public TypeOfCoffee getTypeOfCoffee() {
		return typeOfCoffee;
	}
	public void setTypeOfCoffee(TypeOfCoffee typeOfCoffee) {
		this.typeOfCoffee = typeOfCoffee;
	}
	public Packaging getPackagingOfCoffee() {
		return packagingOfCoffee;
	}
	public void setPackagingOfCoffee(Packaging packagingOfCoffee) {
		this.packagingOfCoffee = packagingOfCoffee;
	}
	public CoffeeState getStateOfCoffee() {
		return stateOfCoffee;
	}
	public void setStateOfCoffee(CoffeeState stateOfCoffee) {
		this.stateOfCoffee = stateOfCoffee;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String  toString(){
		StringBuilder sb =new StringBuilder();
		sb.append(stateOfCoffee.toString());
		sb.append(" ");
		sb.append(packagingOfCoffee.toString());
		sb.append(" ");
		sb.append(typeOfCoffee.toString());
		sb.append(" ");
		sb.append((new Double (price)).toString());
		sb.append("$ ");
		sb.append((new Double (weight)).toString());
		sb.append("kg");	
		return sb.toString();
	}

}
