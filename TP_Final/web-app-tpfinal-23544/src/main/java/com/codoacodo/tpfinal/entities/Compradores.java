package com.codoacodo.tpfinal.entities;

public class Compradores {

	private Long id_comprador;
	private String nombre;
	private String apellido;
	private String email;
	private int cantidad;
	private String categoria;
	private float total_precio;
	
	public Compradores(Long id_comprador, String nombre, String apellido, String email, int cantidad, String categoria, float total_precio) {
		this.id_comprador = id_comprador;
		init(nombre, apellido, email, cantidad, categoria, total_precio);
		
	}

	public Compradores(String nombre, String apellido, String email, int cantidad, String categoria, float total_precio) {
		init(nombre, apellido, email, cantidad, categoria, total_precio);
		
	}

	public void init(String nombre, String apellido, String email, int cantidad, String categoria, float total_precio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.cantidad = cantidad;
		this.categoria = categoria;
		this.total_precio = total_precio;
		
	}

	@Override
	public String toString() {
		return "Compradores [id_comprador=" + id_comprador + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", email=" + email + ", cantidad=" + cantidad + ", categoria=" + categoria + ", total_precio="
				+ total_precio + "]";
	}

	public Long getId_comprador() {
		return id_comprador;
	}

	public void setId_comprador(Long id_comprador) {
		this.id_comprador = id_comprador;
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