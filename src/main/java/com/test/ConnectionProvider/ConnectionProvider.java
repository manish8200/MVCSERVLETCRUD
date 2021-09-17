package com.test.ConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	
	private static Connection con = null;
	
	
	public static Connection getConnection() {
		
		if(con != null) {
			return con;
		}else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/myusers?useSSL=false",
						"root", "root");
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println(e);
			}
			return con;
		}
		
	}
}
