package com.lambton.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lambton.models.Customer;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import DBConnection.DbConnection;

public class CustomerDAO {
	private DbConnection dbConnection;
	private Connection con;
	
	public CustomerDAO() {
		this.dbConnection = new DbConnection();
		this.con = dbConnection.getConnection(); 
	}
	
	
	public Customer login(String username, String password) {
		Customer customer = null;
		String sql="select * from customer where username = ? and password = ?";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs=(ResultSet) stmt.executeQuery();
			if(rs.next())
			{
				customer = new Customer(rs.getInt("id"),rs.getInt("agent_id"), rs.getString("username"),
						rs.getString("password"), rs.getString("email"), rs.getString("address"),
						rs.getString("firstname"), rs.getString("lastname"), rs.getDate("created_date"),
						rs.getInt("age"), rs.getBoolean("email_verify"));
				 
			}
			else {
				customer = new Customer();
			}
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return customer;	
	}
	
	public int AddCustomer(Customer customer) {
		int status = 0;
		String sql="insert into customer(agent_id, username, password, email, address, firstname, lastname, age, email_verify) "
				+ "values(?,?,?,?,?,?,?,?,?)";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, customer.getAgent_id());
			stmt.setString(2, customer.getUsername());
			stmt.setString(3, customer.getPassword());
			stmt.setString(4, customer.getEmail());
			stmt.setString(5, customer.getAddress());
			stmt.setString(6, customer.getFirstname());
			stmt.setString(7, customer.getLastname());
			stmt.setInt(8, customer.getAge());
			stmt.setBoolean(9, customer.isEmail_verify());
			
			status=stmt.executeUpdate();
			if(status>0)
			{
				System.out.println("Record inserted successfully");
			}
			else
			{
				System.out.println("Please try again");
			}
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return status;	
	}
	
	public Customer getCusomerById(int id) {
		Customer customer = null;
		String sql="select * from customer where id = ?;";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs=(ResultSet) stmt.executeQuery();
			if(rs.next())
			{
				customer = new Customer(rs.getInt("id"),rs.getInt("agent_id"), rs.getString("username"),
						rs.getString("password"), rs.getString("email"), rs.getString("address"),
						rs.getString("firstname"), rs.getString("lastname"), rs.getDate("created_date"),
						rs.getInt("age"), rs.getBoolean("email_verify"));
				 
			}
			else {
				customer = new Customer();
			}
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return customer;	
	}
	
	public int checkIfCustomerExists(Customer customer) {
		int status = 0;
		String sql="select * from customer where email = ? and firstname=? and lastname=?;";
		

		//For Select statement we can use Connection Interface
		try {
			
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, customer.getEmail());
			stmt.setString(2, customer.getFirstname());
			stmt.setString(3, customer.getLastname());

			ResultSet rs=(ResultSet) stmt.executeQuery();
			if(rs.next())
			{
				status = 1;				// exists
				 
			}
			else {
				status = 0;
			}
		} 	
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return status;	
	}
	
	
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		String sql="select * from customer;";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs=(ResultSet) stmt.executeQuery();
			while(rs.next())
			{
				Customer customer = new Customer(rs.getInt("id"),rs.getInt("agent_id"), rs.getString("username"),
						rs.getString("password"), rs.getString("email"), rs.getString("address"),
						rs.getString("firstname"), rs.getString("lastname"), rs.getDate("created_date"),
						rs.getInt("age"), rs.getBoolean("email_verify"));
				customers.add(customer);
				 
			}
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return customers;	
	}
	
	

}
