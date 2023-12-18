package com.codoacodo.tpfinal.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.codoacodo.tpfinal.entities.Oradores;
import com.codoacodo.tpfinal.repository.OradorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.codoacodo.tpfinal.repository.MySqlOradorRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/oradores")
public class OradorController extends HttpServlet {
	
	private OradorRepository repository = new MySqlOradorRepository();

	@Override
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		
		String json = request.getReader()
				.lines()
				.collect(Collectors.joining(System.lineSeparator()));//spring
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		
		OradorRequest oradorRequest = mapper.readValue(json, OradorRequest.class);
		

		Oradores nuevo = new Oradores(oradorRequest.getNombre(), oradorRequest.getApellido(), oradorRequest.getEmail(), oradorRequest.getTema(), oradorRequest.getDetalles_tema(), LocalDate.now());
		
		repository.save(nuevo);
		
		String jsonParaEnviarALFrontend = mapper.writeValueAsString(nuevo);
		
		response.getWriter().print(jsonParaEnviarALFrontend);
	}
	
	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		
		List<Oradores> listado = this.repository.findAll();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		
		String jsonParaEnviarALFrontend = mapper.writeValueAsString(listado);
		
		response.getWriter().print(jsonParaEnviarALFrontend);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException, IOException {
			
		String id_orador = request.getParameter("id");
			
		OradorRepository repository = new MySqlOradorRepository();
		repository.delete(Long.parseLong(id_orador));
			
		response.setStatus(HttpServletResponse.SC_OK);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException, IOException {
		
		String id_orador = request.getParameter("id"); //lo que recibia del front "getParameter" estaba mal porque el front lo solicitaba como id y lo tenia como id_orador
		
		String json = request.getReader()
				.lines()
				.collect(Collectors.joining(System.lineSeparator()));//spring
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		
		OradorRequest oradorRequest = mapper.readValue(json, OradorRequest.class);
		
		Oradores orador = this.repository.getById(Long.parseLong(id_orador));
		
		orador.setNombre(oradorRequest.getNombre());
		orador.setApellido(oradorRequest.getApellido());
		orador.setEmail(oradorRequest.getEmail());
		orador.setTema(oradorRequest.getTema());
		orador.setDetalles_tema(oradorRequest.getDetalles_tema());
		
		this.repository.update(orador);
		
		response.setStatus(HttpServletResponse.SC_OK);
	}
}