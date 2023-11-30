package ar.com.codoacodo.entities;

import java.time.LocalDate;

public class Oradores {
	// Atributos
	private Long id_orador;
	private String nombre;
	private String apellido;
	private String email;
	private String tema;
	private LocalDate fechaAlta;
	
	// Constructores
	// Polimorfismo: la capacidad que tienen las clases de relacionar de maneras diferentes el mismo mensaje
	public Oradores(Long id, String nombre, String apellido, String email, String tema, LocalDate fechaAlta) {
		this.id_orador = id;
		init(nombre, apellido, email, tema, fechaAlta);
	}
	
	public void init(String nombre, String apellido, String email, String tema, LocalDate fechaAlta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.tema = tema;
		this.fechaAlta = fechaAlta;
	}
	
	//otra forma de polimorfismo: SOBREESCRITURA, un metodo que existe en una clase base (java.lang.Object) 
	// pero su hijo (Orador) la cambia
	public String toString() {
		return "Orador [id=" + id_orador + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", tema=" + tema + ", fechaAlta=" + fechaAlta + "]";
	}	
		
	//cambiar un metodo llamado toString() de la clase Object para ver mas lindo en la consola los atributos
	//del objeto
	//alt+shit+s

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre != null) {
			this.nombre = nombre;
		} else {
			this.nombre = "N/D";
		}
		
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		if(apellido != null) {
			this.apellido = apellido;
		} else {
			this.apellido = "N/D";
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email != null) {
			this.email = email;
		} else {
			this.email = "N/D";
		}
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		if(tema != null) {
			this.tema = tema;
		} else {
			this.tema = "N/D";
		}
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public Long getId() {
		return id_orador;
	}
/*
	public void setId(Long id) { // En este caso no sería correcto que el id sea modificado desde acá sino desde la BD
		this.id = id;
	}
*/
	
}

