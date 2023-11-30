package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.time.LocalDate;

import ar.com.codoacodo.entities.Oradores;
import ar.com.codoacodo.repository.MySqlOradorRepository;
import ar.com.codoacodo.repository.OradorRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/orador/nuevo")
public class NuevoOradorController extends HttpServlet {

//	Crear, usamos POST
	@Override
	protected void doPost(
			HttpServletRequest reqest, // Lo que manda el user
			HttpServletResponse response //Lo que responde el servidor
			) throws ServletException, IOException {
		
		
//		Capturo los parámetros enviados por el front
		String nombre = reqest.getParameter("nombre");
		String apellido = reqest.getParameter("apellido");
		String email = reqest.getParameter("email");
		String tema = reqest.getParameter("tema");
//		Creo mi orador con esos parametros
		Oradores nuevo = new Oradores(null, nombre, apellido, email, tema, LocalDate.now());
		
//		ahora por medio del repository guarda en la db
		OradorRepository repository = new MySqlOradorRepository();
		
		repository.save(nuevo);
		
		//ahora respondo al front
		response.getWriter().print("OK");//json
	}
}
