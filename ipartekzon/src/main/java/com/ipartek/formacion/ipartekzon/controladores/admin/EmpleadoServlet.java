package com.ipartek.formacion.ipartekzon.controladores.admin;

import static com.ipartek.formacion.ipartekzon.controladores.configuraciones.Globales.*;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/empleado")
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("id");

		if (paramId != null) {
			Long id = Long.parseLong(paramId);

			request.setAttribute("empleado", EMPLEADO_NEGOCIO.obtenerPorId(id));
		}

		request.setAttribute("empleados", EMPLEADO_NEGOCIO.listado());
		
		request.getRequestDispatcher(VISTAS + "/admin/empleado.jsp").forward(request, response);
	}
}
