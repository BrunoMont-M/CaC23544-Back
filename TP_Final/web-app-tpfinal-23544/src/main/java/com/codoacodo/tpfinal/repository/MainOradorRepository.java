package com.codoacodo.tpfinal.repository;

import java.util.List;

import com.codoacodo.tpfinal.entities.Oradores;

public class MainOradorRepository {

	public static void main(String[] args) {
		
//		Interface i = new ClaseQueImplementa();
		OradorRepository repository = new MySqlOradorRepository();
		
//		repository.save(new Oradores(null, "Juan", "Perez", "jperez@example.com", "NodeJs", LocalDate.now()));
		
		List<Oradores> listado = repository.findAll();
		System.out.println(listado);	
	}
}