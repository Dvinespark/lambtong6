package com.lambton.models;

import java.sql.Date;

public class Account {
	private int id;
	private int agent_id;
	private String username;
	private String password;
	private String email;
	private AccountTypes accountTypes;
	private Bank bank;
	private String address;
	private Date created_date;
	private float balance;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int id, int agent_id, String username, String password, String email, AccountTypes accountTypes,
			Bank bank, String address, Date created_date, float balance) {
		super();
		this.id = id;
		this.agent_id = agent_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.accountTypes = accountTypes;
		this.bank = bank;
		this.address = address;
		this.created_date = created_date;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AccountTypes getAccountTypes() {
		return accountTypes;
	}
	public void setAccountTypes(AccountTypes accountTypes) {
		this.accountTypes = accountTypes;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	

}


class AccountTypes {
	private String account_types_code;
	private String description;
	public AccountTypes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountTypes(String account_types_code, String description) {
		super();
		this.account_types_code = account_types_code;
		this.description = description;
	}
	public String getAccount_types_code() {
		return account_types_code;
	}
	public void setAccount_types_code(String account_types_code) {
		this.account_types_code = account_types_code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}	

class Bank {
	private int id;
	private String name;
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bank(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}