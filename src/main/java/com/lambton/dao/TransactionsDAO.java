package com.lambton.dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lambton.models.Account;
import com.lambton.models.TransactionType;
import com.lambton.models.Transactions;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import DBConnection.DbConnection;

public class TransactionsDAO {

	private DbConnection dbConnection;
	private Connection con;
	private AccountDAO accountDAO;
	private TransactionTypesDAO transactionTypeDAO;

	
	public TransactionsDAO() {
		this.dbConnection = new DbConnection();
		this.con = dbConnection.getConnection();
		this.accountDAO = new AccountDAO();
		this.transactionTypeDAO = new TransactionTypesDAO();
	}
	

	public List<Transactions> getTransactionsbyAccountId(int accountId) {
		List<Transactions> transactions = new ArrayList<Transactions>();
		String sql="select * from transactions where from_account_id=? order by created_at desc limit 10;";

		//For Select statement we can use Connection Interface
		try {
			
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, accountId);

			ResultSet rs=(ResultSet) stmt.executeQuery();
			while(rs.next())
			{
				Account from_account = this.accountDAO.getAccountById(accountId);
				Account to_account = this.accountDAO.getAccountById(rs.getInt("to_account_id"));
				TransactionType transactionType = this.transactionTypeDAO.getTransactionTypeByCode(rs.getString("transaction_code"));
				
				Transactions transaction = new Transactions(
						rs.getInt("id"), 
						from_account, 
						rs.getFloat("amount"), 
						rs.getDate("created_at"), 
						transactionType,
						to_account
						);
				transactions.add(transaction);
				 
			}
		} 	
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return transactions;	
	}
	
	public int AddTransaction(Transactions transaction) {
		int status = 0;
		String sql="insert into transactions(from_account_id, amount, transaction_code, to_account_id) "
				+ "values(?,?,?,?)";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, transaction.getFromAccount().getId());
			stmt.setFloat(2, transaction.getAmount());
			stmt.setString(3, transaction.getTransactionType().getTransaction_code());
			stmt.setInt(4, transaction.getToAccount().getId());

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
}
