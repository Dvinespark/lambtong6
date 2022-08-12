package com.lambton.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import com.lambton.model.*;

/**
 * Servlet implementation class Home
 */
@WebServlet("/")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();	
		response.setContentType("text/html");
		out.print("<h3 style='color:red;text-align:center'>Welcome from this Web Application</h3><br><br>");
		String  url = request.getServletPath();
		System.out.println("url:" + url);
	
		//page routing template for landing page
			System.out.println(url);
			switch(url) {		
			case ("/create"):{			
				create(request,response);
				break ;
			}		
			case ("/read"):{			
				out.print("Welcome to display all records feature of the Servlet");
				display(request, response);			
				break ;
			}
			case ("/delete"):{
				out.print("Welcome to Delete Record feature of the Servlet");
				delete(request,response);
				break ;
			}
			
			default:{		
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Post method triggered.");
		

		HttpSession session = request.getSession();
		session.setAttribute("customers",customers );	
		response.sendRedirect("display.jsp");	
	}

}
