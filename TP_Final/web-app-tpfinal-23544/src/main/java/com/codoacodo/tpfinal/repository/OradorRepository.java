package com.codoacodo.tpfinal.repository;

import java.util.List;

import com.codoacodo.tpfinal.entities.Oradores;

public interface OradorRepository {
	public void save(Oradores orador);
	public Oradores getById(Long id_orador);
	public void update(Oradores orador);
	public void delete(Long id_orador);
	public List<Oradores> findAll();
}