package com.util;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {
private static final String DB_DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
private static final String DB_USERNAME="root";
private static final String DB_PASSWORD="";
private static final String DB_URL="jdbc:mysql://localhost:3306/dao";
private static Connection connection=null;
public static Connection getConnection()
{
	try
	{
		Class.forName(DB_DRIVER_CLASS);
		connection=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
	}
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
		
	}
	catch( SQLException e)
	{
		e.printStackTrace();
	}
	return connection;	
}

}
