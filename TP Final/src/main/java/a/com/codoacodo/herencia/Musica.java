package a.com.codoacodo.herencia;

import java.util.Arrays;

public class Musica extends Articulo {
	
	// Atributos
	private String[] temas;
	
	public Musica(String titulo, Float precio, String img) {
		super(titulo, precio, img);
	}

	public String[] getTemas() {
		return temas;
	}

	public void setTemas(String[] temas) {
		this.temas = temas;
	}

	@Override
	public String toString() {
		return "Musica [temas=" + Arrays.toString(temas) + "]";
	}
}