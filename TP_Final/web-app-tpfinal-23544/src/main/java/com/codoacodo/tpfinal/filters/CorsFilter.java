package com.codoacodo.tpfinal.filters;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/*" })
public class CorsFilter implements Filter {

	private List<String> origins = List.of("http://localhost:5500", "http://127.0.0.1:5500", "https://brunomont-m.github.io/CaC23544-Front", "https://brunomont-m.github.io");

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String origin = ((HttpServletRequest) request).getHeader("origin");

		if (origin != null && origins.contains(origin)) {
			((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", origin);
			((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", "POST, DELETE, PUT, GET, OPTIONS");
			((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "*");
		}

		chain.doFilter(request, response);
	}

}
