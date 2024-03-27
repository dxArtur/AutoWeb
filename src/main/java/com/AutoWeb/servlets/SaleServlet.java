package com.AutoWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutoWeb.dao.SaleDAO;
import com.AutoWeb.entities.Sale;

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
       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        switch (action) {
            case "addSale":
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
        Long id = Long.parseLong(request.getParameter("id"));
        Double value = Double.parseDouble(request.getParameter("value"));

        Sale sale = new Sale();
        sale.setId(id);
        sale.setValue(value);

        saleDAO.addSale(sale);

        response.sendRedirect("index.jsp"); 
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
