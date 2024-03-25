package com.AutoWeb.servlets;

import com.AutoWeb.dao.EmployeeDAO;
import com.AutoWeb.entities.Employee;
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
            request.getRequestDispatcher("/page/employees/edit_employee").forward(request, response);
        } else if ("delete".equals(action)) {
            long id = Long.parseLong(request.getParameter("id"));
            employeeDAO.deleteEmployee(id);
            response.sendRedirect(request.getContextPath() + "/page/employees/list_employees");
        } else {
            List<Employee> employees = employeeDAO.listAllEmployees();
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("/page/employees/list_employees").forward(request, response);
        
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("update".equals(action)) {
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
            response.sendRedirect(request.getContextPath() + "/page/employees/list_employees");
        } else {
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
            
            employeeDAO.addEmployee(newEmployee);
            response.sendRedirect(request.getContextPath() + "/page/employees/list_employees");
        }
    }
}
