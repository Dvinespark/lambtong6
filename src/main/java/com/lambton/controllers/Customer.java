package com.lambton.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.lambton.dao.CustomerDAO;
import com.lambton.dao.AccountDAO;

@WebServlet("/customer")
public class Customer extends HttpServlet {
	CustomerDAO customerDAO = new CustomerDAO();
	AccountDAO accountDAO = new AccountDAO();
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Customer() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get customer data
		HttpSession session = request.getSession();
		SessionHandler sessionHandler = (SessionHandler) session.getAttribute("lambton_session");
		sessionHandler.page_title = "customer";
		session.setAttribute("lambton_session", sessionHandler);
		
		com.lambton.models.Customer customer = customerDAO.getCusomerById(sessionHandler.customer_id);
		List<com.lambton.models.Account> accounts = accountDAO.getAccounts(sessionHandler.customer_id);
		request.setAttribute("customer", customer);
		request.setAttribute("accounts", accounts);
		
		request.getRequestDispatcher("Customer/dashboard.jsp").forward(request, response);
	}

}
