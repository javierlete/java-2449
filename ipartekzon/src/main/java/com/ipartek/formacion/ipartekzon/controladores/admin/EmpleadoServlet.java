package com.ipartek.formacion.ipartekzon.controladores.admin;

import static com.ipartek.formacion.ipartekzon.controladores.configuraciones.Globales.*;

import java.io.IOException;
import java.math.BigDecimal;

import com.ipartek.formacion.ipartekzon.modelos.Empleado;

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

		mostrarFormulario(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("id");
		String nif = request.getParameter("nif");
		String nombre = request.getParameter("nombre");
		String paramSueldo = request.getParameter("sueldo");
		String paramJefe = request.getParameter("jefe");
		
		String borrar = request.getParameter("borrar");

		Long id = null;

		if (paramId.trim().length() > 0) {
			id = Long.parseLong(paramId);
			
			if(borrar != null) {
				EMPLEADO_NEGOCIO.eliminar(id);
				
				mostrarListado(request, response);
				
				return;
			}
		} else if(borrar != null) {
			mostrarFormulario(request, response);
			
			return;
		}
		
		BigDecimal sueldo = null;
		
		if(paramSueldo.trim().length() > 0) {
			sueldo = new BigDecimal(paramSueldo);
		}
		
		Empleado jefe = null;

		if (paramJefe.trim().length() > 0) {
			jefe = Empleado.builder().id(Long.parseLong(paramJefe)).build();
		}

		Empleado empleado = Empleado.builder().id(id).nombre(nombre).nif(nif).sueldo(sueldo).jefe(jefe).build();
		
		Empleado empleadoResultado;
		
		if(id != null) {
			empleadoResultado = EMPLEADO_NEGOCIO.cambiar(empleado);
		} else {
			empleadoResultado = EMPLEADO_NEGOCIO.nuevo(empleado);
		}
		
		if(empleadoResultado == null) {
			request.setAttribute("errores", EMPLEADO_NEGOCIO.obtenerUltimosErrores());
			request.setAttribute("empleado", empleado);

			mostrarFormulario(request, response);
			
			return;
		}
		
		mostrarListado(request, response);
	}

	private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("empleados", EMPLEADO_NEGOCIO.listado());
		
		request.getRequestDispatcher(VISTAS + "/admin/empleado.jsp").forward(request, response);
	}

	private void mostrarListado(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/admin/empleados");
	}
}
