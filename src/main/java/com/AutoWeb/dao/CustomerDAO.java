package com.AutoWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.AutoWeb.database.ConnectionFactory;
import com.AutoWeb.entities.Customer;

public class CustomerDAO {
	
	private Connection connection;

	public CustomerDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO customers (name, email, cpf) VALUES (?, ?, ?)";
		try  (Connection conn = new ConnectionFactory().getConnection();
		         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getEmail());
			stmt.setString(3, customer.getCpf());
		
		int rowsInserted = stmt.executeUpdate(); 
		if (rowsInserted > 0) {
            System.out.println("Cliente adicionado com sucesso.");
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                	customer.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Falha ao adicionar cliente, nenhum ID obtido.");
                }
            }
        } else {
        	System.out.println("Falha ao adicionar cliente.");
        }
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Customer getCustomer(String cpf) {
	    String sql = "SELECT * FROM customers WHERE cpf = ?";
	    try (Connection conn = this.connection;
	        PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, cpf);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	        	Customer customer = new Customer();
	        	customer.setId(rs.getLong("id"));
	        	customer.setName(rs.getString("name"));
	        	customer.setEmail(rs.getString("email"));
	        	customer.setCpf(rs.getString("cpf"));
	            return customer;
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao buscar cliente", e);
	    }
	    return null;
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



