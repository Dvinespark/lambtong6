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
		Agent agent = new Agent();
		String sql="SELECT * FROM agent WHERE username = ? AND password = ?;";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs=(ResultSet) stmt.executeQuery();
			if(rs.next())
			{
				 agent= new Agent(rs.getInt("id"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("username"),rs.getString("password"));

			}
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return agent;	
	}
	
	public Agent getAgentById(int id) {
		Agent agent = null;
		String sql="SELECT * FROM agent WHERE id = ?;";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs=(ResultSet) stmt.executeQuery();
			if(rs.next())
			{
				 agent= new Agent(rs.getInt("id"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("username"),rs.getString("password"));

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
