package com.AutoWeb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutoWeb.dao.SaleItemDAO;
import com.AutoWeb.entities.SaleItem;
import com.google.gson.Gson;

@WebServlet("/SaleItemServlet")
public class SaleItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SaleItemDAO saleItemDAO;

    public SaleItemServlet() {
        super();
        saleItemDAO = new SaleItemDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "list":
                listSaleItems(request, response);
                break;
            default:
                response.getWriter().println("Invalid action.");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                addSaleItem(request, response);
                break;
            case "update":
                updateSaleItem(request, response);
                break;
            default:
                response.getWriter().println("Invalid action.");
                break;
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        updateSaleItem(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long saleId = Long.parseLong(request.getParameter("saleId"));
        long partId = Long.parseLong(request.getParameter("partId"));
        saleItemDAO.deleteSaleItem(saleId, partId);
        response.getWriter().println("Sale item deleted successfully.");
    }

    private void addSaleItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SaleItem saleItem = new SaleItem();
        saleItem.setSaleId(Long.parseLong(request.getParameter("saleId")));
        saleItem.setPartId(Long.parseLong(request.getParameter("partId")));
        saleItem.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        saleItemDAO.addSaleItem(saleItem);
        response.getWriter().println("Sale item added successfully.");
    }

    private void updateSaleItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SaleItem saleItem = new SaleItem();
        saleItem.setSaleId(Long.parseLong(request.getParameter("saleId")));
        saleItem.setPartId(Long.parseLong(request.getParameter("partId")));
        saleItem.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        saleItemDAO.updateSaleItem(saleItem);
        response.getWriter().println("Sale item updated successfully.");
    }

    private void listSaleItems(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<SaleItem> saleItems = saleItemDAO.getAllSaleItems();
        Gson gson = new Gson();
        String json = gson.toJson(saleItems);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
