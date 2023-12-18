package com.codoacodo.tpfinal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.codoacodo.tpfinal.entities.Compradores;

public class MySqlCompradorRepository implements CompradorRepository {

	@Override
	public void save(Compradores comprador) {
		
		String sql = "INSERT INTO compradores (nombre, apellido, email, cantidad, categoria, total_precio) VALUES (?, ?, ?, ?, ?, ?)";
		try(Connection con = AdminConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, comprador.getNombre());
			statement.setString(2, comprador.getApellido());
			statement.setString(3, comprador.getEmail());
			statement.setInt(4, comprador.getCantidad());
			statement.setString(5, comprador.getCategoria());
			statement.setFloat(6, comprador.getTotal_precio());
			
			
			statement.executeUpdate();
			
			ResultSet res = statement.getGeneratedKeys();
			if(res.next()) {
				Long id_comprador = res.getLong(1);
			}
		} catch(Exception e) {
			throw new IllegalArgumentException("No se pudo crear al comprador: ", e);
		}
	}	


	@Override
	public Compradores getById(Long id_comprador) {

		String sql = "SELECT id_comprador, nombre, apellido, email, cantidad, categoria, total_precio FROM compradores WHERE id_comprador = ?";
		
		Compradores comprador = null;
		try(Connection con = AdminConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setLong(1, id_comprador);
			
			ResultSet res = statement.executeQuery();
			
			if(res.next()) {
				Long dbId_comprador = res.getLong(1);
				String Nombre = res.getString(2);
				String Apellido = res.getString(3);
				String Email = res.getString(4);
				int Cantidad = res.getInt(5);
				String Categoria = res.getString(6);
				float Total_precio = res.getFloat(7);
				
				comprador = new Compradores(dbId_comprador, Nombre, Apellido, Email, Cantidad, Categoria, Total_precio);
			}
		} catch(Exception e) {
			throw new IllegalArgumentException("No se pudo traer al comprador: ", e);
		}
		return comprador;
	}

	@Override
	public void update(Compradores comprador) {
		
		String sql = "UPDATE compradores"
				+ "set nombre = ?, apellido = ?, email = ?, cantidad = ?, categoria = ?, total_precio = ?"
				+ "WHERE id_comprador = ?";
		
		try(Connection con = AdminConexiones.getConnection()) {
			
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, comprador.getNombre());
			statement.setString(2, comprador.getApellido());
			statement.setString(3, comprador.getEmail());
			statement.setInt(4, comprador.getCantidad());
			statement.setString(5, comprador.getCategoria());
			statement.setFloat(6, comprador.getTotal_precio());
			
			statement.executeUpdate();
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo actualizar al comprador:", e);
		}
		
	}

	@Override
	public void delete(Long id_comprador) {
		
		String sql = "DELETE FROM compradores WHERE id_comprador = ?";
		
		try(Connection con = AdminConexiones.getConnection()) {
			
			PreparedStatement statement = con.prepareStatement(sql);
			
//			statement.setLong(1, id_comprador);
			
			statement.executeUpdate();
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo eliminar al comprador:", e);
		}
		
	}

	@Override
	public List<Compradores> findAll() {
		
		String sql = "SELECT id_comprador, nombre, apellido, email, cantidad, categoria, total_precio FROM compradores";
		
		List<Compradores> compradores = new ArrayList<>();
		
		try(Connection con = AdminConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);
			
			ResultSet res = statement.executeQuery();
			
			while (res.next()) {
				Long dbId_comprador = res.getLong(1);
				String Nombre = res.getString(2);
				String Apellido = res.getString(3);
				String Email = res.getString(4);
				int Cantidad = res.getInt(5);
				String Categoria = res.getString(6);
				float Total_precio = res.getFloat(7);
				
				Compradores comprador = new Compradores(dbId_comprador, Nombre, Apellido, Email, Cantidad, Categoria, Total_precio);
				compradores.add(comprador);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("No se pudo crear al comprador:", e);
		}
		return compradores;
	}
}