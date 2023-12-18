package com.codoacodo.tpfinal.repository;

import java.util.List;

import com.codoacodo.tpfinal.entities.Compradores;

public class MainCompradorRepository {

	public static void main(String[] args) {
		
//		Interface i = new ClaseQueImplementa();
		CompradorRepository repository = new MySqlCompradorRepository();
		
//		repository.save(new Comprador(null, "Juan", "Perez", "jperez@example.com", null, null, null);
		
		List<Compradores> listado = repository.findAll();
		System.out.println(listado);
	}
}