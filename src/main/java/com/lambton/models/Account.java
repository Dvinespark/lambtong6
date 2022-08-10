package com.lambton.models;

import java.sql.Date;

public class Account {
	private int id;
	private int customer_id;
	private AccountTypes accountTypes;
	private Bank bank;
	private Date created_date;
	private float balance;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int id, int customer_id, AccountTypes accountTypes, Bank bank, Date created_date, float balance) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.accountTypes = accountTypes;
		this.bank = bank;
		this.created_date = created_date;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	
	
	
	

}
