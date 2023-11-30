package ar.com.codoacodo;

public class MainAuto {

	public static void main(String[] args) {
		// Instanciar un objeto
		
		Auto clio = new Auto(
				"Renault",
				"Clio",
				2020,
				"abc123",
				"Azul",
				3f
				);
		
		clio.acelerar();

	}

}
