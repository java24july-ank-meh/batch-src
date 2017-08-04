package com.revature.util;

import java.sql.*;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "bear";
		String password = "bear";
		return DriverManager.getConnection(url, user, password);
	}
	
}
