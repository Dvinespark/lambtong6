package com.lambton.controllers;

import java.io.IOException;

import com.lambton.dao.AgentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/agent")
public class Agent extends HttpServlet {
	AgentDAO agentDAO = new AgentDAO();
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Agent() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get agent_id from session
		
		HttpSession session = request.getSession();
		SessionHandler sessionHandler = (SessionHandler) session.getAttribute("lambton_session");
		sessionHandler.page_title = "agent";
		session.setAttribute("lambton_session", sessionHandler);
		
		com.lambton.models.Agent agent = agentDAO.getAgentById(sessionHandler.agent_id);
		request.setAttribute("agent", agent);
		request.getRequestDispatcher("Agent/agent_dashboard.jsp").forward(request, response);
	}

}
