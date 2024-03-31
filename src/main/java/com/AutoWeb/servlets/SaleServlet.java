package com.AutoWeb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AutoWeb.dao.CustomerDAO;
import com.AutoWeb.dao.PartDAO;
import com.AutoWeb.dao.SaleDAO;
import com.AutoWeb.entities.Customer;
import com.AutoWeb.entities.Part;
import com.AutoWeb.entities.Sale;
import com.AutoWeb.entities.User;

@WebServlet("/SaleServlet")
public class SaleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SaleDAO saleDAO;

    public SaleServlet() {
        super();
        saleDAO = new SaleDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	PartDAO partDAO = new PartDAO();
        List<Part> parts = partDAO.getAllParts();
        


        request.setAttribute("parts", parts);
        request.getRequestDispatcher("/WEB-INF/views/parts/all_parts.jsp").forward(request, response);
       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String action = request.getParameter("action");
        System.out.println(action);
        switch (action) {
            case "addSale":
            	System.out.println("oi");
                addSale(request, response);
                break;
            
            default:
                break;
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        switch (action) {
            case "updateSale":
                updateSale(request, response);
                break;
            
            default:
                break;
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        switch (action) {
            case "deleteSale":
                deleteSale(request, response);
                break;
           
            default:
                break;
        }
    }

    private void addSale(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
    	
    	String idParam = request.getParameter("id");
        String valueParam = request.getParameter("value");
        String quantityParam = request.getParameter("quantity");
        
        System.out.println(idParam);
        System.out.println(valueParam);
        System.out.println(quantityParam);
        
        
        if (idParam == null || valueParam == null || quantityParam == null) {
            response.sendRedirect("error.jsp");
            return;
        }
        
        System.out.println("oi");
        
        try {
        	Long id = Long.parseLong(request.getParameter("id"));
            Double value = Double.parseDouble(request.getParameter("value"));
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            
        	Sale sale = new Sale();
            sale.setId(id);
            sale.setValue(value);
            
            value = quantity * value;

            saleDAO.addSale(sale);
            System.out.println(sale);
            
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            
            if (user!= null) {
            	Long userId = user.getId();
            	String userName = user.getName();
                String userEmail = user.getEmail();
                String userCpf = user.getCpf();
                
                
                Customer newCustomer = new Customer();
                newCustomer.setId(userId);
                newCustomer.setName(userName);
                newCustomer.setEmail(userEmail);
                newCustomer.setCpf(userCpf);
                
                CustomerDAO customerDAO = new CustomerDAO();
                customerDAO.addPart(newCustomer);
                
            }


            httpResponse.sendRedirect(httpRequest.getContextPath() + "/SaleServlet");
        }catch (NumberFormatException e) {
        	response.sendRedirect("error.jsp");
        }

        
    }

    private void updateSale(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Double value = Double.parseDouble(request.getParameter("value"));

        Sale updatedSale = new Sale();
        updatedSale.setValue(value);

        saleDAO.updateSale(id, updatedSale);

        response.sendRedirect("index.jsp"); 
    }

    private void deleteSale(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        saleDAO.deleteSale(id);
        response.sendRedirect("index.jsp"); 
    }
}
