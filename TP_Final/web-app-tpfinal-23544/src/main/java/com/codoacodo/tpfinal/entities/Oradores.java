package com.codoacodo.tpfinal.entities;

import java.time.LocalDate;

public class Oradores {

		private Long id_orador;
		private String nombre;
		private String apellido;
		private String email;
		private String tema;
		private String detalles_tema;
		private LocalDate fechaAlta;

		public Oradores(Long id_orador, String nombre, String apellido, String email, String tema, String detalles_tema, LocalDate fechaAlta) {
			this.id_orador = id_orador;
			init(nombre, apellido, email, tema, detalles_tema, fechaAlta);
		}
		
		public Oradores(String nombre, String apellido, String email, String tema, String detalles_tema, LocalDate fechaAlta) {
			init(nombre, apellido, email, tema, detalles_tema, fechaAlta);
		}
		
		public void init(String nombre, String apellido, String email, String tema, String detalles_tema, LocalDate fechaAlta) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.email = email;
			this.tema = tema;
			this.detalles_tema = detalles_tema;
			this.fechaAlta = fechaAlta;
		}
		
		public String toString() {
			return "Orador [id=" + id_orador + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", tema=" + tema + ", fechaAlta=" + fechaAlta + "]";
		}

		public Long getId_orador() {
			return id_orador;
		}

		public void setId_orador(Long id_orador) {
			this.id_orador = id_orador;
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

		public String getTema() {
			return tema;
		}

		public void setTema(String tema) {
			this.tema = tema;
		}

		public String getDetalles_tema() {
			return detalles_tema;
		}

		public void setDetalles_tema(String detalles_tema) {
			this.detalles_tema = detalles_tema;
		}

		public LocalDate getFechaAlta() {
			return fechaAlta;
		}

		public void setFechaAlta(LocalDate fechaAlta) {
			this.fechaAlta = fechaAlta;
		}
}