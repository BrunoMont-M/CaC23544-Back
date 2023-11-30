package ar.com.codoacodo.repository;

import java.util.List;

import ar.com.codoacodo.entities.Oradores;

public interface OradorRepository {
	public void save(Oradores orador);
	public Oradores getById(Long id);
	public void update(Oradores orador);
	public void delete(Long id);
	public List<Oradores> findAll();
	
}
