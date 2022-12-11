package com.lapaix.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
		
		// useSSL: avoid mysql ssl warnings
		public static void main(String[] args) {

			String jdbcUrl = "jdbc:mysql://localhost:3306/hb_one_to_many_bi?useSSL=false";
			String user = "hbstudent";
			String pass = "hbstudent";
			
			try {
				System.out.println("Connecting to database: " + jdbcUrl);
				
				Connection myConn =
						DriverManager.getConnection(jdbcUrl, user, pass);
				
				System.out.println("Connection successful!!!");
				
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
	}

}
