package com.AutoWeb.servlets;

import com.AutoWeb.dao.VehicleDAO;
import com.AutoWeb.entities.Vehicle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/VehicleServlet")
public class VehicleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VehicleDAO vehicleDAO;

    public VehicleServlet() {
        super();
        this.vehicleDAO = new VehicleDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if (action == null) {
            action = "listAllVehicles";
        }

        switch (action) {
            case "listAllVehicles":
                listAllVehicles(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteVehicle(request, response);
                break;
            default:
                response.sendRedirect("list_vehicles.jsp");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if ("addVehicle".equals(action)) {
            addVehicle(request, response);
        } else if ("updateVehicle".equals(action)) {
            updateVehicle(request, response);
        }
    }

    private void listAllVehicles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        request.setAttribute("vehicles", vehicles);
        request.getRequestDispatcher("/WEB-INF/views/vehicles/list_vehicles.jsp").forward(request, response);
    }

    private void addVehicle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String plate = request.getParameter("plate");
        String model = request.getParameter("model");
        int manufactureYear = Integer.parseInt(request.getParameter("manufactureYear"));

        Vehicle newVehicle = new Vehicle(plate, model, manufactureYear);
        vehicleDAO.addVehicle(newVehicle);
        response.sendRedirect("VehicleServlet"); 
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String plate = request.getParameter("plate");
        Optional<Vehicle> optionalVehicle = vehicleDAO.getVehicleByPlate(plate);
        if (optionalVehicle.isPresent()) {
            Vehicle existingVehicle = optionalVehicle.get();
            request.setAttribute("vehicle", existingVehicle);
            request.getRequestDispatcher("/WEB-INF/views/vehicles/edit_vehicle.jsp").forward(request, response);
        } else {
            response.sendRedirect("list_vehicles.jsp");
        }
    }

    private void updateVehicle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String plate = request.getParameter("plate");
        String model = request.getParameter("model");
        int manufactureYear = Integer.parseInt(request.getParameter("manufactureYear"));

        Vehicle vehicle = new Vehicle(plate, model, manufactureYear);
        vehicleDAO.updateVehicle(vehicle);
        response.sendRedirect("VehicleServlet"); 
    }

    private void deleteVehicle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String plate = request.getParameter("plate");
        vehicleDAO.deleteVehicleByPlate(plate);
        response.sendRedirect("VehicleServlet"); 
    }
}
