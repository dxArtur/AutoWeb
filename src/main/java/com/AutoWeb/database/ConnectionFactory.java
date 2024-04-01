package com.AutoWeb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String URL = "jdbc:postgresql://localhost:5432/dac@autoweb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

	
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Conectando ao banco de dados");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver do PostgreSQL não encontrado no classpath", e);
        }
    }

}
