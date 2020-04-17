package dev.jian.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	public static Connection createConnection() {
		
		try {
			Properties props = new Properties();
			
			// This won't work with the servlet, the servlet does not recognize the path
//			FileInputStream in = new FileInputStream("src/main/resources/connection.properties");
			// Need to specify the class name of the jdbc driver
			Class.forName("org.mariadb.jdbc.Driver");
			FileInputStream in =
					new FileInputStream(ConnectionUtil.class.getClassLoader().getResource("connection.properties").getFile());
			
			props.load(in);
			
			String details = props.getProperty("condetails");
			
			Connection conn = DriverManager.getConnection(details);
			
			return conn;
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;

		}
	}
	
	// Testing connection
	public static void main(String [] args) {
		Connection conn = createConnection();
		System.out.println(conn);
	}
	
	
}
