package com.AutoWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.AutoWeb.database.ConnectionFactory;
import com.AutoWeb.entities.Vehicle;

public class VehicleDAO {

    private Connection connection;

    public VehicleDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (plate, model, manufacture_year) VALUES (?, ?, ?)";
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getPlate());
            stmt.setString(2, vehicle.getModel());
            stmt.setInt(3, vehicle.getManufactureYear());
            
            int rowsInserted = stmt.executeUpdate(); 
            if (rowsInserted > 0) {
                System.out.println("Veículo adicionado com sucesso.");
            } else {
                System.out.println("Falha ao adicionar veículo.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar veículo: " + e.getMessage(), e);
        }
    }
    public Optional<Vehicle> getVehicleByPlate(String plate) {
        String sql = "SELECT * FROM vehicles WHERE plate = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, plate);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    Vehicle vehicle = new Vehicle(sql, sql, null);
                    vehicle.setPlate(resultSet.getString("plate"));
                    vehicle.setModel(resultSet.getString("model"));
                    vehicle.setManufactureYear(resultSet.getInt("manufacture_year"));
                    return Optional.of(vehicle);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter veículo: " + e.getMessage(), e);
        }
        return Optional.empty();
    }

    public void updateVehicleByPlate(String plate, Vehicle updatedVehicle) {
        String sql = "UPDATE vehicles SET model = ?, manufacture_year = ? WHERE plate = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, updatedVehicle.getModel());
            stmt.setInt(2, updatedVehicle.getManufactureYear());
            stmt.setString(3, plate);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Veículo atualizado com sucesso.");
            } else {
                System.out.println("Falha ao atualizar veículo. Nenhum veículo encontrado com a placa especificada.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar veículo: " + e.getMessage(), e);
        }
    }

    public void deleteVehicleByPlate(String plate) {
        String sql = "DELETE FROM vehicles WHERE plate = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, plate);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Veículo deletado com sucesso.");
            } else {
                System.out.println("Falha ao deletar veículo. Nenhum veículo encontrado com a placa especificada.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar veículo: " + e.getMessage(), e);
        }
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";
        	try (Connection conn = new ConnectionFactory().getConnection();
      	         PreparedStatement stmt = conn.prepareStatement(sql);
      	        		ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle(sql, sql, null);
                vehicle.setPlate(resultSet.getString("plate"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setManufactureYear(resultSet.getInt("manufacture_year"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar veículos: " + e.getMessage(), e);
        }
        return vehicles;
    }
    public void updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE vehicles SET model = ?, manufacture_year = ? WHERE plate = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getModel());
            stmt.setInt(2, vehicle.getManufactureYear());
            stmt.setString(3, vehicle.getPlate());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Veículo atualizado com sucesso.");
            } else {
                System.out.println("Falha ao atualizar veículo. Nenhum veículo encontrado com a placa especificada.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar veículo: " + e.getMessage(), e);
        }
    }
}
