package com.codoacodo.tpfinal.controllers;

public class CompradorRequest {
	private String nombre;
	private String apellido;
	private String email;
	private int cantidad;
	private String categoria;
	private float total_precio;
	
	public CompradorRequest() {
		
	}
	public CompradorRequest(String nombre, String apellido, String email, int cantidad, String categoria) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.cantidad = cantidad;
		this.categoria = categoria;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public float getTotal_precio() {
		return total_precio;
	}
	
	public void setTotal_precio(float total_precio) {
		this.total_precio = total_precio;
	}
}