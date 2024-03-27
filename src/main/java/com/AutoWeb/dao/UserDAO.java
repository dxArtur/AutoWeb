package com.AutoWeb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.AutoWeb.database.ConnectionFactory;
import com.AutoWeb.entities.User;



public class UserDAO {

	private Connection connection;

	public UserDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void addUser(User user) {
		String sql = "INSERT INTO users (cpf, name, email, password) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getCpf());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			
			int rowsInserted = stmt.executeUpdate(); 
	        if (rowsInserted > 0) {
	            System.out.println("Usuario adicionado com sucesso.");
	        } else {
	            System.out.println("Falha ao adicionar usuario.");
	        }
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Optional<User> getUserByCpf(String cpf) {
		String sql = "SELECT * FROM users WHERE cpf =?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cpf);
			try (ResultSet resultSet = stmt.executeQuery()) {
				if (resultSet.next()) {
					User user = new User();
					user.setId(resultSet.getLong("id"));
					user.setName(resultSet.getString("name"));
					user.setEmail(resultSet.getString("email"));
					user.setCpf(resultSet.getString("cpf"));
					user.setPassword(resultSet.getString("password"));
					return Optional.of(user);
				}
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return Optional.empty();
	}
	
	public  Optional<User> attemphAuth(String email) {
		String sql = "select * from users where email = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, email);
			try (ResultSet resultSet = stmt.executeQuery()) {
				if (resultSet.next()) {
					User userAttemphAuth = new User();
					userAttemphAuth.setId(resultSet.getLong("id"));
					userAttemphAuth.setName(resultSet.getString("name"));
					userAttemphAuth.setPassword(resultSet.getString("password"));
					return Optional.of(userAttemphAuth);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return Optional.empty();
	}
}

