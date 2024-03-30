package com.AutoWeb.servlets;

import com.AutoWeb.dao.PartDAO;
import com.AutoWeb.entities.Part;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/AllPartsServlet")
public class AllPartsServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PartDAO partDAO;

    public void init() {
        this.partDAO = new PartDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deletePart(request, response);
                break;
            case "search":
                searchParts(request, response);
                break;
            default:
                listParts(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("insert".equals(action)) {
            insertPart(request, response);
        } else if ("update".equals(action)) {
            updatePart(request, response);
        }
    }

    private void listParts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Part> parts = partDAO.getAllParts();
        request.setAttribute("parts", parts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/parts/all_parts.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Part existingPart = partDAO.getPartById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/parts/edit_parts.jsp");
        request.setAttribute("part", existingPart);
        dispatcher.forward(request, response);
    }

    private void insertPart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String description = request.getParameter("description");
        Double value = Double.parseDouble(request.getParameter("value"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));

        Part newPart = new Part(description, value, quantity);
        partDAO.addPart(newPart);
        response.sendRedirect("AllPartsServlet");
    }

    private void updatePart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String description = request.getParameter("description");
        Double value = Double.parseDouble(request.getParameter("value"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));

        Part part = new Part(id, description, value, quantity);
        partDAO.updatePart(part);
        response.sendRedirect("AllPartsServlet");
    }

    private void deletePart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        partDAO.deletePart(id);
        response.sendRedirect("AllPartsServlet");
    }

    private void searchParts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String query = request.getParameter("searchQuery");
        List<Part> parts = partDAO.searchPartsByName(query);
        request.setAttribute("parts", parts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/parts/all_parts.jsp");
        dispatcher.forward(request, response);
    }
}
