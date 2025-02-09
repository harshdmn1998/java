package com.web;

import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.web.dao.UserDAO;
import com.web.model.User;

@WebServlet("/adduser")
public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		// Fetching form data
		String uname = request.getParameter("uname");
		String tech = request.getParameter("tech");
		
		//Creating User Object		
		User user = new User();
		user.setUname(uname);
		user.setTech(tech);

		//Using UserDAO to insert data
		UserDAO dao = new UserDAO();
		boolean isAdded = dao.addUser(user);
		
		//Redirecting based on success or failure
		if(isAdded) {
			request.setAttribute("message", "User Added Successfully!");
			RequestDispatcher rd = request.getRequestDispatcher("showUsers.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("error", "Failed to add user!");
			RequestDispatcher rd = request.getRequestDispatcher("addUser.jsp");
			rd.forward(request, response);
		}
		
	}

}
