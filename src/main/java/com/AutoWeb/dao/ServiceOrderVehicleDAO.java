package com.AutoWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.AutoWeb.database.ConnectionFactory;
import com.AutoWeb.entities.ServiceOrderVehicle;

public class ServiceOrderVehicleDAO {
private Connection connection;
	
	public ServiceOrderVehicleDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void addServiceOrderVehicle(ServiceOrderVehicle serviceOrderVehicle) {
		String sql = "INSERT INTO service_order_vehicle (order_id, vehicle_plate) VALUES (?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, serviceOrderVehicle.getOrderId());
			stmt.setString(2, serviceOrderVehicle.getPlateVehicle());
			int rowsInserted = stmt.executeUpdate(); 
	        if (rowsInserted > 0) {
	        	System.out.println("Ordem de serviço de veículo adicionada com sucesso.");
	        } else {
	            System.out.println("Falha ao adicionar Ordem de serviço de veículo.");
	        }
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	
	}
}
