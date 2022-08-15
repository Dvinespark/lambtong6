package com.lambton.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.lambton.dao.*;

@WebServlet("/account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountTypesDAO accountTypesDAO = new AccountTypesDAO();
	BankDAO bankDAO = new BankDAO();
	CustomerDAO customerDAO = new CustomerDAO();
    public Account() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<com.lambton.models.Bank> banks = bankDAO.getBankList();
		System.out.println(banks.size());
		
		List<com.lambton.models.AccountTypes> accountTypes = accountTypesDAO.getAccountTypeList();
		System.out.println(accountTypes.size());
		
		List<com.lambton.models.Customer> customers = customerDAO.getCustomers();
		System.out.println(customers.size());
		
		request.setAttribute("banks", banks);
		request.setAttribute("accountTypes", accountTypes);
		request.setAttribute("customers", customers);
		request.getRequestDispatcher("Account/customer_account.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		doGet(request, response);
	}

}
