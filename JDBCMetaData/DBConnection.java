package com.javacodegeeks.jdbc.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Andres.Cespedes
 * @version 1.0 $Date: 24/01/2015
 * @since 1.7
 *
 */
public class DBConnection {

	private static String DB_URL = "jdbc:mysql://localhost:3307/test";
	private static String DB_USER = "admin";
	private static String DB_PASSWORD = "admin";

	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(DB_URL, DB_USER,
				DB_PASSWORD);
		System.err.println("The connection is successfully obtained");
		return connection;
	}
}
