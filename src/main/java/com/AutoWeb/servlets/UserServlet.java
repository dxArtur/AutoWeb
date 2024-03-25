package com.AutoWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
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
    private UserDAO userDAO;

    public UserServlet() {
        super();
        this.userDAO = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userDAO.listAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/views/users/list_clients.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("update".equals(action)) {
            updateClient(request, response);
        } else {
            addClient(request, response);
        }
    }

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	private void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        Long id = Long.valueOf(request.getParameter("id"));
	        String cpf = request.getParameter("cpf");
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        User user = new User();
	        user.setId(id);
	        user.setCpf(cpf);
	        user.setName(name);
	        user.setEmail(email);
	        user.setPassword(password);

	        userDAO.updateUser(user);

	        response.sendRedirect(request.getContextPath() + "/UserServlet");
	    } catch (NumberFormatException e) {
	        throw new ServletException("ID inválido para atualização de cliente.", e);
	    }
	}

	private void addClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		response.sendRedirect(request.getContextPath() + "/UserServlet");
	}
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
