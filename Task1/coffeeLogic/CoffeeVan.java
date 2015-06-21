package coffeeLogic;

import java.util.ArrayList;
import java.util.Collections;

public class CoffeeVan {
	private ArrayList<Coffee> allCoffeeInVan=new ArrayList<Coffee>();
	private double price;
	private double weight;
	
	public void sort(){
		Collections.sort(this.allCoffeeInVan);
	}
	
	public CoffeeVan(double priceLimit, double weightLimit, ArrayList<Coffee> allCoffee){
		for (Coffee c : allCoffee){
			if(((this.getPrice()+c.getPrice())<=priceLimit)
					&&((this.getWeight()+c.getWeight())<=weightLimit)){
				allCoffeeInVan.add(c);
			}
		}
		//filling van with coffee according to limitations of price and weight
		
	}
	
	public ArrayList<Coffee> findAllOfQuality(double minPricePerKg, double maxPricePerKg){
		ArrayList<Coffee> answer=new ArrayList<Coffee>();
		for (Coffee c : allCoffeeInVan){
			double quality=c.getPrice()/c.getWeight();
			if((quality>=minPricePerKg)
					&&(quality<=maxPricePerKg)){
				answer.add(c);
			}
		}
		return answer;
		
	}
	
	public ArrayList<Coffee> getAllCoffeeInVan() {
		return allCoffeeInVan;
	}
	public void setAllCoffeeInVan(ArrayList<Coffee> allCoffeeInVan) {
		this.allCoffeeInVan = allCoffeeInVan;
	}
	public double getPrice() {
		double totalPrice=0;
		for (Coffee c : allCoffeeInVan){
			totalPrice+=c.getPrice();
		}
		price=totalPrice;
		return price;
	}
	public double getWeight() {
		double totalWeight=0;
		for (Coffee c : allCoffeeInVan){
			totalWeight+=c.getWeight();
		}
		weight=totalWeight;
		return weight;
	}
	@Override
	public String  toString(){
		StringBuilder sb =new StringBuilder();
		for (Coffee c : allCoffeeInVan){
			sb.append(c);
			sb.append("\n");
		}
		return sb.toString();
	}

	}
