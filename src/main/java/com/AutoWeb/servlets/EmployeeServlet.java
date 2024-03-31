package com.AutoWeb.servlets;

import com.AutoWeb.dao.EmployeeDAO;

import com.AutoWeb.entities.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;

    public EmployeeServlet() {
        super();
        this.employeeDAO = new EmployeeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("edit".equals(action)) {
            long id = Long.parseLong(request.getParameter("id"));
            Employee employee = employeeDAO.getEmployeeById(id);
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("/WEB-INF/views/employees/edit_employee.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
        	HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            long id = Long.parseLong(request.getParameter("id"));
            employeeDAO.deleteEmployeeById(id);
            List<Employee> employees = employeeDAO.getAllEmployees();
            request.setAttribute("employees", employees);
            //request.getRequestDispatcher("/WEB-INF/views/employees/list_employees.jsp").forward(request, response);
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/EmployeeServlet");
        }else if ("search".equals(action)) {
        	String query = request.getParameter("searchQuery");
            List<Employee> employees = employeeDAO.searchEmployeesByName(query);
            request.setAttribute("employees", employees);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employees/list_employees.jsp");
            dispatcher.forward(request, response);
        } else {
        	try {
                List<Employee> employees = employeeDAO.getAllEmployees();
                request.setAttribute("employees", employees);
                request.getRequestDispatcher("/WEB-INF/views/employees/list_employees.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("update".equals(action)) {
        	HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            long id = Long.parseLong(request.getParameter("id"));
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
            
            employeeDAO.updateEmployee(employee);
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/EmployeeServlet");
        } else {
        	HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String cpf = request.getParameter("cpf");
            String position = request.getParameter("position");
            Double salary = Double.parseDouble(request.getParameter("salary"));
            
            Employee newEmployee = new Employee();
            newEmployee.setName(name);
            newEmployee.setEmail(email);
            newEmployee.setCpf(cpf);
            newEmployee.setPosition(position);
            newEmployee.setSalary(salary);
            
            employeeDAO.AddEmployee(newEmployee);
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/EmployeeServlet");   
        }
    }
}
