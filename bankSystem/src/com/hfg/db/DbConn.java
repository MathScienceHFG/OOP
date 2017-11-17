package com.hfg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DbConn
{
	public static  Connection getconn()
	{
		Connection conn = null;
		
		String user   = "root";
		String passwd = "hexin123";
		String url = "jdbc:mysql://localhost:3306/test?createDatabaseIfNotExist=true&useSSL=false";//
		
		//已加载完驱动
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,passwd);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return conn;
	}

}
