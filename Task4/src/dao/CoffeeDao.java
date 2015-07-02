package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.coffee.Coffee;

public class CoffeeDao{
public static ArrayList <Coffee> getCoffee(String cType) {
	ArrayList <Coffee> result=new ArrayList <Coffee>();
	Connection conn = null;
 PreparedStatement pst = null;
 ResultSet rs = null;

 String url = "jdbc:mysql://localhost:3306/";
 String dbName = "CoffeeDB";
 String driver = "com.mysql.jdbc.Driver";
 String userName = "root";
 String password = "qazwsx";
try {
 Class.forName(driver).newInstance();
 conn = DriverManager.getConnection(url + dbName, userName, password);

 pst = conn.prepareStatement("Select * from Coffee");
 pst.setString(1, cType);

 rs= pst.executeQuery("Select * from Coffee");
 while(rs.next()){
	 result.add(new Coffee(rs.getInt(1), rs.getString(2), rs.getDouble(3),rs.getInt(4)));
	 }
 return result;
 } catch (Exception e) {
 System.out.println(e);
 } finally {
 if (conn != null) {
	 try { conn.close();
	 } catch (SQLException e) {
		 e.printStackTrace();}
 	}
 if (pst != null) {
	 try {
		 pst.close();} 
	 catch (SQLException e) {
	 e.printStackTrace();}
	 }
 if (rs != null) {
	 try {
		 rs.close(); 
	 } catch (SQLException e) {
 e.printStackTrace();}
	 }
 }
 return result; }

}