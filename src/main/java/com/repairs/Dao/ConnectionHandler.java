package com.repairs.Dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionHandler {

	static Connection connection;

	// this method will connect to the database
	public static Connection getConnection() {
		try {
			Properties prop = new Properties();
			InputStream is = ConnectionHandler.class.getClassLoader().getResourceAsStream("connection.properties");
			prop.load(is);
			Class.forName(prop.getProperty("driver"));
			connection = DriverManager.getConnection(prop.getProperty("connection-url"), prop.getProperty("user"),
					prop.getProperty("password"));
		} catch (Exception e) {
			System.out.println("ConnectionHandler : " + e);
		}
		return connection;
	}
}
