package com.lambton.controllers;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.lambton.dao.CustomerDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/accountRecover")
public class AccountRecover extends HttpServlet {
	// Email configurations
	CustomerDAO customerDAO = new CustomerDAO();
	String host = "localhost";
	final String from_user = "lambtong6@gmail.com";
	final String from_password = "mikdxlfomghitsav";
	String to = "nimtsubash@gmail.com";
	
	private static final long serialVersionUID = 1L;


    public AccountRecover() {
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get: /recover");	
		HttpSession session = request.getSession();
		SessionHandler sessionHandler = (SessionHandler) session.getAttribute("lambton_session");
		sessionHandler.page_title = "recover";
		session.setAttribute("lambton_session", sessionHandler);
		
		request.getRequestDispatcher("AccountRecover/recover.jsp").forward(request, response);

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

		System.out.println("post: /recover");

		// get agent_id from session
		HttpSession session = request.getSession();
		SessionHandler sessionHandler = (SessionHandler) session.getAttribute("lambton_session");
		sessionHandler.page_title = "recover";

		// step 1 get form data
		String email = request.getParameter("email");
		String sin = request.getParameter("sin_no");
		int sin_no = sin != "" ? Integer.valueOf(request.getParameter("sin_no")) : 0;
		
		// get Customer obj
		com.lambton.models.Customer customer = customerDAO.getCustomerBySinAndEmail(sin_no, email);

		if(customer != null) {
			// generate new password
			String new_password = generatePassword();
			
			// update password
			int result = customerDAO.UpdatePassword(customer.getId(), new_password);
			// send email about new object
			

			if (result > 0) {
				// success
				sendMessage(customer.getEmail(), customer.getUsername(), customer.getPassword());
				// send email and display message
				sessionHandler.message = "Password has been updated and sent to Customers email address.";
				
				
				// redirect to admin page
				doGet(request, response);
			}
		}
		sessionHandler.message = "No Account match.";
		session.setAttribute("lambton_session", sessionHandler);
		doGet(request, response);
	}

	protected void sendMessage(String to_email, String username, String password) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
//        props.setProperty("mail.debug", "true");
        
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
			message.setText("Welcome to LambtonG6 Bank!\n"
					+ "Password update successful.\n"
					+ "Current username: " + username + "\nNew password: " + password);

			// send the message
			Transport.send(message);

			System.out.println("password update message sent...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}



}
