package com.ipartek.formacion.ipartekzon.controladores.admin;

import static com.ipartek.formacion.ipartekzon.controladores.configuraciones.Globales.*;

import java.io.IOException;

import com.ipartek.formacion.ipartekzon.modelos.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/cliente")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("id");

		if (paramId != null) {
			Long id = Long.parseLong(paramId);

			request.setAttribute("cliente", CLIENTE_NEGOCIO.consultarPorId(id));
		}

		formulario(request, response);
	}

	private void formulario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(VISTAS + "/admin/cliente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("id");
		String nif = request.getParameter("nif");
		String nombre = request.getParameter("nombre");

		Long id = paramId.trim().length() > 0 ? Long.parseLong(paramId) : null;
		
		Cliente cliente = Cliente.builder().id(id).nombre(nombre).nif(nif).build();

		Cliente clienteResultado = null;

		if(id != null) {
			clienteResultado = CLIENTE_NEGOCIO.cambiar(cliente);
		} else {
			clienteResultado = CLIENTE_NEGOCIO.nuevo(cliente);
		}

		if (clienteResultado == null) {
			request.setAttribute("errores", CLIENTE_NEGOCIO.obtenerUltimosErrores());
			request.setAttribute("cliente", cliente);

			formulario(request, response);

			return;
		}

		response.sendRedirect(request.getContextPath() + "/admin/clientes");
	}

}
