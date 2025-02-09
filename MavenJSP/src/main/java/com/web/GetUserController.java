package com.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.web.dao.UserDAO;
import com.web.model.User;

@WebServlet("/getuser")
public class GetUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uidParam = request.getParameter("uid");
		UserDAO dao = new UserDAO();
		
		//Check if uid is provided in URL
		if(uidParam != null && !uidParam.isEmpty()) {
			//Fetch single user if uid is provided
			int uid = Integer.parseInt(uidParam);
			User user = dao.getUser(uid);
			request.setAttribute("user", user);
		} else {
			List<User> userList = dao.getUsers();
			request.setAttribute("userList", userList);
		}
		RequestDispatcher rd = request.getRequestDispatcher("showUser.jsp");
		rd.forward(request, response);
	}
}
