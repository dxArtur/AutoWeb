package com.AutoWeb;

import java.sql.Connection;
import com.AutoWeb.database.*;


public class Main {
public static void main(String[] args) {
		
		Connection connection = new ConnectionFactory().getConnection();
		
		SchemaSetup init = new SchemaSetup();
		init.createTables(connection);
}
}
