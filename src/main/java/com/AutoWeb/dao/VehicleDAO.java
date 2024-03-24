package com.AutoWeb.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

import com.AutoWeb.database.ConnectionFactory;
import com.AutoWeb.entities.Vehicle;

public class VehicleDAO {
	private Connection connection;
	
	public VehicleDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void addPart(Vehicle vehicle) {
		String sql = "INSERT INTO vehicles (plate, model, manufactureYear) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, vehicle.getPlate());
			stmt.setString(2, vehicle.getModel());
			stmt.setInt(3, vehicle.getManufactureYear());
		
		int rowsInserted = stmt.executeUpdate(); 
        if (rowsInserted > 0) {
            System.out.println("Veiculo adicionado com sucesso.");
        } else {
            System.out.println("Falha ao adicionar veiculo.");
        }
		
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}
}
