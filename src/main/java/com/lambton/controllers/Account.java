package com.lambton.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.lambton.dao.*;

@WebServlet("/account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountTypesDAO accountTypesDAO = new AccountTypesDAO();
	BankDAO bankDAO = new BankDAO();
	CustomerDAO customerDAO = new CustomerDAO();
	AccountDAO accountDAO = new AccountDAO();
    
	public Account() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get: /account");
		List<com.lambton.models.Bank> banks = bankDAO.getBankList();		
		List<com.lambton.models.AccountTypes> accountTypes = accountTypesDAO.getAccountTypeList();		
		List<com.lambton.models.Customer> customers = customerDAO.getCustomers();
		
		request.setAttribute("banks", banks);
		request.setAttribute("accountTypes", accountTypes);
		request.setAttribute("customers", customers);
		
		
		// update session
		HttpSession session = request.getSession();
		SessionHandler sessionHandler = (SessionHandler) session.getAttribute("lambton_session");
		sessionHandler.page_title = "account";
		session.setAttribute("lambton_session", sessionHandler);
		
		request.getRequestDispatcher("Account/customer_account.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post: /account");
		
		// get agent_id from session
		HttpSession session = request.getSession();
		SessionHandler sessionHandler = (SessionHandler) session.getAttribute("lambton_session");
		sessionHandler.page_title = "account";

		// step 1 get form data
		int customer_id = Integer.valueOf(request.getParameter("customer_id"));
		int bank_id = Integer.valueOf(request.getParameter("bank_id"));
		String account_type = request.getParameter("account_type");
		Float balance = Float.valueOf(request.getParameter("balance"));
		
		// get bank obj and account_type obj
		com.lambton.models.Bank bank = bankDAO.getBankById(bank_id);
		com.lambton.models.AccountTypes accountTypes = accountTypesDAO.getAccountTypesByCode(account_type);
		
		// create account model object
		com.lambton.models.Account account = new com.lambton.models.Account(
				customer_id, accountTypes, bank, balance
				);
		System.out.println(accountDAO.checkIfAccountExists(account));
		System.out.println("pointer reached here.");
		// add data to database
		if (accountDAO.checkIfAccountExists(account) >= 1) {
			// account exists
			sessionHandler.message = "Account with given information already exists";
			session.setAttribute("lambton_session", sessionHandler);
			doGet(request, response);
			return;
		}
		int result = 0;
		result = accountDAO.createAccount(account);
		if (result > 0) {

			// success
			sessionHandler.message = "Account has been set up.";
			session.setAttribute("lambton_session", sessionHandler);
			
			// redirect to admin page
			response.sendRedirect(request.getContextPath() + "/agent");
			return;
		}
		session.setAttribute("lambton_session", sessionHandler);
		doGet(request, response);
	}

}
