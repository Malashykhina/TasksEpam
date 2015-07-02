package logic.coffee;

public class Ingredient extends Resource{

 public Ingredient(int idAdditiveNew, String additiveTypeNew ,double pricePerServingNew,int servingsLeftNew){
	 idResource=idAdditiveNew;
	 resourceType=additiveTypeNew;
	 pricePerServing=pricePerServingNew;
	 servingsLeft=servingsLeftNew;
	 }
 public Ingredient(String additiveTypeNew ,double pricePerServingNew,int servingsLeftNew){
	 resourceType=additiveTypeNew;
	 pricePerServing=pricePerServingNew;
	 servingsLeft=servingsLeftNew;
	 }
 public Ingredient(){
	 }
 public int getIdAdditive() {
	return idResource;
}
public void setIdAdditive(int idAdditive) {
	this.idResource = idAdditive;
}
public String getAdditiveType() {
	return resourceType;
}
public void setAdditiveType(String additiveType) {
	this.resourceType = additiveType;
}
public double getPricePerServing() {
	return pricePerServing;
}
public void setPricePerServing(double pricePerServing) {
	this.pricePerServing = pricePerServing;
}
public int getServingsLeft() {
	return servingsLeft;
}
public void setServingsLeft(int servingsLeft) {
	this.servingsLeft = servingsLeft;
}
}

