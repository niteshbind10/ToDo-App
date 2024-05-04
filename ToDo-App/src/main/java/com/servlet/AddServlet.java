package com.servlet;

import java.io.IOException;

import com.DAO.ToDoDAO;
import com.DB.DBConnect;
import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username");
		String todo = request.getParameter("todo");
		String status = request.getParameter("status");
		
		ToDoDAO dao = new ToDoDAO(DBConnect.getconn());
		boolean f = dao.addTodo(username, todo, status);
		
		HttpSession session = request.getSession();
		
		if(f) {
			session.setAttribute("sucMsg", "Todo Added Successfully");
			response.sendRedirect("index.jsp");
		}else {
			session.setAttribute("failedMsg", "Todo Added Successfully");
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
