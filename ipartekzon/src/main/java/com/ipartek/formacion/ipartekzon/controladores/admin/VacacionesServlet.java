package com.ipartek.formacion.ipartekzon.controladores.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.ipartek.formacion.ipartekzon.controladores.configuraciones.Globales.*;

@WebServlet("/admin/empleado/vacaciones")
public class VacacionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramIdEmpleado = request.getParameter("id-empleado");
		String paramFecha = request.getParameter("fecha");
		
		Long idEmpleado = Long.parseLong(paramIdEmpleado);
		LocalDate fecha = LocalDate.parse(paramFecha, DateTimeFormatter.ISO_DATE);
		
		EMPLEADO_NEGOCIO.agregarVacacion(idEmpleado, fecha);
		
		response.sendRedirect(request.getContextPath() + "/admin/empleado?id=" + idEmpleado);
	}

}
