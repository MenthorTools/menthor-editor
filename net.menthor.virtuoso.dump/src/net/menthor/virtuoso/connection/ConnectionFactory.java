package net.menthor.virtuoso.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private final static String virtuosoUrl = "jdbc:virtuoso://localhost:1111/charset=UTF-8";
	private final static String user = "dba";
	private final static String pass = "dba";
	
	public static String getVirtuosourl() {
		return virtuosoUrl;
	}
	
	static public String getPass() {
		return pass;
	}
	
	static public String getUser() {
		return user;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		return getConnection(virtuosoUrl, user, pass);
	}
	
	public Connection getConnection(String connectionString, String user, String pass) throws ClassNotFoundException, SQLException
	{
    	Class.forName("virtuoso.jdbc4.Driver");
    	return DriverManager.getConnection(connectionString, user, pass);
	}

}
