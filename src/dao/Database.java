package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database
{
	public Connection getConnection() throws Exception
	{
		try
		{
//			String connectionURL = "jdbc:mysql://ec2-23-21-211-172.compute-1.amazonaws.com:3306/thiefbd";
			String connectionURL = "jdbc:mysql://localhost:3306/thiefdb";
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "admin");
//			connection = DriverManager.getConnection(connectionURL, "cyanaka", "287386");
			return connection;
		} catch (Exception e)
		{
			throw e;
		}
		
	}

}
