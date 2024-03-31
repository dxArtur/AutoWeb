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



public class PartDAO {

	private Connection connection;

	public PartDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void addPart(Part part) {
		String sql = "INSERT INTO parts (description, value, quantity) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, part.getDescription());
			stmt.setDouble(2, part.getValue());
			stmt.setInt(3, part.getQuantity());
		
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
				Part part = new Part(id, sql, null, null);
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
	public Part getPartById(Long id) {
        Part part = null;
        String sql = "SELECT * FROM parts WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                part = new Part(
                    rs.getLong("id"),
                    rs.getString("description"),
                    rs.getDouble("value"),
                    rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar a peça pelo ID: " + e.getMessage(), e);
        }
        return part;
    }
	
	public void updatePart(Part part) {
        String sql = "UPDATE parts SET description = ?, value = ?, quantity = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, part.getDescription());
            stmt.setDouble(2, part.getValue());
            stmt.setInt(3, part.getQuantity());
            stmt.setLong(4, part.getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Peça atualizada com sucesso.");
            } else {
                System.out.println("Falha ao atualizar peça. Nenhuma peça encontrada com o ID: " + part.getId());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar peça: " + e.getMessage(), e);
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
				Part part = new Part(null, sql, null, null);
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
				Part part = new Part(null, null, null);
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

	public List<Part> searchPartsByName(String searchQuery) {
		// TODO Auto-generated method stub
		return null;
	}
}
