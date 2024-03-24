package com.AutoWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.AutoWeb.database.ConnectionFactory;
import com.AutoWeb.entities.Part;
import com.AutoWeb.entities.ServiceOrder;



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
	
	public Optional<Part> getPart(Long id) {
		String sql = "SELECT * FROM parts WHERE id =?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()) {
				Part part = new Part();
				part.setId(resultSet.getLong("id"));
				part.setDescription(resultSet.getString("id"));
				part.setValue(resultSet.getDouble("value"));
				part.setQuantity(resultSet.getInt("quantity"));
				return Optional.of(part);
			}
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return Optional.empty();
	}
	
	public void updatePart(Long id, Part updatedPart) {
		String sql = "UPDATE parts SET description = ? value = ? WHERE id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, updatedPart.getDescription());
			stmt.setDouble(2, updatedPart.getValue());
			stmt.setLong(3, id);
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted == 0) {
				throw new RuntimeException("Nenhuma peça encontrada sob o id");
			}
		}catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public void deletePart(Long id) {
		String sql = "DELETE FROM parts WHERE id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			int rowsDeleted = stmt.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Peça deletada com sucesso.");
	            } else {
	                System.out.println("Falha ao deletar peça. Nenhuma ordem de serviço foi deletada");
	            }
		}catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public List<Part> getPartByDescription(String description) {
		List<Part> parts = new ArrayList<>();
		String sql = "SELECT * FROM parts WHERE description = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, description);
			ResultSet resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				Part part = new Part();
				part.setId(resultSet.getLong("id"));
				part.setDescription(resultSet.getString("description"));
				part.setValue(resultSet.getDouble("value"));
				part.setQuantity(resultSet.getInt("quantity"));
				parts.add(part);
			}
			
		} catch(SQLException e) {
            throw new RuntimeException("Erro ao buscar peça: " + e.getMessage());
		}
		return parts;
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
