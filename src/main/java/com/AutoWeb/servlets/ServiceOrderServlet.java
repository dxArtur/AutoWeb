package com.AutoWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutoWeb.dao.ServiceOrderDAO;
import com.AutoWeb.entities.ServiceOrder;

@WebServlet("/SalvarServicoServlet")
public class ServiceOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String descricao = request.getParameter("descricao");
        double valor = Double.parseDouble(request.getParameter("valor"));
        
      
        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setDescription(descricao);
        serviceOrder.setValue(valor);
        
        
        ServiceOrderDAO serviceOrderDAO = new ServiceOrderDAO();
        serviceOrderDAO.addServiceOrder(serviceOrder);
        
        
        response.sendRedirect("sucesso.jsp");
    }
}
