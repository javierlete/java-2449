package com.ipartek.formacion.ipartekzon.controladores.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static com.ipartek.formacion.ipartekzon.controladores.configuraciones.Globales.*;

@WebServlet("/admin/clientes")
public class ClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("clientes", CLIENTE_NEGOCIO.listado());
		request.getRequestDispatcher(VISTAS + "/admin/clientes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Long id = Long.parseLong(paramId);
		
		CLIENTE_NEGOCIO.eliminar(id);
		
		response.sendRedirect(request.getContextPath() + "/admin/clientes");
	}

}
