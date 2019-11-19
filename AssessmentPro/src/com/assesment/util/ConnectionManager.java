package com.assesment.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	static Connection conn=null;
	public static Properties loadproperties() throws Exception {
		Properties prop = new Properties();
		InputStream in= new FileInputStream("C:\\Users\\eclipse-workspace\\AssessmentPro\\Resources\\jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
	public Connection getConnection() throws Exception {
		Properties prop= loadproperties();
		final String driver=prop.getProperty("driver");
		final String url=prop.getProperty("url");
		final String username=prop.getProperty("username");
		final String password=prop.getProperty("password");
		try {
		Class.forName(driver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		try {
			conn=DriverManager.getConnection(url,username,password);
		}catch(SQLException e) {
			System.out.println("Connection failed. Check output console");
			e.printStackTrace();
			throw e;
		}
		return conn;
	}
}