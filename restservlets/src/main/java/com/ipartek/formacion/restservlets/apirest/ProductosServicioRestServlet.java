package com.ipartek.formacion.restservlets.apirest;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipartek.formacion.restservlets.entidades.Producto;
import com.ipartek.formacion.restservlets.servicios.ProductoServicio;
import com.ipartek.formacion.restservlets.servicios.ProductoServicioImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.json.JsonMapper;

@WebServlet("/productos/*")
public class ProductosServicioRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductoServicio servicio = new ProductoServicioImpl();
	private ObjectMapper mapper = JsonMapper.builder().findAndAddModules().build();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Iterable<Producto> productos = servicio.obtenerTodos();

		mapper.writeValue(response.getWriter(), productos);

		response.getWriter().flush();
	}

}
