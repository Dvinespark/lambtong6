package com.lambton.models;

import java.sql.Date;

public class Transactions {
	private int id;
	private Account account;
	private float amount;
	private Date created_at;
	private TransactionType transaction_type;
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transactions(int id, Account account, float amount, Date created_at, TransactionType transaction_type) {
		super();
		this.id = id;
		this.account = account;
		this.amount = amount;
		this.created_at = created_at;
		this.transaction_type = transaction_type;
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
	public TransactionType getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(TransactionType transaction_type) {
		this.transaction_type = transaction_type;
	}
	
	
}


class TransactionType {
	private String transaction_code;
	private String description;
	public TransactionType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionType(String transaction_code, String description) {
		super();
		this.transaction_code = transaction_code;
		this.description = description;
	}
	public String getTransaction_code() {
		return transaction_code;
	}
	public void setTransaction_code(String transaction_code) {
		this.transaction_code = transaction_code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}