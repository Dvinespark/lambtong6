package com.lambton.controllers;

public class SessionHandler {
	public Integer agent_id;
	public Integer customer_id;
	public boolean login_flag;
	public String page_title;
	public String error_message;
	public String login_type;
	public String firstname;
	public String message;
	
	
	public SessionHandler() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SessionHandler(Integer agent_id, Integer customer_id, boolean login_flag, String page_title,
			String error_message, String login_type, String firstname, String message) {
		super();
		this.agent_id = agent_id;
		this.customer_id = customer_id;
		this.login_flag = login_flag;
		this.page_title = page_title;
		this.error_message = error_message;
		this.login_type = login_type;
		this.firstname = firstname;
		this.message = message;
	}
	

}
