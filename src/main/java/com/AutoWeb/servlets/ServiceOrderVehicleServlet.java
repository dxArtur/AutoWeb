package com.AutoWeb.servlets;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AutoWeb.dao.CustomerDAO;
import com.AutoWeb.dao.SaleDAO;
import com.AutoWeb.dao.ServiceOrderVehicleDAO;
import com.AutoWeb.dao.VehicleDAO;
import com.AutoWeb.entities.Customer;
import com.AutoWeb.entities.Sale;
import com.AutoWeb.entities.ServiceOrderVehicle;
import com.AutoWeb.entities.User;
import com.AutoWeb.entities.Vehicle;

/**
 * Servlet implementation class ServiceOrderVehicleServlet
 */
@WebServlet("/ServiceOrderVehicleServlet")
public class ServiceOrderVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceOrderVehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        switch (action) {
            case "addServiceOrderVehicle":
            	addServiceOrderVehicle(request, response);
                break;
            
            default:
                break;
        }
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	private void addServiceOrderVehicle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        String idParam = request.getParameter("id");
        String descriptionParam = request.getParameter("description");
        String valueParam = request.getParameter("value");
        String plateParam = request.getParameter("plate");
        String yearParam = request.getParameter("manufactureYear");
        String modelParam = request.getParameter("model");
        System.out.println(idParam);
        System.out.println(descriptionParam);
        System.out.println(valueParam);
        System.out.println(plateParam);
        System.out.println(yearParam);
        System.out.println(modelParam);
        
        if (idParam == null || descriptionParam == null || valueParam == null || plateParam == null || yearParam == null ||modelParam == null) {
            System.out.println("esse ero");
        	response.sendRedirect("error.jsp");
            return;
        }
        
        try {
        	System.out.println("eero");
        	Long id = Long.parseLong(request.getParameter("id"));
        	Double value = Double.parseDouble(request.getParameter("value"));
        	
        	Integer year = Integer.parseInt(request.getParameter("manufactureYear"));
        	
        	
        	
        	HttpSession session = request.getSession();
        	User user = (User) session.getAttribute("user");
        	
        	String verifyCpf =user.getCpf();
        	
            
            CustomerDAO customerDAO = new CustomerDAO();
            Customer customer = customerDAO.getCustomer(verifyCpf);
            
            VehicleDAO vehicleDAO = new VehicleDAO();
            Optional<Vehicle> verifyVehicle = vehicleDAO.getVehicleByPlate(plateParam);
            
            if (verifyVehicle.isEmpty()) {
            	Vehicle vehicle = new Vehicle(plateParam, modelParam, year);
                vehicleDAO.addVehicle(vehicle);
            }
            
            
            if (customer == null) {
            	Long userId = user.getId();
            	String userName = user.getName();
                String userEmail = user.getEmail();
                String userCpf = user.getCpf();
                
            	Customer newCustomer = new Customer();
                newCustomer.setId(userId);
                newCustomer.setName(userName);
                newCustomer.setEmail(userEmail);
                newCustomer.setCpf(userCpf);
            	customerDAO.addCustomer(newCustomer);
            }
            
            ServiceOrderVehicleDAO serviceOrderVehicleDAO = new ServiceOrderVehicleDAO();
            
            ServiceOrderVehicle serviceOrderVehicle = new ServiceOrderVehicle();
            serviceOrderVehicle.setOrderId(id);
            serviceOrderVehicle.setPlateVehicle(plateParam);
            
            serviceOrderVehicleDAO.addServiceOrderVehicle(serviceOrderVehicle);
            
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/ServiceOrderServlet");
        }catch (NumberFormatException e) {
        	System.out.println("oiiiiiii");
        	response.sendRedirect("error.jsp");
        }
	}

}
