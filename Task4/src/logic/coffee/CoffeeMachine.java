package logic.coffee;

import java.sql.SQLException;
import java.util.ArrayList;

import logic.users.User;


import workingWithDB.DB;

public class CoffeeMachine {
	ArrayList<Resource> resources;
	private static CoffeeMachine cM;//=new CoffeeMachine();
	public DB db;
	private CoffeeMachine() throws SQLException{	
		db=new DB();
		resources=db.getResources();
	}
	public static CoffeeMachine getCoffeeMachine() throws SQLException{
		if (cM==null){
			cM=new CoffeeMachine();
		}
		return cM;
	}

	public void fill(ArrayList<Resource> res) throws SQLException{
		for(Resource r:res){
			for(Resource r2:resources){
				if (r.equals(r2)){
					r2.add(r);
				}
			}	
		}
		CoffeeMachine.getCoffeeMachine().db.setResources(this);
	}
	public static void main(String[] args) throws SQLException {
		CoffeeMachine.getCoffeeMachine();
		User u=new User();
		System.out.print(u.checkPasswordCorrect("ADmin", "qazwsx"));
		System.out.print(u.checkPasswordCorrect("Ann", "123"));
		System.out.print(u.checkPasswordAdmin("qazwsx"));
		System.out.print(u.checkPasswordAdmin("qazwsx12"));
		ArrayList<Resource> al=new ArrayList<Resource>();
		al.add(new Ingredient("sugar",1,5));
		u.fillCoffeeMachine(cM,al);
	}
}
