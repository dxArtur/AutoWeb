package com.AutoWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.AutoWeb.dao.CustomerDAO;
import com.AutoWeb.entities.Customer;

@WebServlet("/CostumerServlet")
public class CostumerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;

    public CostumerServlet() {
        super();
        customerDAO = new CustomerDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String action = request.getParameter("action");
        switch (action) {
            case "addCustomer":
                addCustomer(request, response);
                break;
           
            default:
                break;
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        switch (action) {
            case "updateCustomer":
                updateCustomer(request, response);
                break;
           
            default:
                break;
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        switch (action) {
            case "deleteCustomer":
                deleteCustomer(request, response);
                break;
            
            default:
                break;
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setCpf(cpf);

        customerDAO.addPart(customer);

        response.sendRedirect("index.jsp"); 
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");

        Customer updatedCustomer = new Customer();
        updatedCustomer.setName(name);
        updatedCustomer.setEmail(email);
        updatedCustomer.setCpf(cpf);

        customerDAO.updateCustomerById(id, updatedCustomer);

        response.sendRedirect("index.jsp"); 
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        customerDAO.deleteCustomerById(id);
        response.sendRedirect("index.jsp"); 
    }
}
