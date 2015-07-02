package logic.coffee;

public class Coffee extends Resource{
	public Coffee(int idCoffeeNew, String coffeeTypeNew ,double pricePerServingNew,int servingsLeftNew){
		 idResource=idCoffeeNew;
		 resourceType=coffeeTypeNew;
		 pricePerServing=pricePerServingNew;
		 servingsLeft=servingsLeftNew;
		 }
	@Override
	public String toString(){
		return resourceType;
	}
}
