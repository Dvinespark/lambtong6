package com.lambton.controllers;

import java.io.IOException;

import com.lambton.dao.AgentDAO;
import com.lambton.dao.CustomerDAO;
import com.lambton.models.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/login")
public class Login extends HttpServlet {
	AgentDAO agentDAO = new AgentDAO();
	CustomerDAO customerDAO = new CustomerDAO();
	
//	Models
	com.lambton.models.Agent agent;
	com.lambton.models.Customer customer;
	private static final long serialVersionUID = 1L;

    HttpSession session;
    SessionHandler sessionHandler;
    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get: /lambtong6/login");
		sessionHandler = new SessionHandler();
		session.setAttribute("lambton_session", sessionHandler);
		request.getRequestDispatcher("Login/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("post: /lambtong6/login");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String login_type = request.getParameter("login_type");
		
		session = request.getSession();
		if (login_type.equals("admin")){
			agent = agentDAO.login(username, password);
			System.out.println("Agent--Details: ");
			if (agent != null) {
				System.out.println(agent.getFirstname());
				sessionHandler = new SessionHandler(agent.getId(), 0, true, "Admin", "Admin Login Success", login_type, agent.getFirstname());
				session.setAttribute("lambton_session", sessionHandler);
				System.out.println("Hello world");
				/*
				 * request.getRequestDispatcher("Customer/dashboard.jsp").forward(request,
				 * response);
				 */
				response.sendRedirect(request.getContextPath() + "/customer");
			}
		}
		else if(login_type.equals("customer")) {
			customer = customerDAO.login(username, password);
			if (customer != null) {
				sessionHandler = new SessionHandler(customer.getId(), null, true, "Customer", "Customer Login Success", login_type, customer.getFirstname());
				session.setAttribute("lambton_session", sessionHandler);
				response.sendRedirect(request.getContextPath() + "/customer");
			}
		}	
		else {
			doGet(request, response);
		}
		
	}

}
