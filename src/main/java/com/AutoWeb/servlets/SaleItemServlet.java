package com.AutoWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutoWeb.dao.SaleItemDAO;
import com.AutoWeb.entities.SaleItem;

@WebServlet("/SaleItemServlet")
public class SaleItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SaleItemDAO saleItemDAO;

    public SaleItemServlet() {
        super();
        saleItemDAO = new SaleItemDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                addSaleItem(request, response);
                break;
            default:
                response.getWriter().println("Invalid action.");
                break;
        }
    }

    private void addSaleItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SaleItem saleItem = new SaleItem();
        saleItem.setSaleId(Long.parseLong(request.getParameter("saleId")));
        saleItem.setPartId(Long.parseLong(request.getParameter("partId")));
        saleItem.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        saleItemDAO.addSaleItem(saleItem);
        response.sendRedirect("pecas.jsp"); // Redireciona de volta para a página de peças após a adição
    }
}
