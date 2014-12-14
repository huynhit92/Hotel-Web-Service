package com.database.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectDatabase {
	public Connection conn;
	public Statement stm;
	
	private static String cs = "jdbc:mysql://localhost:3306/hotel_database";
	private static String user = "root";
	private static String pass = "admin";
	
	public ConnectDatabase() throws ClassNotFoundException {
		this.init();
	}
	// ket noi CSDl
	public int init() throws ClassNotFoundException{
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // load driver.
			conn = DriverManager.getConnection(cs,user,pass); //creat connection.
			stm = conn.createStatement(); // creat statement.
			return 1;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
		
	}
	
	public void close(){
		try {
			conn.close();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	public Integer query(String sql){
		Integer count = 0;
		try {
			if ( init() == 0 ){
				System.out.print("Connection failed \n");
			}
		    ResultSet rs = stm.executeQuery(sql);
		    while(rs.next()){ 
		    	count++;
		    }
			return count;
		}catch(Exception e){
			e.printStackTrace();
			return count;
		}
	}
	
	public int calculate(int num1,int num2){
		int result = num1 + num2 * 40;
		return result;
	}
	
}