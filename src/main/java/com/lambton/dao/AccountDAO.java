package com.lambton.dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lambton.models.Account;
import com.lambton.models.AccountTypes;
import com.lambton.models.Bank;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;


import DBConnection.DbConnection;

public class AccountDAO {
	private DbConnection dbConnection;
	private Connection con;
	private AccountTypesDAO accountTypesDAO;
	private BankDAO bankDAO;
	
	public AccountDAO() {
		this.dbConnection = new DbConnection();
		this.con = dbConnection.getConnection();
		this.accountTypesDAO = new AccountTypesDAO();
		this.bankDAO = new BankDAO();
	}
	
	@SuppressWarnings("null")
	public List<Account> getAccounts(int customerId) {
		List<Account> accounts = null;
		String sql="select * from account where customer_id=?;";

		//For Select statement we can use Connection Interface
		try {
			
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, customerId);

			ResultSet rs=(ResultSet) stmt.executeQuery(sql);
			if(rs.next())
			{
				Bank bank = this.bankDAO.getBankById(rs.getInt("bank_id"));
				AccountTypes accountTypes = this.accountTypesDAO.getAccountTypesByCode("account_types_code");				
				Account account = new Account(rs.getInt("id"),rs.getInt("customer_id"), accountTypes, bank,
						rs.getDate("created_date"), rs.getFloat("balance"));
				accounts.add(account);
				 
			}
			else {
				accounts = new ArrayList<Account>();
			}
		} 	
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return accounts;	
	}
	
	
	public int checkIfAccountExists(Account account) {
		int status = 0;
		String sql="select * from account where customer_id = ? and account_types_code=? and bank_id=?;";
		

		//For Select statement we can use Connection Interface
		try {
			
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, account.getCustomer_id());
			stmt.setString(2, account.getAccountTypes().getAccount_types_code());
			stmt.setInt(3, account.getBank().getId());

			ResultSet rs=(ResultSet) stmt.executeQuery(sql);
			if(rs.next())
			{
				status = 1;				

				 
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
	
	public int createAccount(Account account) {
		int status = 0;
		String sql="insert into accounts(id, customer_id, account_types_code, bank_id, balance) "
				+ "values(?,?,?,?,?)";
		

		//For Select statement we can use Connection Interface
		try {
			
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, account.getId());
			stmt.setInt(2, account.getCustomer_id());
			stmt.setString(3, account.getAccountTypes().getAccount_types_code());
			stmt.setInt(4, account.getBank().getId());
			stmt.setFloat(5, account.getBalance());

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
			e.printStackTrace();
		}	
		return status;	
	}
	
	
	public int updateAccountBalance(int account_id, float transaction_amount) {
		int status = 0;
		String sql="update account set balance = (balance-?) where id = ?;";
		

		//For Select statement we can use Connection Interface
		try {
			
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setFloat(1, transaction_amount);
			stmt.setInt(2, account_id);


			status=stmt.executeUpdate();
			if(status>0)
			{
				System.out.println("Amount updated");
			}
			else
			{
				System.out.println("Please try again");
			}
		} 	
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return status;	
	}
	
	public Account getAccountById(int account_id) {
		Account account = null;
		String sql="select * from account where id=?;";

		//For Select statement we can use Connection Interface
		try {
			
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, account_id);

			ResultSet rs=(ResultSet) stmt.executeQuery(sql);
			if(rs.next())
			{
				Bank bank = this.bankDAO.getBankById(rs.getInt("bank_id"));
				AccountTypes accountTypes = this.accountTypesDAO.getAccountTypesByCode("account_types_code");				
				account = new Account(rs.getInt("id"),rs.getInt("customer_id"), accountTypes, bank,
						rs.getDate("created_date"), rs.getFloat("balance"));
				 
			}
			else {
				account = new Account();
			}
		} 	
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return account;	
	}
}
