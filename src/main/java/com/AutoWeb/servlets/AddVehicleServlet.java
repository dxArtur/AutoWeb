package com.AutoWeb.servlets;

import com.AutoWeb.dao.VehicleDAO;
import com.AutoWeb.entities.Vehicle;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AddVehicleServlet")
public class AddVehicleServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VehicleDAO vehicleDAO;

    public AddVehicleServlet() {
        this.vehicleDAO = new VehicleDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/vehicles/add_vehicle.jsp").forward(request, response);
    }
}
