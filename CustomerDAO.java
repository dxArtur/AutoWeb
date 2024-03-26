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
	
	public void updateCustomerById(long id, Customer updatedCustomer) {
	    String sql = "UPDATE customers SET name = ?, email = ?, cpf = ? WHERE id = ?";
	    try {
	        PreparedStatement stmt = connection.prepareStatement(sql);
	        stmt.setString(1, updatedCustomer.getName());
	        stmt.setString(2, updatedCustomer.getEmail());
	        stmt.setString(3, updatedCustomer.getCpf());
	        stmt.setLong(4, id);

	        int rowsUpdated = stmt.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Cliente atualizado com sucesso.");
	        } else {
	            System.out.println("Falha ao atualizar cliente. Nenhum cliente encontrado com o ID especificado.");
	        }

	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage());
	    }
	}
	
	public void deleteCustomerById(Long id) {
	    String sql = "DELETE FROM customers WHERE id = ?";
	    try {
	    	PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			int rowsDeleted = stmt.executeUpdate();
			if (rowsDeleted > 0) {
                System.out.println("Cliente deletado com sucesso.");
            } else {
                System.out.println("Falha ao deletar cliente. Nenhuma ordem de serviço foi deletada");
            }
	    }catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

}



