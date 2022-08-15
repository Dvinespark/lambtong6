package com.lambton.models;

import java.sql.Date;

public class Transactions {
	private int id;
	private Account account;
	private float amount;
	private Date created_at;
	private TransactionType transactionType;
	private int to_account_id;
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transactions(int id, Account account, float amount, Date created_at, TransactionType transactionType, int to_account_id) {
		super();
		this.id = id;
		this.account = account;
		this.amount = amount;
		this.created_at = created_at;
		this.transactionType = transactionType;
		this.to_account_id = to_account_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
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
	public int getTo_account_id() {
		return to_account_id;
	}
	public void setTo_account_id(int to_account_id) {
		this.to_account_id = to_account_id;
	}
	
	
}
