package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private Connection dbConnection;
	
	public void getConnection() throws SQLException{
		//Class.forName("com.oracle.jdbc.Driver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "bear";
		String password = "bear";
		dbConnection = DriverManager.getConnection(url, user, password);
	}
	
	public int executeQuery(String query) throws SQLException {
		return dbConnection.createStatement().executeUpdate(query);
	}
}
