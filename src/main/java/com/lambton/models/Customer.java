package com.lambton.models;

import java.sql.Date;

public class Customer {
	private int id;
	private int agent_id;
	private String username;
	private String password;
	private String email;
	private String address;
	private String firstname;
	private String lastname;
	private Date created_date;
	private int age;
	private boolean email_verify;
	private String phone_no;
	private int sin_no;
	
	

	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Customer(int agent_id, String username, String password, String email, String address,
			String firstname, String lastname, int age, boolean email_verify, String phone_no, int sin_no) {
		super();
		this.agent_id = agent_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email_verify = email_verify;
		this.phone_no = phone_no;
		this.sin_no = sin_no;
	}
	

	public Customer(int id, int agent_id, String username, String password, String email, String address,
			String firstname, String lastname, Date created_date, int age, boolean email_verify, String phone_no,
			int sin_no) {
		super();
		this.id = id;
		this.agent_id = agent_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.firstname = firstname;
		this.lastname = lastname;
		this.created_date = created_date;
		this.age = age;
		this.email_verify = email_verify;
		this.phone_no = phone_no;
		this.sin_no = sin_no;
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





	public String getFirstname() {
		return firstname;
	}





	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}





	public String getLastname() {
		return lastname;
	}





	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isEmail_verify() {
		return email_verify;
	}


	public void setEmail_verify(boolean email_verify) {
		this.email_verify = email_verify;
	}





	public String getPhone_no() {
		return phone_no;
	}





	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}





	public int getSin_no() {
		return sin_no;
	}





	public void setSin_no(int sin_no) {
		this.sin_no = sin_no;
	}
	
	
	
}
