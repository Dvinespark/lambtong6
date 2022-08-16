package com.lambton.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.lambton.dao.TransactionsDAO;
import com.lambton.models.Account;
import com.lambton.models.TransactionType;
import com.lambton.dao.AccountDAO;
import com.lambton.dao.TransactionTypesDAO;
import com.lambton.dao.BankDAO;


@WebServlet("/view_account")
public class ViewAccount extends HttpServlet {
	AccountDAO accountDAO = new AccountDAO();
	TransactionsDAO transactionsDAO = new TransactionsDAO();
	TransactionTypesDAO transactionTypesDAO = new TransactionTypesDAO();
	BankDAO bankDAO = new BankDAO();
	private static final long serialVersionUID = 1L;


    public ViewAccount() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get: /view_account");
		System.out.println(request.getParameter("account_id"));
		int account_id = Integer.valueOf(request.getParameter("account_id"));
	
		
		com.lambton.models.Account account = accountDAO.getAccountById(account_id);
		List<com.lambton.models.Transactions> transactions = transactionsDAO.getTransactionsbyAccountId(account_id);
		List<com.lambton.models.TransactionType> transactionTypes = transactionTypesDAO.getTransactionTypeList();
		List<com.lambton.models.Bank> banks = bankDAO.getBankList();
		
		request.setAttribute("account", account);
		request.setAttribute("transactions", transactions);
		request.setAttribute("transactionTypes", transactionTypes);
		request.setAttribute("banks", banks);
		
		// transactions
		HttpSession session = request.getSession();
		SessionHandler sessionHandler = (SessionHandler) session.getAttribute("lambton_session");
		sessionHandler.page_title = "view_account";
		session.setAttribute("lambton_session", sessionHandler);
		

		
		request.getRequestDispatcher("ViewAccount/viewAccount.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post: /view_account");
		
		HttpSession session = request.getSession();
		SessionHandler sessionHandler = (SessionHandler) session.getAttribute("lambton_session");

		
		int from_account = Integer.valueOf(request.getParameter("from_account"));
		int to_account = Integer.valueOf(request.getParameter("to_account"));
		String transaction_code = request.getParameter("transaction_code");
		String name = request.getParameter("name");
		int bank_id = Integer.valueOf(request.getParameter("bank_id"));
		float amount = Float.valueOf(request.getParameter("amount"));
	
		// add to transaction object
		com.lambton.models.Account f_account = accountDAO.getAccountById(from_account);
		com.lambton.models.Account t_account = accountDAO.getAccountById(to_account);
		com.lambton.models.TransactionType t_type = transactionTypesDAO.getTransactionTypeByCode(transaction_code);
		com.lambton.models.Transactions transaction = new com.lambton.models.Transactions(
				f_account, amount, t_type, t_account);
		
		
		
		// add to database
		int result = 0;
		if (t_account != null) {
			// check if balance exists
			result = transactionsDAO.AddTransaction(transaction);		
		}
		
		
		if (result > 0) {
			// success
			sessionHandler.message = "Operation completed successfully.";
			
		}
		else {
			sessionHandler.message = "Something happened";
		}
		
		
		String url = "view_account?account_id=" + String.valueOf(from_account);
		System.out.println(url);
		
		
		sessionHandler.page_title = "view_account";
		session.setAttribute("lambton_session", sessionHandler);
		
		response.sendRedirect(url);
		return;
		
	}

}
