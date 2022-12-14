package com.lambton.controllers;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    HttpSession session;
    SessionHandler sessionHandler;
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get: /lambtong6");
		session = request.getSession();
		if (session.getAttribute("lambton_session") == null) {
			sessionHandler = new SessionHandler(0,0,false,"home", "","","","");
			session.setAttribute("lambton_session", sessionHandler);
		}
		
		request.getRequestDispatcher("Home/index.jsp").forward(request, response);

	}
	
}
