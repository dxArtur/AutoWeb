package com.AutoWeb.servlets;

import com.AutoWeb.dao.PartDAO;
import com.AutoWeb.entities.Part;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/PartServlet")
public class PartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PartDAO partDAO;

    public PartServlet() {
        super();
        this.partDAO = new PartDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("delete")) {
            deletePart(request, response);
        } else {
            listParts(request, response);
        }
    }

    private void listParts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Part> parts = partDAO.getAllParts();
        request.setAttribute("parts", parts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/parts/list_parts.jsp");
        dispatcher.forward(request, response);
    }

    private void deletePart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            try {
                Long id = Long.valueOf(idStr);
                partDAO.deletePart(id);
                response.sendRedirect(request.getContextPath() + "/PartServlet");
            } catch (NumberFormatException e) {
                response.sendRedirect(request.getContextPath() + "/PartServlet?error=true");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para adicionar uma nova peça
        String description = request.getParameter("description");
        Double value = Double.valueOf(request.getParameter("value"));
        Integer quantity = Integer.valueOf(request.getParameter("quantity"));

        Part part = new Part();
        part.setDescription(description);
        part.setValue(value);
        part.setQuantity(quantity);

        partDAO.addPart(part);
        
        // Redireciona para a lista de peças após adicionar uma nova
        response.sendRedirect(request.getContextPath() + "/page/parts/list_parts");
    }
}

