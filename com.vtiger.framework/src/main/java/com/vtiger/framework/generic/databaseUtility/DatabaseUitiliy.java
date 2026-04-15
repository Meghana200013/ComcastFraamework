package com.vtiger.framework.generic.databaseUtility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUitiliy {
         Connection conn;

		public void getDbconnection() throws Throwable
		{
			try
			{
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm","root@%","root");
			}
			catch(Exception e)
			{
				System.out.println("Handle exception");
			}
		}
		
		public void closeDbConnection() throws SQLException
		{
			try {
			conn.close();
			System.out.println("Database closed");
		}
			catch(Exception e)
			{
				
			}
		}
		public ResultSet executeSelectQuery(String query) throws SQLException
		{
			ResultSet result=null;
			try {
			Statement state= conn.createStatement();
			result = state.executeQuery(query);
			}catch(Exception e) {
				
			}
			return result;
		}
		
		public int executeNonSelectQuery(String query) throws SQLException
		{
			int result=0;
			try {
			Statement state = conn.createStatement();
			result = state.executeUpdate(query);
		}catch(Exception e) {
			
		}
			return result;
		
		}
		
		
		
		
	}


