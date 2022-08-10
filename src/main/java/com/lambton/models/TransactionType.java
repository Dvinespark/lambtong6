package com.lambton.models;

public class TransactionType {
	
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
