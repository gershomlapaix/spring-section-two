package com.lapaix.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		// useSSL: avoid mysql ssl warnings
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connecting to the database..."+jdbcUrl);
		
            Connection conn = DriverManager.getConnection(jdbcUrl,user, pass);
            
            System.out.println("Connected successfully!!!");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
