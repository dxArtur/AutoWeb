package com.AutoWeb.servlets;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AutoWeb.dao.PartDAO;
import com.AutoWeb.dao.ServiceOrderDAO;
import com.AutoWeb.entities.Part;
import com.AutoWeb.entities.ServiceOrder;

/**
 * Servlet implementation class PartServlet
 */
@WebServlet("/PartServlet")
public class PartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String partIdString = request.getParameter("partId");
		long partId = Long.parseLong(partIdString);

		PartDAO partDAO = new PartDAO();
			
		Optional<Part> part = partDAO.getPart(partId);
		
		if (part.isPresent()) {
			request.setAttribute("part", part);
			request.getRequestDispatcher("/WEB-INF/views/parts/list_parts.jsp").forward(request, response);
		} else {
			response.sendRedirect("erro.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description");
		Double value = Double.parseDouble(request.getParameter("value"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Part newPart = new Part();
		newPart.setDescription(description);
		newPart.setValue(value);
		newPart.setQuantity(quantity);
		
		PartDAO partDAO = new PartDAO();
		
		partDAO.addPart(newPart);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String partIdString = request.getParameter("partId");
		Long partId = Long.parseLong(partIdString);
		String description = request.getParameter("description");
		Double value = Double.parseDouble(request.getParameter("value"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		
		
		Part updatedPart = new Part();
		updatedPart.setDescription(description);
		updatedPart.setValue(value);
		updatedPart.setQuantity(quantity);
		
		PartDAO partDAO = new PartDAO();
		
		partDAO.updatePart(partId, updatedPart);
		request.setAttribute("updatedPart", updatedPart);
		request.getRequestDispatcher("/order_service_details.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String partIdString = request.getParameter("partId");
		Long partId = Long.parseLong(partIdString);
		
		PartDAO partDAO = new PartDAO();
		partDAO.deletePart(partId);
	}

}
