package com.AutoWeb.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

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
	public Optional<User> attemphAuth(String email) {
	    String sql = "SELECT * FROM users WHERE email = ?";
	    try (Connection connection = this.connection;
	         PreparedStatement stmt = connection.prepareStatement(sql)) {

	        stmt.setString(1, email);
	        ResultSet resultSet = stmt.executeQuery();

	        if (resultSet.next()) {
	            User user = new User();
	            user.setId(resultSet.getLong("id"));
	            user.setName(resultSet.getString("name"));
	            user.setEmail(resultSet.getString("email"));
	            user.setPassword(resultSet.getString("password"));
	            user.setCpf(resultSet.getString("cpf"));
	            user.setIsAdmin(resultSet.getBoolean("isadmin"));
	           
	            return Optional.of(user);
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	    return Optional.empty();
	}

	
	public List<User> listAllUsers() {
	    List<User> users = new ArrayList<>();
	    String sql = "SELECT * FROM users";
	    try (PreparedStatement stmt = connection.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {
	        while (rs.next()) {
	            User user = new User();
	            user.setId(rs.getLong("id"));
	            user.setName(rs.getString("name"));
	            user.setEmail(rs.getString("email"));
	            user.setCpf(rs.getString("cpf"));
	            user.setPassword(rs.getString("password"));
	            users.add(user);
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao listar usuários: " + e.getMessage(), e);
	    }
	    return users;
	}
	
	public void updateUser(User user) {
	    String sql = "UPDATE users SET name = ?, email = ?, cpf = ?, password = ? WHERE id = ?";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, user.getName());
	        stmt.setString(2, user.getEmail());
	        stmt.setString(3, user.getCpf());
	        stmt.setString(4, user.getPassword());
	        stmt.setLong(5, user.getId());
	        
	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Usuário atualizado com sucesso.");
	        } else {
	            System.out.println("Falha ao atualizar usuário. Nenhum usuário encontrado com o ID: " + user.getId());
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao atualizar usuário: " + e.getMessage(), e);
	    }
	}
	
	public boolean isUserExists(String cpf, String email) {
	    boolean userExists = false;
	    String sql = "SELECT COUNT(*) FROM users WHERE cpf = ? OR email = ?";
	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	         
	        statement.setString(1, cpf);
	        statement.setString(2, email);
	        ResultSet resultSet = statement.executeQuery();
	        
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            userExists = count > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return userExists;
	}

}

