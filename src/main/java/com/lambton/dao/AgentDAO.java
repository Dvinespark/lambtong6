package com.lambton.dao;

import java.sql.DriverManager;
import java.sql.SQLException;


import com.lambton.models.Agent;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;


public class AgentDAO {
	
	public Connection getConnection()
	{
	Connection con = null;
	String user="root";
	String pwd="";
	String url="jdbc:mysql://localhost:3306/lambtong6";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=(Connection) DriverManager.getConnection(url,user,pwd);
		System.out.println("Connection successful!!!");
	} 
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return con;
	}
	
	
	public Agent loginAgent(String username, String password) {
		Agent agent = null;
		Connection con=getConnection();
		String sql="select * from agent";

		//For Select statement we can use Connection Interface
		try {
			Statement stmt=(Statement) con.createStatement();
			ResultSet rs=(ResultSet) stmt.executeQuery(sql);
			if(rs.next())
			{
				 agent= new Agent(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("username"),rs.getString("password"));

			}
			else {
				agent = new Agent();
			}
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return agent;	
	}

}
