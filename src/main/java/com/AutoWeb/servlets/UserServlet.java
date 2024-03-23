package com.AutoWeb.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Optional;

import com.AutoWeb.entities.User;
import com.AutoWeb.dao.UserDAO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userCpf = request.getParameter("cpf");
		UserDAO userDAO = new UserDAO();
			
		Optional<User> user = userDAO.getUserByCpf(userCpf);
		
		if (user.isPresent()) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("views/user.jsp").forward(request, response);
		} else {
	    	 response.sendRedirect("views/erro.jsp");
	     }
		
		// TODO Auto-generated method stub
		response.getWriter().append("helloworld at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		User newUser = new User();
		
		newUser.setCpf(cpf);
		newUser.setName(name);
		newUser.setEmail(email);
		newUser.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		
		userDAO.addUser(newUser);
		response.sendRedirect("views/sucess.jsp");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
