package br.com.senacrs.clinica.library;

import java.sql.Connection;  
import java.sql.DriverManager;  

public class DatabaseConnection {
	
	private static String host = "localhost";
	private static String database = "db_clinica";
	private static String user = "root";
	private static String password = "";
	
	public DatabaseConnection(){}
	
	protected static Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + "?user=" + user + "&password=" + password);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	protected static void close(Connection connect){
		try {
			if(connect != null)
				connect.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
