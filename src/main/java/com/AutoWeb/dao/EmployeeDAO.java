package com.AutoWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.AutoWeb.database.ConnectionFactory;
import com.AutoWeb.entities.Employee;

public class EmployeeDAO {
	private Connection connection;

	public EmployeeDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void AddEmployee(Employee employee) {
	    String sql = "INSERT INTO employees (name, email, cpf, position, salary) VALUES (?, ?, ?, ?, ?)";
	    try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        stmt.setString(1, employee.getName());
	        stmt.setString(2, employee.getEmail());
	        stmt.setString(3, employee.getCpf());
	        stmt.setString(4, employee.getPosition());
	        stmt.setDouble(5, employee.getSalary());
	    
	        int rowsInserted = stmt.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("Funcionario adicionado com sucesso.");
	            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    employee.setId(generatedKeys.getLong(1));
	                } else {
	                    throw new SQLException("Falha ao adicionar funcionario, nenhum ID obtido.");
	                }
	            }
	        } else {
	            System.out.println("Falha ao adicionar funcionario.");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	
	public void updateEmployeeById(long id, Employee updatedEmployee) {
	    String sql = "UPDATE employees SET name = ?, email = ?, cpf = ?, position = ?, salary = ? WHERE id = ?";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);
	        stmt.setString(1, updatedEmployee.getName());
	        stmt.setString(2, updatedEmployee.getEmail());
	        stmt.setString(3, updatedEmployee.getCpf());
	        stmt.setString(4, updatedEmployee.getPosition());
	        stmt.setDouble(5, updatedEmployee.getSalary());
	        stmt.setLong(6, id);

	        int rowsUpdated = stmt.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Funcionário atualizado com sucesso.");
	        } else {
	            System.out.println("Falha ao atualizar funcionário. Nenhum funcionário encontrado com o ID especificado.");
	        }

	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao atualizar funcionário: " + e.getMessage());
	    }
	}
	
	public void deleteEmployeeById(Long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            
            int rowsDeleted = stmt.executeUpdate();
            
            if (rowsDeleted > 0) {
                System.out.println("Funcionário deletado com sucesso.");
            } else {
                System.out.println("Falha ao deletar funcionário. Nenhum funcionário encontrado com o ID especificado: " + id);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar funcionário: " + e.getMessage(), e);
        }
    }
	public List<Employee> getAllEmployees() {
	    List<Employee> employees = new ArrayList<>();
	    String sql = "SELECT * FROM employees";
	    try (Connection conn = new ConnectionFactory().getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet resultSet = stmt.executeQuery()) {
	        while (resultSet.next()) {
	        	Employee employee = new Employee();
	            employee.setId(resultSet.getLong("id"));
	            employee.setName(resultSet.getString("name"));
	            employee.setEmail(resultSet.getString("email"));
	            employee.setCpf(resultSet.getString("cpf"));
	            employee.setPosition(resultSet.getString("position"));
	            employee.setSalary(resultSet.getDouble("salary"));
	            employees.add(employee);
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao listar funcionários: " + e.getMessage(), e);
	    }
	    return employees;
	}

	public Employee getEmployeeById(long id) {
	    String sql = "SELECT * FROM employees WHERE id = ?";
	    try (Connection conn = this.connection;
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setLong(1, id);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            Employee employee = new Employee();
	            employee.setId(rs.getLong("id"));
	            employee.setName(rs.getString("name"));
	            employee.setEmail(rs.getString("email"));
	            employee.setCpf(rs.getString("cpf"));
	            employee.setPosition(rs.getString("position"));
	            employee.setSalary(rs.getDouble("salary"));
	            return employee;
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao buscar funcionário pelo ID: " + id, e);
	    }
	    return null;
	}

	public void updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET name = ?, email = ?, cpf = ?, position = ?, salary = ? WHERE id = ?";
        
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getEmail());
            stmt.setString(3, employee.getCpf());
            stmt.setString(4, employee.getPosition());
            stmt.setDouble(5, employee.getSalary());
            stmt.setLong(6, employee.getId());
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Funcionário atualizado com sucesso.");
            } else {
                System.out.println("Falha ao atualizar o funcionário. Nenhum funcionário encontrado com o ID: " + employee.getId());
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o funcionário: " + e.getMessage(), e);
        }
    }



}
