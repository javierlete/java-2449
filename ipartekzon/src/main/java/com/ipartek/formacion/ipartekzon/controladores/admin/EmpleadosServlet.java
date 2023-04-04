package com.ipartek.formacion.ipartekzon.controladores.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static com.ipartek.formacion.ipartekzon.controladores.configuraciones.Globales.*;

@WebServlet("/admin/empleados")
public class EmpleadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("empleados", EMPLEADO_NEGOCIO.listado());
		request.getRequestDispatcher(VISTAS + "/admin/empleados.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
