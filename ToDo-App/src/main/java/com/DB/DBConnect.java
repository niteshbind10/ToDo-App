package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection conn;
	public static Connection getconn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "12345678");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
