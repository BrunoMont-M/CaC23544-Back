package com.codoacodo.tpfinal.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.codoacodo.tpfinal.entities.Compradores;
import com.codoacodo.tpfinal.repository.CompradorRepository;
import com.codoacodo.tpfinal.repository.MySqlCompradorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/compradores")
public class CompradorController extends HttpServlet {

	CompradorRepository repository = new MySqlCompradorRepository();

	@Override
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		
		String json = request.getReader()
				.lines()
				.collect(Collectors.joining(System.lineSeparator()));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		
		CompradorRequest compradorRequest = mapper.readValue(json, CompradorRequest.class);
		
		Compradores nuevo = new Compradores(compradorRequest.getNombre(), compradorRequest.getApellido(), compradorRequest.getEmail(), compradorRequest.getCantidad(), compradorRequest.getCategoria(), compradorRequest.getTotal_precio());
		
		repository.save(nuevo);
		
		String jsonParaEnviarALFrontend = mapper.writeValueAsString(nuevo);
		
		response.getWriter().print(jsonParaEnviarALFrontend);
	}
	
	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException {
		
		List<Compradores> listado = this.repository.findAll();
		
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
			
		String id_comprador = request.getParameter("id_comprador");
			
		CompradorRepository repository = new MySqlCompradorRepository();
		repository.delete(Long.parseLong(id_comprador));
			
		response.setStatus(HttpServletResponse.SC_OK);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, 
			HttpServletResponse response
			) throws ServletException, IOException {
		
		String id_comprador = request.getParameter("id_comprador");
		
		String json = request.getReader()
				.lines()
				.collect(Collectors.joining(System.lineSeparator()));
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		
		CompradorRequest compradorRequest = mapper.readValue(json, CompradorRequest.class);
		
		Compradores comprador = this.repository.getById(Long.parseLong(id_comprador));
		
		comprador.setNombre(compradorRequest.getNombre());
		comprador.setApellido(compradorRequest.getApellido());
		comprador.setEmail(compradorRequest.getEmail());
		comprador.setCantidad(compradorRequest.getCantidad());
		comprador.setCategoria(compradorRequest.getCategoria());
		comprador.setTotal_precio(compradorRequest.getTotal_precio());
		
		this.repository.update(comprador);
		
		response.setStatus(HttpServletResponse.SC_OK);
	}
}