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
	
	@SuppressWarnings("null")
	public List<Transactions> getTransactionsbyAccountId(int accountId) {
		List<Transactions> transactions = null;
		String sql="select * from transactions where account_id=?;";

		//For Select statement we can use Connection Interface
		try {
			
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, accountId);

			ResultSet rs=(ResultSet) stmt.executeQuery(sql);
			if(rs.next())
			{
				Account account = this.accountDAO.getAccountById(accountId);
				TransactionType transactionType = this.transactionTypeDAO.getTransactionTypeByCode(rs.getString("transaction_code"));
				
				Transactions transaction = new Transactions(
						rs.getInt("id"), 
						account, 
						rs.getFloat("amount"), 
						rs.getDate("created_date"), 
						transactionType
						);
				transactions.add(transaction);
				 
			}
			else {
				transactions = new ArrayList<Transactions>();
			}
		} 	
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return transactions;	
	}
	
	public int AddTransaction(Transactions transaction) {
		int status = 0;
		String sql="insert into transactions(account_id, amount, transaction_code) "
				+ "values(?,?,?)";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, transaction.getAccount().getId());
			stmt.setFloat(2, transaction.getAmount());
			stmt.setString(3, transaction.getTransactionType().getTransaction_code());

			
			status=stmt.executeUpdate();
			if(status>0)
			{
				// write logic here to add or subtract amount from bank
//				if (transaction.getTransactionType().getTransaction_code())
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