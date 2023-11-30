package ar.com.codoacodo.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdminConexiones  {

//	Tiene un método estático, un método que se puede usar sin crear una instancia de la clase
//	AdminConexiones.metodo();
	
	public static Connection getConnection() {
		String username = "root";
		String password = "CaC#23544";
		String port = "3306";
		String host = "localhost";
		String dbName = "integrador_cac";
//		String dbName = "prueba_integrador";
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		
		String dbUrl = "jdbc:mysql://"+host+":"+port+"/"+dbName + "?allowPublicKeyRetrieval=true&serverTimeZone=UTC&useSSL=false";
		
//		No vemos try/catch pero lo usaremos
		
		try {
			Class.forName(driverName);
			return DriverManager.getConnection(dbUrl, username, password);
		} catch(Exception e) {
			throw new IllegalArgumentException("No se pudo conectar a la db: " + dbUrl);
		}
		
		
	}
	
}
