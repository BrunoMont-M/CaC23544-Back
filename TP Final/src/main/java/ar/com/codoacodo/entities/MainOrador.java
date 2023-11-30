package ar.com.codoacodo.entities;

import java.time.LocalDate;

public class MainOrador {

	public static void main(String[] args) {
		
		Oradores nuevoOrador = new Oradores(null, "Carlos", "Lopez", "c.lopez@example.com", "JAVA", LocalDate.now());
		
		System.out.println(nuevoOrador);
	}

}
