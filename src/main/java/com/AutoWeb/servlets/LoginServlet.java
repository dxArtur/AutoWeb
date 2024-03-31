package com.AutoWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    UserDAO userDAO = new UserDAO();
	    Optional<User> userAttemptAuth = userDAO.attemphAuth(email);

	    if (userAttemptAuth.isPresent()) {
	        User user = userAttemptAuth.get();
	        if (password.equals(user.getPassword())) {
	            request.getSession().setAttribute("user", user);
	            response.sendRedirect(request.getContextPath() + "/dashboard.jsp"); 
	        } else {
	            request.setAttribute("mensagemErro", "Senha incorreta.");
	            request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
	        }
	    } else {
	        request.setAttribute("mensagemErro", "Email não registrado.");
	        
	        request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
	    }
	}
}