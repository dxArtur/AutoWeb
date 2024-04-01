package com.AutoWeb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutoWeb.entities.ServiceOrder;
import com.AutoWeb.dao.ServiceOrderDAO;

/**
 * Servlet implementation class ServiceOrderServlet
 */
@WebServlet("/ServiceOrderServlet")
public class ServiceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServiceOrderDAO serviceOrderDAO = new ServiceOrderDAO();
		List<ServiceOrder> servicesOrders = serviceOrderDAO.getAllServiceOrder();
		
		for (ServiceOrder order : servicesOrders) {
	        System.out.println(order.getDescription()); 
	    }
	
		
			request.setAttribute("servicesOrder", servicesOrders);
			request.getRequestDispatcher("/WEB-INF/views/serviceOrders/all_service_orders.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description");
		Double value = Double.parseDouble(request.getParameter("value"));
		
		ServiceOrder serviceOrder = new ServiceOrder();
		serviceOrder.setDescription(description);
		serviceOrder.setValue(value);
		
		ServiceOrderDAO serviceOrderDAO = new ServiceOrderDAO();
		serviceOrderDAO.addServiceOrder(serviceOrder);
		response.sendRedirect("order_service_details.jsp");

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serviceOrderIdString = request.getParameter("serviceOrderId");
		Long serviceOrderId = Long.parseLong(serviceOrderIdString);
		String description = request.getParameter("description");
		Double value = Double.parseDouble(request.getParameter("value"));
		
		ServiceOrder serviceOrderUpdated = new ServiceOrder();
		serviceOrderUpdated.setDescription(description);
		serviceOrderUpdated.setValue(value);
		
		ServiceOrderDAO serviceOrderDAO = new ServiceOrderDAO();
		
		serviceOrderDAO.updateServiceOrder(serviceOrderId, serviceOrderUpdated);
		request.setAttribute("serviceOrder", serviceOrderUpdated);
		request.getRequestDispatcher("/order_service_details.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serviceOrderIdString = request.getParameter("serviceOrderId");
		Long serviceOrderId = Long.parseLong(serviceOrderIdString);
		
		ServiceOrderDAO serviceOrderDAO = new ServiceOrderDAO();
		
		serviceOrderDAO.deleteServiceOrder(serviceOrderId);
	}

}
