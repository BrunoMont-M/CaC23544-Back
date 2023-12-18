package com.codoacodo.tpfinal.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.codoacodo.tpfinal.entities.Oradores;
import com.codoacodo.tpfinal.utils.DateUtils;

public class MySqlOradorRepository implements OradorRepository {

	@Override
	public void save(Oradores orador) {
		
		String sql = "INSERT INTO oradores (nombre, apellido, email, tema, detalles_tema, fecha_alta) VALUES (?, ?, ?, ?, ?, ?)";
		try(Connection con = AdminConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, orador.getNombre());
			statement.setString(2, orador.getApellido());
			statement.setString(3, orador.getEmail());
			statement.setString(4, orador.getTema());
			statement.setString(5, orador.getDetalles_tema());
			statement.setDate(6, new java.sql.Date(DateUtils.asDate(orador.getFechaAlta()).getTime()));
			
			statement.executeUpdate();
			
			ResultSet res = statement.getGeneratedKeys();
			if(res.next()) {
				Long id_orador = res.getLong(1);
				
			}
		} catch(Exception e) {
			throw new IllegalArgumentException("No se pudo crear el orador: ", e);
		}
	}

	@Override
	public Oradores getById(Long id_orador) {

		String sql = "SELECT id_orador, nombre, apellido, email, tema, detalles_tema, fecha_alta FROM oradores WHERE id_orador = ?";
		
		Oradores orador = null;
		try(Connection con = AdminConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setLong(1, id_orador);
			
			ResultSet res = statement.executeQuery();
			
			if(res.next()) {
				Long dbId_orador = res.getLong(1);
				String Nombre = res.getString(2);
				String Apellido = res.getString(3);
				String Email = res.getString(4);
				String Tema = res.getString(5);
				String Detalles_tema = res.getString(6);
				LocalDate fechaAlta = DateUtils.asLocalDate(res.getDate(7));
				
				orador = new Oradores(dbId_orador, Nombre, Apellido, Email, Tema, Detalles_tema, fechaAlta);
			}
		} catch(Exception e) {
			throw new IllegalArgumentException("No se pudo traer al orador: ", e);
		}
		return orador;
	}

	@Override
	public void update(Oradores orador) {
		
		String sql = "UPDATE oradores "
				+ "set nombre = ?, apellido = ?, email = ?, tema = ?, detalles_tema = ? "
				+ "WHERE id_orador = ?";

		try(Connection con = AdminConexiones.getConnection()) {
			
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, orador.getNombre());
			statement.setString(2, orador.getApellido());
			statement.setString(3, orador.getEmail());
			statement.setString(4, orador.getTema());
			statement.setString(5, orador.getDetalles_tema());
			statement.setLong(6, orador.getId_orador());
			
			statement.executeUpdate();
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo actualizar el orador:", e);
		}
	}

	@Override
	public void delete(Long id_orador) {
		
		String sql = "DELETE FROM oradores WHERE id_orador = ?";
		
		try(Connection con = AdminConexiones.getConnection()) {
			
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setLong(1, id_orador);
			
			statement.executeUpdate();
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo eliminar al orador:", e);
		}
	}

	@Override
	public List<Oradores> findAll() {
		
		String sql = "SELECT id_orador, nombre, apellido, email, tema, detalles_tema, fecha_alta FROM oradores";
		
		List<Oradores> oradores = new ArrayList<>();
		
		try(Connection con = AdminConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);
			
			ResultSet res = statement.executeQuery();
			
			while (res.next()) {
				Long dbId_orador = res.getLong(1);
				String Nombre = res.getString(2);
				String Apellido = res.getString(3);
				String Email = res.getString(4);
				String Tema = res.getString(5);
				String Detalles_tema = res.getString(6);
				LocalDate fechaAlta = DateUtils.asLocalDate(res.getDate(7));
				
				Oradores orador = new Oradores(dbId_orador, Nombre, Apellido, Email, Tema, Detalles_tema, fechaAlta);
				oradores.add(orador);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("No se pudo crear el orador:", e);
		}
		
		return oradores;
	}
}
