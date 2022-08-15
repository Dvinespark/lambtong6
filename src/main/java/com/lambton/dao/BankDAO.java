package com.lambton.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lambton.models.Bank;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import DBConnection.DbConnection;

public class BankDAO {

	private DbConnection dbConnection;
	private Connection con;

	public BankDAO() {
		this.dbConnection = new DbConnection();
		this.con = dbConnection.getConnection();
	}
	
	
	public List<Bank> getBankList() {
		List<Bank> banks = new ArrayList<Bank>();
		String sql="select * from Bank;";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs=(ResultSet) stmt.executeQuery();
			while(rs.next())
			{
				 Bank bank = new Bank(rs.getInt("id"),rs.getString("name"));
				 banks.add(bank);
				 System.out.println(bank);

			}
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return banks;	
	}
	
	public Bank getBankById(int bank_id) {
		Bank bank = null;
		String sql="select * from Bank where id = ?";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, bank_id);
			ResultSet rs=(ResultSet) stmt.executeQuery();
			if(rs.next())
			{
				 bank = new Bank(rs.getInt("id"),rs.getString("name"));

			}
			else {
				bank = new Bank();
			}
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return bank;	
	}
}
