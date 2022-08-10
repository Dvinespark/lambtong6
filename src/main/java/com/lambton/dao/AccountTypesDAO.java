package com.lambton.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lambton.models.AccountTypes;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import DBConnection.DbConnection;

public class AccountTypesDAO {
	private DbConnection dbConnection;
	private Connection con;

	public AccountTypesDAO() {
		this.dbConnection = new DbConnection();
		this.con = dbConnection.getConnection();
	}
	
	
	@SuppressWarnings("null")
	public List<AccountTypes> getAccountTypeList() {
		List<AccountTypes> accountTypes = null;
		String sql="select * from AccountTypes;";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs=(ResultSet) stmt.executeQuery(sql);
			if(rs.next())
			{
				 AccountTypes accountType = new AccountTypes(rs.getString("account_types_code"),rs.getString("description"));
				 accountTypes.add(accountType);

			}
			else {
				accountTypes = new ArrayList<AccountTypes>();
			}
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return accountTypes;	
	}
	
	public AccountTypes getAccountTypesByCode(String account_types_code) {
		AccountTypes accountType = null;
		String sql="select * from Bank where account_types_code = ?";

		//For Select statement we can use Connection Interface
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, account_types_code);
			ResultSet rs=(ResultSet) stmt.executeQuery(sql);
			if(rs.next())
			{
				accountType = new AccountTypes(rs.getString("account_types_code"),rs.getString("description"));

			}
			else {
				accountType = new AccountTypes();
			}
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return accountType;	
	}
}
