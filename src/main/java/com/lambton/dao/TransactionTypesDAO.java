package com.lambton.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lambton.models.TransactionType;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import DBConnection.DbConnection;

public class TransactionTypesDAO {

	private DbConnection dbConnection;
	private Connection con;

	public TransactionTypesDAO() {
		this.dbConnection = new DbConnection();
		this.con = dbConnection.getConnection();
	}
	
	@SuppressWarnings("null")
	public List<TransactionType> getTransactionTypeList() {
		List<TransactionType> transactionTypes = null;
		String sql="select * from AccountTypes;";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs=(ResultSet) stmt.executeQuery(sql);
			if(rs.next())
			{
				TransactionType transactionType = new TransactionType(rs.getString("transaction_code"),rs.getString("description"));
				 transactionTypes.add(transactionType);

			}
			else {
				transactionTypes = new ArrayList<TransactionType>();
			}
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return transactionTypes;	
	}
	
	public TransactionType getTransactionTypeByCode(String account_types_code) {
		TransactionType transactionType = null;
		String sql="select * from Bank where account_types_code = ?";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, account_types_code);
			ResultSet rs=(ResultSet) stmt.executeQuery(sql);
			if(rs.next())
			{
				transactionType = new TransactionType(rs.getString("transaction_code"),rs.getString("description"));

			}
			else {
				transactionType = new TransactionType();
			}
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return transactionType;	
	}

}
