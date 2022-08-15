package com.lambton.controllers;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import com.lambton.dao.CustomerDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerDAO customerDAO = new CustomerDAO();

	// Email configurations
	String host = "localhost";
	final String from_user = "lambtong6@gmail.com";// change accordingly
	final String from_password = "mikdxlfomghitsav";// change accordingly

	String to = "nimtsubash@gmail.com";// change accordingly

	public Register() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get: /register");
		request.getRequestDispatcher("Register/customer_registration.jsp").forward(request, response);

	}

	protected String generateUsername(String firstname) {
		int random = (int) (Math.random() * 50 + 1);
		String username = firstname + random;
		return username;
	}

	protected String generatePassword() {
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()_";
		SecureRandom rnd = new SecureRandom();
		int password_length = 10;
		StringBuilder sb = new StringBuilder(password_length);
		for (int i = 0; i < password_length; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("post: /register");

		// get agent_id from session
		HttpSession session = request.getSession();
		SessionHandler sessionHandler = (SessionHandler) session.getAttribute("lambton_session");

		// step 1 get form data
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String username = generateUsername(firstname);
		String password = generatePassword();
		int age = Integer.valueOf(request.getParameter("age"));

		// create customer object

		com.lambton.models.Customer customer = new com.lambton.models.Customer(Integer.valueOf(sessionHandler.agent_id),
				username, password, email, address, firstname, lastname, age, true);
		int result = 0;
		if (customerDAO.checkIfCustomerExists(customer) == 0) {
			sessionHandler.error_message = "Customer with given information already exists";
			session.setAttribute("lambton_session", sessionHandler);
			doGet(request, response);
			return;
		}
		result = customerDAO.AddCustomer(customer);

		if (result > 0) {

			// success
			sendMessage(customer.getEmail(), customer.getUsername(), customer.getPassword());
			// send email and display message
			
			// retrive the last inserted record
			customer = customerDAO.login(username, password);
			sessionHandler.customer_id = customer.getId();
			sessionHandler.message = "Credentials has been sent to Customers email address.";
			session.setAttribute("lambton_session", sessionHandler);
			
			// redirect to admin page
			response.sendRedirect(request.getContextPath() + "/agent");
			return;
		}

		doGet(request, response);
	}

	protected void sendMessage(String to_email, String username, String password) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        props.setProperty("mail.debug", "true");
        
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from_user, from_password);
			}
		});
		// Compose the message
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from_user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
			message.setSubject("LambtonG6 Credentials");
			message.setText("Username: " + username + "\nPassword: " + password);

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}
