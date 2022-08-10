package com.lambton.dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.lambton.models.Agent;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import DBConnection.DbConnection;


public class AgentDAO {
	
	private DbConnection dbConnection;
	private Connection con;

	public AgentDAO() {
		this.dbConnection = new DbConnection();
		this.con = dbConnection.getConnection();
	}
	
	public Agent login(String username, String password) {
		Agent agent = null;
		String sql="select * from agent where username=? and password=?";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
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
