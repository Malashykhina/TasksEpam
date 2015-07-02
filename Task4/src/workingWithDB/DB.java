package workingWithDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import logic.coffee.Coffee;
import logic.coffee.Ingredient;
import logic.coffee.Resource;
import logic.coffee.CoffeeMachine;
import logic.users.User;

public class DB {
	private static Connection conn = null;
	private final String userName = "root";
	private final String password = "qazwsx";
	private final String serverName = "localhost";
	private final int portNumber = 3306;
	private final String dbName = "CoffeeDB";
	
	public DB() throws SQLException{
		conn=getConnection();
	}
	public Connection getConnection() throws SQLException {
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://" + this.serverName + ":" + this.portNumber + "/" + this.dbName,connectionProps);

		return conn;
	}

	public ArrayList <Resource> getResources() {
		ArrayList <Resource> answer = new ArrayList <Resource>();
		try {
			Statement stmt = conn.createStatement();
			 ResultSet r = stmt.executeQuery("Select * from Additives");
			 while(r.next()){
				answer.add(new Ingredient(r.getInt(1), r.getString(2), r.getDouble(3),r.getInt(4)));
			 }
			 r = stmt.executeQuery("Select * from Coffee");
			 while(r.next()){
				answer.add(new Coffee(r.getInt(1), r.getString(2), r.getDouble(3),r.getInt(4)));
			 }
			 for(Resource t: answer){//
				 System.out.println(t);//
			} //
		} catch (SQLException e) {
			System.out.println("ERROR: Could take data from Ingredients");
			e.printStackTrace();			
		}
		return answer;

	}
	
	public void setResources(CoffeeMachine cM) {
	//to do
	}
	
	public ArrayList <Ingredient> getIngredients() {
		ArrayList <Ingredient> answer = new ArrayList <Ingredient>();
		try {
			Statement stmt = conn.createStatement();
			 ResultSet r = stmt.executeQuery("Select * from Additives");
			 while(r.next()){
				answer.add(new Ingredient(r.getInt(1), r.getString(2), r.getDouble(3),r.getInt(4)));
			 }
		} catch (SQLException e) {
			System.out.println("ERROR: Could take data from Ingredients");
			e.printStackTrace();			
		}
		return answer;

	}
	
	public ArrayList <Coffee> getDrinks() {
		ArrayList <Coffee> answer = new ArrayList <Coffee>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet r= stmt.executeQuery("Select * from Coffee");
			 while(r.next()){
				answer.add(new Coffee(r.getInt(1), r.getString(2), r.getDouble(3),r.getInt(4)));
			 }
		} catch (SQLException e) {
			System.out.println("ERROR: Could take data from Ingredients");
			e.printStackTrace();			
		}
		return answer;

	}
	
	public ArrayList <User> getUsers() {
		ArrayList <User> answer = new ArrayList <User>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet r= stmt.executeQuery("Select * from User");
			 while(r.next()){
				answer.add(new User(r.getInt(1), r.getString(2), r.getString(3)));
			 }
		} catch (SQLException e) {
			System.out.println("ERROR: Could take data from Ingredients");
			e.printStackTrace();			
		}
		return answer;

	}

}
