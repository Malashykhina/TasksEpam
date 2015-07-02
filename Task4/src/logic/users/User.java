package logic.users;

import java.sql.SQLException;
import java.util.ArrayList;

import logic.coffee.CoffeeMachine;
import logic.coffee.Resource;


public class User {
	private int idUser;
	private String userName;
	private String password;
	private final String adminName="admin";
	
	public String getUserName(){
		return userName;
	}
	public String getPassword(){
		return password;
	}
	
	public User(){
		
	}
	
	public User(int idUser,String userName,String password){
		this.idUser=idUser;
		this.userName=userName;
		this.password=password;
	}

	public boolean checkPasswordCorrect(String userName,String password) throws SQLException{
		boolean ans = false;
		ArrayList<User> aLU= (CoffeeMachine.getCoffeeMachine().db.getUsers());
		for(User u: aLU){
			if ((u.getUserName().toLowerCase()).equals(userName.toLowerCase())){
				if (u.getPassword().equals(password)){
				ans=true;}
			}
		}
		return ans;		
	}
	
	public boolean checkPasswordAdmin(String password) throws SQLException{
		return checkPasswordCorrect(adminName,password);
	}
	public boolean checkPasswordAdmin(String userName,String password) throws SQLException{
		if(userName.toLowerCase().equals(adminName)){
		return checkPasswordCorrect(adminName,password);}
		else return false;
	}

	public void fillCoffeeMachine(CoffeeMachine cm, ArrayList<Resource> resArr) throws SQLException{
		//if (this.checkPasswordAdmin(password)){
		cm.fill(resArr);//}
	}

}
