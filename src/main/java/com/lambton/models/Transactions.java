package com.lambton.models;

import java.sql.Date;

public class Transactions {
	private int id;
	private Account fromAccount;
	private float amount;
	private Date created_at;
	private TransactionType transactionType;
	private Account toAccount;
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transactions(int id, Account from_account, float amount, Date created_at, TransactionType transactionType, Account to_account) {
		super();
		this.id = id;
		this.fromAccount = from_account;
		this.amount = amount;
		this.created_at = created_at;
		this.transactionType = transactionType;
		this.toAccount = to_account;
	}
	
	public Transactions(Account from_account, float amount,TransactionType transactionType, Account to_account) {
		super();
		this.fromAccount = from_account;
		this.amount = amount;
		this.transactionType = transactionType;
		this.toAccount = to_account;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	
}
