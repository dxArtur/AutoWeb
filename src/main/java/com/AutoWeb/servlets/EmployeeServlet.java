package com.AutoWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import com.AutoWeb.dao.EmployeeDAO;
import com.AutoWeb.entities.Employee;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;

    public EmployeeServlet() {
        super();
        employeeDAO = new EmployeeDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        switch (action) {
            case "addEmployee":
                addEmployee(request, response);
                break;
          
            default:
                break;
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        switch (action) {
            case "updateEmployee":
                updateEmployee(request, response);
                break;
            
            default:
                break;
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        switch (action) {
            case "deleteEmployee":
                deleteEmployee(request, response);
                break;
            
            default:
                break;
        }
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String position = request.getParameter("position");
        Double salary = Double.parseDouble(request.getParameter("salary"));

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setCpf(cpf);
        employee.setPosition(position);
        employee.setSalary(salary);

        employeeDAO.addPart(employee);

        response.sendRedirect("index.jsp"); 
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String position = request.getParameter("position");
        Double salary = Double.parseDouble(request.getParameter("salary"));

        Employee updatedEmployee = new Employee();
        updatedEmployee.setName(name);
        updatedEmployee.setEmail(email);
        updatedEmployee.setCpf(cpf);
        updatedEmployee.setPosition(position);
        updatedEmployee.setSalary(salary);

        employeeDAO.updateEmployeeById(id, updatedEmployee);

        response.sendRedirect("index.jsp"); 
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        employeeDAO.deleteEmployeeById(id);
        response.sendRedirect("index.jsp"); 
    }
}
