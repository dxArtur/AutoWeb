package com.AutoWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.AutoWeb.database.ConnectionFactory;
import com.AutoWeb.entities.Customer;

public class CustomerDAO {
	
	private Connection connection;

	public CustomerDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void addPart(Customer costumer) {
		String sql = "INSERT INTO customers (id, name,  description, value, quantity) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, costumer.getId());
			stmt.setString(2, costumer.getName());
			stmt.setString(3, costumer.getEmail());
			stmt.setString(4, costumer.getCpf());
		
		int rowsInserted = stmt.executeUpdate(); 
        if (rowsInserted > 0) {
            System.out.println("Cliente adicionado com sucesso.");
        } else {
            System.out.println("Falha ao adicionar cliente.");
        }
		
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}
	
}



