package com.lambton.controllers;

import java.io.IOException;

import com.lambton.dao.AgentDAO;
import com.lambton.dao.CustomerDAO;

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
		System.out.println("get: /lambtong6/login page");
		// update session
		HttpSession session = request.getSession();
		SessionHandler sessionHandler = (SessionHandler) session.getAttribute("lambton_session");
		sessionHandler.page_title = "login";
		session.setAttribute("lambton_session", sessionHandler);
		
		if (request.getParameter("logout")!= null) {
			logout(request, response);
		}
		else {
			request.getRequestDispatcher("Login/login.jsp").forward(request, response);
		}
		
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		HttpSession session = request.getSession();
		session.removeAttribute("lambton_session");
		response.sendRedirect(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("post: /lambtong6/login");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String login_type = request.getParameter("login_type");
		
		session = request.getSession();
		if (login_type.equals("admin")){
			agent = agentDAO.login(username, password);
			if (agent.getId() != 0) {
				sessionHandler = new SessionHandler(agent.getId(), 0, true, "login", "Admin Login Success", login_type, agent.getFirstname(),"");
				session.setAttribute("lambton_session", sessionHandler);
				response.sendRedirect(request.getContextPath() + "/agent");
				return;
			}
			else {
				sessionHandler = new SessionHandler(0, 0, false, "login", "Admin does not exist.", login_type, "","");
				session.setAttribute("lambton_session", sessionHandler);
			}
		}
		else if(login_type.equals("customer")) {
			customer = customerDAO.login(username, password);
			if (customer.getId() != 0) {
				sessionHandler = new SessionHandler(0, customer.getId(), true, "login", "Customer Login Success", login_type, customer.getFirstname(),"");
				session.setAttribute("lambton_session", sessionHandler);
				response.sendRedirect(request.getContextPath() + "/customer");
				return;
			}
			else {
				sessionHandler = new SessionHandler(0, 0, false, "login", "Customer account does not exist.", login_type, "","");
				session.setAttribute("lambton_session", sessionHandler);
			}
		}	

		System.out.println("this method is being hit;");
		doGet(request, response);

		
	}

}
