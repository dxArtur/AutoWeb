package com.AutoWeb.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.List;

import com.AutoWeb.database.ConnectionFactory;
import com.AutoWeb.entities.Part;



public class PartDAO {

	private Connection connection;

	public PartDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void addPart(Part part) {
		String sql = "INSERT INTO parts (id,  description, value, quantity) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, part.getId());
			stmt.setString(2, part.getDescription());
			stmt.setDouble(3, part.getValue());
			stmt.setInt(4, part.getQuantity());
		
			int rowsInserted = stmt.executeUpdate(); 
	        if (rowsInserted > 0) {
	            System.out.println("Peca adicionado com sucesso.");
	        } else {
	            System.out.println("Falha ao adicionar peca.");
	        }
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Part> getAllParts() {
		List<Part> parts = new ArrayList<>();
		
		String sql = "SELECT * FROM parts";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				 Part part = new Part();
	                part.setId(resultSet.getLong("id"));
	                part.setDescription(resultSet.getString("description"));
	                part.setValue(resultSet.getDouble("value"));
	                part.setQuantity(resultSet.getInt("quantity"));
	                parts.add(part);
			}

		}catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todas as peças: " + e.getMessage());
	}
	
		return parts;
	}
}
