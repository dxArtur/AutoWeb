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


public class ServiceOrderDAO {
	private Connection connection;
	
	public ServiceOrderDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void addServiceOrder(ServiceOrder serviceOrder) {
		String sql = "INSERT INTO service_order (id, value) VALUES (?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, serviceOrder.getId());
			stmt.setDouble(2, serviceOrder.getValue());
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Optional<ServiceOrder> getServiceOrder(Long id) {
		ServiceOrder serviceOrder = null;
		String sql = "select * from service_order where email = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			try (ResultSet resultSet = stmt.executeQuery()){
				if (resultSet.next()) {
					serviceOrder = new ServiceOrder();
					serviceOrder.setId(resultSet.getLong("id"));
					serviceOrder.setDescription(resultSet.getString("description"));
					serviceOrder.setValue(resultSet.getDouble("value"));
					return Optional.of(serviceOrder);
				}
			}
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return Optional.empty();
	}
	
	
	public void updateServiceOrder(Long id, ServiceOrder updatedServiceOrder) {
		String sql = "UPDATE service_order SET description = ? value = ? WHERE id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, updatedServiceOrder.getDescription());
			stmt.setDouble(2, updatedServiceOrder.getValue());
			stmt.setLong(3, id);
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted == 0) {
				throw new RuntimeException("Nenhuma ordem de servico encontrada sob o id");
			}
		}catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public List<ServiceOrder> getAllServiceOrderCostumer(Long id) {
		List<ServiceOrder> servicesOrder = new ArrayList<>();
		
		String sql = "SELECT * FROM service_order_costumer WHERE customer_id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				ServiceOrder serviceOrder = new ServiceOrder();
				serviceOrder.setId(resultSet.getLong("id"));
				serviceOrder.setDescription(resultSet.getString("description"));
				
				servicesOrder.add(serviceOrder);
			}

		}catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todas as ordens de serviço de um usuario: " + e.getMessage());
	}
	
		return servicesOrder;
	}
}
