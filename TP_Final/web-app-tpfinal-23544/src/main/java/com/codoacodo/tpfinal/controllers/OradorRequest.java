package com.codoacodo.tpfinal.controllers;

public class OradorRequest {
	private String nombre;
	private String apellido;
	private String email;
	private String tema;
	private String detalles_tema;
	
	public OradorRequest() {
		
	}
	public OradorRequest(String nombre, String apellido, String email, String tema, String detalles_tema) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.tema = tema;
		this.detalles_tema = detalles_tema;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public String getTema() {
		return tema;
	}
	public String getDetalles_tema() {
		return detalles_tema;	
	}
	
}