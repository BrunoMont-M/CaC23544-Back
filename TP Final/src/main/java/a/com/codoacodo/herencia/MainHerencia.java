package a.com.codoacodo.herencia;

public class MainHerencia {

	public static void main(String[] args) {
//		Crear artículo
		Articulo a1 = new Articulo("Titulo1", 150.5f, "http://url.com/bla1.jpg");
//		Llamo al setter
		a1.setAutor("autor a1");
//		Métodos disponibles
//		System.out.println(a1);
		
		// Hijo h = new Hijo()
		Musica m1 = new Musica("m1", 250.7f, "http://url.com/m1.jpg");
		m1.setAutor("autor m1"); // esto es de articulo
		String[] temas = new String[] {"t1", "t2", "t3", "t4"};
		m1.setTemas(temas); // esto es de Musica
		
//		System.out.println(m1);
		
		Articulo p1 = new Pelicula("peli1", 567f, "bla.jpg");
		Pelicula peli = (Pelicula)p1; //down casting, con esto podemos ver lo que está dentro de la clase padre
		peli.setFormato("BlueRay");
		peli.setProductora("Warner Bros");
		
		System.out.println("--------------");
		System.out.println(p1);
		
//		Vector para guardar las instacias
		Articulo[] resultados = new Articulo[3];
		resultados[0] = p1;
		resultados[1] = p1;
		resultados[2] = p1;
		
		
		
	}

}
