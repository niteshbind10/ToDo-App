package com.servlet;

import java.io.IOException;

import com.DAO.ToDoDAO;
import com.DB.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		 int id = Integer.parseInt(req.getParameter("id"));
	        ToDoDAO dao = new ToDoDAO(DBConnect.getconn());
	        boolean f = dao.deleteTodo(id);
	        HttpSession session = req.getSession();

	        if (f) {
	            session.setAttribute("sucMsg", "Todo Deleted Successfully");
	        } else {
	            session.setAttribute("failedMsg", "Failed to delete todo");
	        }
	        resp.sendRedirect("index.jsp");
	    }
}
