package ar.com.codoacodo.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.entities.Oradores;
import ar.com.codoacodo.utils.DateUtils;

public class MySqlOradorRepository implements OradorRepository {

	@Override
	public void save(Oradores orador) {
//		Paso a paso
//		1. Obtengo la conexión
		
//		2. Preparo SQL: SQL injection!
		String sql = "INSERT INTO oradores (nombre, apellido, email, tema, fecha_alta) VALUES (?, ?, ?, ?, ?)";
		try(Connection con = AdminConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, orador.getNombre());
			statement.setString(2, orador.getApellido());
			statement.setString(3, orador.getEmail());
			statement.setString(4, orador.getTema());
			statement.setDate(5, new java.sql.Date(DateUtils.asDate(orador.getFechaAlta()).getTime()));
			
			statement.executeUpdate();
			
			ResultSet res = statement.getGeneratedKeys();
			if(res.next()) {
				Long id = res.getLong(1); // Acá está el id
				
			}
		} catch(Exception e) {
			throw new IllegalArgumentException("No se pudo crear el orador: ", e);
		}
		
				
	}

	@Override
	public Oradores getById(Long id) {
//		Paso a paso
//		1. Obtengo la conexión
		
//		2. Preparo SQL: SQL injection!
		String sql = "SELECT id, nombre, apellido, email, tema, fecha_alta FROM oradores WHERE id = ?";
		
		Oradores orador = null;
		try(Connection con = AdminConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setLong(1, id);
			
			ResultSet res = statement.executeQuery();
			
			if(res.next()) {
				Long dbId = res.getLong(1);
				String Nombre = res.getString(2);
				String Apellido = res.getString(3);
				String Email = res.getString(4);
				String Tema = res.getString(5);
				LocalDate fechaAlta = DateUtils.asLocalDate(res.getDate(6));
				
				orador = new Oradores(dbId, Nombre, Apellido, Email, Tema, fechaAlta);
				
			}
		} catch(Exception e) {
			throw new IllegalArgumentException("No se pudo traer al orador: ", e);
		}
		return orador;
	}

	@Override
	public void update(Oradores orador) {
		
		String sql = "UPDATE oradores"
				+ "set nombre=?, apellido=?, email=?, tema=?"
				+ "WHERE id=?";
		
		try(Connection con = AdminConexiones.getConnection()) {
			
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, orador.getNombre());
			statement.setString(2, orador.getApellido());
			statement.setString(3, orador.getEmail());
			statement.setString(4, orador.getTema());
			statement.setLong(5, orador.getId());
			
			statement.executeUpdate();
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo actualizar el orador:", e);
		}
		
	}

	@Override
	public void delete(Long id) {
		
		String sql = "DELETE FROM oradores WHERE id = ?";
		
		try(Connection con = AdminConexiones.getConnection()) {
			
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setLong(1, id);
			
			statement.executeUpdate();
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo eliminar el orador:", e);
		}
		
	}

	@Override
	public List<Oradores> findAll() {
		
		String sql = "SELECT id, nombre, apellido, email, tema, fecha_alta FROM oradores";
		
		List<Oradores> oradores = new ArrayList<>();
		
		try(Connection con = AdminConexiones.getConnection()) {
			PreparedStatement statement = con.prepareStatement(sql);
			
			ResultSet res = statement.executeQuery();
			
			while (res.next()) {
				Long dbId = res.getLong(1);
				String Nombre = res.getString(2);
				String Apellido = res.getString(3);
				String Email = res.getString(4);
				String Tema = res.getString(5);
				LocalDate fechaAlta = DateUtils.asLocalDate(res.getDate(6));
				
				Oradores orador = new Oradores(dbId, Nombre, Apellido, Email, Tema, fechaAlta);
				oradores.add(orador);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("No se pudo crear el orador:", e);
		}
		
		return oradores;
	}

}
