package com.AutoWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

import com.AutoWeb.dao.VehicleDAO;
import com.AutoWeb.entities.Vehicle;

@WebServlet("/VehicleServlet")
public class VehicleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VehicleDAO vehicleDAO;

    public VehicleServlet() {
        super();
        vehicleDAO = new VehicleDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "getAllVehicles":
                getAllVehicles(request, response);
                break;
            
            default:
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "addVehicle":
                addVehicle(request, response);
                break;
            
            default:
                break;
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String action = request.getParameter("action");
        switch (action) {
            case "updateVehicle":
                updateVehicle(request, response);
                break;
            
            default:
                break;
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        switch (action) {
            case "deleteVehicle":
                deleteVehicle(request, response);
                break;
           
            default:
                break;
        }
    }

    private void addVehicle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String plate = request.getParameter("plate");
        String model = request.getParameter("model");
        int manufactureYear = Integer.parseInt(request.getParameter("manufactureYear"));

        Vehicle vehicle = new Vehicle();
        vehicle.setPlate(plate);
        vehicle.setModel(model);
        vehicle.setManufactureYear(manufactureYear);

        vehicleDAO.addPart(vehicle);

        response.sendRedirect("index.jsp"); 
    }

    private void getAllVehicles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        
    }

    private void updateVehicle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String plate = request.getParameter("plate");
        String model = request.getParameter("model");
        int manufactureYear = Integer.parseInt(request.getParameter("manufactureYear"));

        Vehicle updatedVehicle = new Vehicle();
        updatedVehicle.setModel(model);
        updatedVehicle.setManufactureYear(manufactureYear);

        vehicleDAO.updateVehicleByPlate(plate, updatedVehicle);

        response.sendRedirect("index.jsp"); 
    }

    private void deleteVehicle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String plate = request.getParameter("plate");
        vehicleDAO.deleteVehicleByPlate(plate);
        response.sendRedirect("index.jsp");
    }
}
