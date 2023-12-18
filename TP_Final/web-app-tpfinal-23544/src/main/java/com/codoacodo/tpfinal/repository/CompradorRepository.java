package com.codoacodo.tpfinal.repository;

import java.util.List;

import com.codoacodo.tpfinal.entities.Compradores;

public interface CompradorRepository {
	public void save(Compradores comprador);
	public Compradores getById(Long id_comprador);
	public void update(Compradores comprador);
	public void delete(Long id_comprador);
	public List<Compradores> findAll();
}