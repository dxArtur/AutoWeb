package com.AutoWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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
}
