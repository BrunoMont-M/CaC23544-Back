package com.codoacodo.tpfinal.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdminConexiones {
	
	public static Connection getConnection() {
		String username = "root";
		String password = "CaC#23544";
		String port = "3306";
		String host = "localhost";
		String dbName = "tp_final";
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		
		String dbUrl = "jdbc:mysql://"+host+":"+port+"/"+dbName + "?allowPublicKeyRetrieval=true&serverTimeZone=UTC&useSSL=false";
		
		try {
			Class.forName(driverName);
			return DriverManager.getConnection(dbUrl, username, password);
		} catch(Exception e) {
			throw new IllegalArgumentException("No se pudo conectar a la db: " + dbUrl);
		}
		
		
	}
	
}