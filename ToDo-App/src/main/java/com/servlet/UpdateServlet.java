package com.servlet;

import java.io.IOException;

import com.DAO.ToDoDAO;
import com.DB.DBConnect;
import com.entity.ToDo_Details;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String todo = request.getParameter("todo");
		String status = request.getParameter("status");
		
		ToDoDAO dao = new ToDoDAO(DBConnect.getconn());
		
		ToDo_Details t = new ToDo_Details();
		t.setId(id);
		t.setName(username);
		t.setTodo(todo);
		t.setStatus(status);
		

		boolean f = dao.updateTodo(t);
		HttpSession session = request.getSession();
		if(f) {
			session.setAttribute("sucMsg", "Todo Updated Successfully");
			response.sendRedirect("index.jsp");
		}else {
			session.setAttribute("failedMsg", "Something wrong on server");
			response.sendRedirect("index.jsp");
		}
		
	}
	
}
