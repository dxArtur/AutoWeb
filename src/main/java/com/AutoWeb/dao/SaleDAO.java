package com.AutoWeb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.AutoWeb.database.ConnectionFactory;
import com.AutoWeb.entities.Sale;

public class SaleDAO {
	private Connection connection;
	
	public SaleDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void addSale(Sale sale) {
		String sql = "INSERT INTO sales (id, value) VALUES (?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, sale.getId());
			stmt.setDouble(2, sale.getValue());
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Sale getSale(Long id) {
		Sale sale = null;
		String sql = "SELECT * FROM sales WHERE id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			try (ResultSet resultSet = stmt.executeQuery()) {
				if (resultSet.next()) {
					sale = new Sale();
					sale.setId(resultSet.getLong("id"));
					sale.setValue(resultSet.getDouble("value"));
					return sale;
				}
			}
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		return sale;
	}
	
	public void updateSale(Long id, Sale updatedSale) {
		String sql = "UPDATE sales SET value = ? WHERE id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, updatedSale.getValue());
			stmt.setLong(2, id);
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted == 0) {
				throw new RuntimeException("Nenhuma venda encontrada sob o id");
			}
		}catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
}
