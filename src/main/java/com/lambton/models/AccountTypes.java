package com.lambton.models;

public class AccountTypes {
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
