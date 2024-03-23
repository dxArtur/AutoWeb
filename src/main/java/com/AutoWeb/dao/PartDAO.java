package com.AutoWeb.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.AutoWeb.database.ConnectionFactory;
import com.AutoWeb.entities.Part;



public class PartDAO {

	private Connection connection;

	public PartDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void addPart(Part part) {
		String sql = "INSERT INTO parts (id, name,  description, value, quantity) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, part.getId());
			stmt.setString(2, part.getName());
			stmt.setString(3, part.getDescription());
			stmt.setDouble(4, part.getValue());
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
	
	
}
