package com.AutoWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AutoWeb.database.ConnectionFactory;
import com.AutoWeb.entities.Employee;

public class EmployeeDAO {
	private Connection connection;

	public EmployeeDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void addPart(Employee employee) {
		String sql = "INSERT INTO employees (id, name, email, cpf, position, salario) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, employee.getId());
			stmt.setString(2, employee.getName());
			stmt.setString(3, employee.getEmail());
			stmt.setString(4, employee.getCpf());
			stmt.setString(5, employee.getPosition());
			stmt.setDouble(6, employee.getSalary());
		
		int rowsInserted = stmt.executeUpdate(); 
        if (rowsInserted > 0) {
            System.out.println("Funcionario adicionado com sucesso.");
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
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);
	        stmt.setLong(1, id);
	        int rowsDeleted = stmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("Funcionário deletado com sucesso.");
	        } else {
	            System.out.println("Falha ao deletar funcionário. Nenhum funcionário encontrado com o ID especificado.");
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao deletar veículo: " + e.getMessage());
	    }
	}
	
	public List<Employee> getAllEmployees() {
	    List<Employee> employees = new ArrayList<>();
	    String sql = "SELECT * FROM employees";

	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);
	        ResultSet resultSet = stmt.executeQuery();

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
	        throw new RuntimeException("Erro ao listar funcionários: " + e.getMessage());
	    }

	    return employees;
	}


}
