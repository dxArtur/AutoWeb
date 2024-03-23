package com.AutoWeb.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Optional;

import com.AutoWeb.dao.UserDAO;
import com.AutoWeb.entities.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email = request.getParameter("email");
	     String password = request.getParameter("password");
	     
	     UserDAO userDAO = new UserDAO();
	     Optional<User> userAttemphAuth = userDAO.attemphAuth(email);
	     
	     if (userAttemphAuth.isPresent()) {
	    	 User user = userAttemphAuth.get();
		     if ( password.equals(user.getPassword())) {
		    	 request.getSession().setAttribute("user", user);
		    	 response.sendRedirect(request.getContextPath()+ "/views/sucess.jsp");
	    	 } else {
	    		 response.sendRedirect(request.getContextPath() + "/views/erro.jsp");
	    	 }
	     } else {
	    	 response.sendRedirect("/views/erro.jsp");
	     }
	}
}
