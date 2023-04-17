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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = obtenerId(request);

		if (id == null) {
			Iterable<Producto> productos = servicio.obtenerTodos();

			mapper.writeValue(response.getWriter(), productos);
		} else {
			Producto producto = servicio.obtenerPorId(id);

			if (producto == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			} else {
				mapper.writeValue(response.getWriter(), producto);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Producto producto = mapper.readValue(request.getInputStream(), Producto.class);

		servicio.insertar(producto);

		response.setStatus(HttpServletResponse.SC_CREATED);

		mapper.writeValue(response.getWriter(), producto);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Producto producto = mapper.readValue(request.getInputStream(), Producto.class);

		servicio.modificar(producto);

		mapper.writeValue(response.getWriter(), producto);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = obtenerId(request);

		if(id == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		servicio.borrar(id);

		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	private Long obtenerId(HttpServletRequest request) {
		String path = request.getPathInfo();

		if (path == null || path.trim().length() < 2) {
			return null;
		}

		return Long.parseLong(path.substring(1));
	}

}
