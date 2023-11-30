package ar.com.codoacodo;

import java.time.LocalDate;

public class Auto {
	/*Atributes*/
	
	String marca;
	String modelo;
	String color;
	Integer anio;
	Float velocidad;
	Float velMax;
	Boolean encendido;
	String dominio;
	LocalDate fchCreacion;
	
	/*Builder*/
	
	Auto(String marca, String modelo, Integer anio, String color, String dominio, Float velMax) {
		velocidad = 0f;
		fchCreacion = LocalDate.now();
		// this es un puntero que apunta a los atributos de los métodos de una clase
		this.encendido = Boolean.FALSE; // Otra forma es hacer "encendido = Boolean.FALSE;"
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.dominio = dominio;
		this.color = color;
		this.velMax = velMax;
	}
	
	/*Methods*/
	
	void encender() {
		if(!this.encendido) {
			this.encendido = Boolean.TRUE;
		} else {
			System.out.println("Ya esta encendido");
		}
	}
	void apagar() {
		if(this.encendido) {
			this.encendido = Boolean.FALSE;
			velocidad = 0f;
		} else {
			System.out.println("Ya estaba apagado");
		}
	}
	// Asumimos que acelera de a 1
	void acelerar() {
		if(encendido) {
			if(velocidad < velMax) {
				velocidad++;
			} else {
				System.out.println("Velocidad maxima alcanzada, la maxima es: " + velocidad);
			}
		} else {
			System.out.println("El auto no esta encendido");
		}
	}
	void frenar() {
		if(encendido) {
			if(velocidad > 0) {
				velocidad--;
			} else {
				System.out.println("La velocidad llego a 0");
			}
		} else {
			System.out.println("Frenando con el auto apagado");
		}
	}
}













