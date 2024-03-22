package com.AutoWeb.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SchemaSetup {
	public void createTables(Connection connection) {
		try {
		Statement statement = connection.createStatement();
		String createUserTable = "CREATE TABLE IF NOT EXISTS users (\r\n"
				+ "    id SERIAL PRIMARY KEY,"
				+ "    name VARCHAR(255) NOT NULL,"
				+ "    email VARCHAR(255) NOT NULL,"
				+ "    password VARCHAR(255) NOT NULL,"
				+ "    cpf VARCHAR(14) NOT NULL UNIQUE"
				+ ")";
        statement.execute(createUserTable);
        System.out.println("Tabela users criada com sucesso.");

        // Criar tabela clientes
        String createCostumerTable = "CREATE TABLE IF NOT EXISTS customers ("
                + "id SERIAL PRIMARY KEY,"
                + "name VARCHAR(255) NOT NULL,"
                + "email VARCHAR(255) NOT NULL UNIQUE,"
                + "cpf VARCHAR(14) NOT NULL UNIQUE"
                + ")";
        statement.execute(createCostumerTable);
        System.out.println("Tabela clientes criada com sucesso.");

        // Criar tabela peças
        String createPartsTable = "CREATE TABLE IF NOT EXISTS parts ("
                + "id SERIAL PRIMARY KEY,"
                + "description VARCHAR(255) NOT NULL,"
                + "value DECIMAL(10, 2) NOT NULL,"
                + "quantity INT NOT NULL"
                + ")";
        statement.execute(createPartsTable);
        System.out.println("Tabela peças criada com sucesso.");

        
        //Criar tabela veículos
        String createVehiclesTable = "CREATE TABLE IF NOT EXISTS vehicles ("
                + "plate VARCHAR(20) PRIMARY KEY,"
                + "model VARCHAR(255) NOT NULL,"
                + "manufacture_year INT NOT NULL"
                + ")";
        statement.execute(createVehiclesTable);
        System.out.println("Tabela veiculos criada com sucesso.");
        
        
      //Criar tabela vendas
        String createSalesTable = "CREATE TABLE IF NOT EXISTS sales ("
                + "id SERIAL PRIMARY KEY,"
                + "value DECIMAL(10, 2) NOT NULL"
                + ")";
        statement.execute(createSalesTable);
        System.out.println("Tabela vendas criada com sucesso.");
        
        //Criar tabela ordem de serviço
        String createServiceOrderTable = "CREATE TABLE IF NOT EXISTS service_order ("
                + "id SERIAL PRIMARY KEY ,"
                + "description VARCHAR(255) NOT NULL,"
                + "value NUMERIC(10,2) NOT NULL"
                + ")";
        statement.execute(createServiceOrderTable);
        System.out.println("Tabela ordem de serviço criada com sucesso.");
        
        
      //Criar tabela funcionarios
        String createEmployeeTable = "CREATE TABLE IF NOT EXISTS employees ("
                + "id SERIAL PRIMARY KEY,"
                + "name VARCHAR(255) NOT NULL,"
                + "email VARCHAR(255) NOT NULL UNIQUE,"
                + "cpf VARCHAR(14) NOT NULL UNIQUE,"
                + "position VARCHAR(255) NOT NULL,"
                + "salary numeric(10,2) NOT NULL"
                + ")";
        statement.execute(createEmployeeTable);
        System.out.println("Tabela funcionarios criada com sucesso.");
        
        // ordem de serviço ed clientes
        
        String createServiceOrderCostumerTable = "CREATE TABLE IF NOT EXISTS service_order_customer ("
                + "order_id BIGINT NOT NULL,"
                + "customer_id BIGINT NOT NULL,"
                + "PRIMARY KEY (order_id, customer_id),"
                + "FOREIGN KEY (order_id) REFERENCES service_order(id),"
                + "FOREIGN KEY (customer_id) REFERENCES customers(id)"
                + ")";
        statement.execute(createServiceOrderCostumerTable);
        System.out.println("Tabela de ordem de servico de clientes criada com sucesso.");
        
        //ordem de serviço de veiculos
        
        String createServiceOrderVehicleTable = "CREATE TABLE IF NOT EXISTS service_order_vehicle ("
                + "order_id BIGINT NOT NULL,"
                + "vehicle_plate VARCHAR(20) NOT NULL,"
                + "PRIMARY KEY (order_id, vehicle_plate),"
                + "FOREIGN KEY (order_id) REFERENCES service_order(id),"
                + "FOREIGN KEY (vehicle_plate) REFERENCES vehicles(plate)"
                + ")";
        statement.execute(createServiceOrderVehicleTable);
        System.out.println("Tabela de ordem de servico de veiculos criada com sucesso.");
        
        //itens vendidos
        
        String createSaleItemTable = "CREATE TABLE IF NOT EXISTS sale_items ("
                + "sale_id BIGINT PRIMARY KEY,"
                + "part_id BIGINT NOT NULL,"
                + "quantity INT NOT NULL,"
                + "FOREIGN KEY (sale_id) REFERENCES sales(id),"
                + "FOREIGN KEY (part_id) REFERENCES parts(id)"
                + ")";
        statement.execute(createSaleItemTable);
        System.out.println("Tabela de itens vendidos criada com sucesso.");
        
        

    } catch (SQLException e) {
        System.out.println("Erro ao criar tabelas: " + e.getMessage());
    }
	}
}
