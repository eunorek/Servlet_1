package com.choa.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	public Connection getConnect() throws Exception {
		String user = "milo";
		String password = "kilo";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		System.out.println("driver loaded");
		return con;
	}
}
