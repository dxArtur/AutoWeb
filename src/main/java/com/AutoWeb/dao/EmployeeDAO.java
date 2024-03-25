package com.AutoWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.AutoWeb.database.ConnectionFactory;
import com.AutoWeb.entities.Employee;

public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name, email, cpf, position, salary) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getEmail());
            stmt.setString(3, employee.getCpf());
            stmt.setString(4, employee.getPosition());
            stmt.setDouble(5, employee.getSalary());
            
            stmt.execute();
            System.out.println("Funcionário adicionado com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar funcionário: " + e.getMessage(), e);
        }
    }

    public List<Employee> listAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("cpf"),
                        rs.getString("position"),
                        rs.getDouble("salary"));          
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar funcionários: " + e.getMessage(), e);
        }
        return employees;
    }

    public Employee getEmployeeById(long id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("cpf"),
                            rs.getString("position"),
                            rs.getDouble("salary"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar funcionário: " + e.getMessage(), e);
        }
        return null;
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET name = ?, email = ?, cpf = ?, position = ?, salary = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getEmail());
            stmt.setString(3, employee.getCpf());
            stmt.setString(4, employee.getPosition());
            stmt.setDouble(5, employee.getSalary());
            stmt.setLong(6, employee.getId());
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Funcionário atualizado com sucesso.");
            } else {
                System.out.println("Nenhum funcionário encontrado com este ID.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar funcionário: " + e.getMessage(), e);
        }
    }

    public void deleteEmployee(long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = this.connection;
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Funcionário deletado com sucesso.");
            } else {
                System.out.println("Nenhum funcionário encontrado com o ID: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar funcionário: " + e.getMessage(), e);
        }
    }
}
