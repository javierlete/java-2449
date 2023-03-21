package com.ipartek.formacion.clientes.controladores.admin;

import static com.ipartek.formacion.clientes.controladores.Globales.*;

import java.io.IOException;
import java.time.LocalDate;

import com.ipartek.formacion.clientes.modelos.Alerta;
import com.ipartek.formacion.clientes.modelos.Cliente;

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
		String paramBorrarId = request.getParameter("borrarId");
		
		if(paramBorrarId != null) {
			Long id = Long.parseLong(paramBorrarId);
			
			DAO.borrar(id);
			
			response.sendRedirect(request.getContextPath() + "/admin/clientes");
			
			return;
		}
		
		if (paramId != null) {
			Long id = Long.parseLong(paramId);

			request.setAttribute("cliente", DAO.obtenerPorId(id));
		}

		request.getRequestDispatcher(VISTAS + "/admin/cliente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String nif = request.getParameter("nif");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String paramFechaNacimiento = request.getParameter("fechaNacimiento");

		Long id = null;

		if (paramId.trim().length() > 0) {
			id = Long.parseLong(paramId);
		}

		LocalDate fechaNacimiento = null;

		if (paramFechaNacimiento.trim().length() > 0) {
			fechaNacimiento = LocalDate.parse(paramFechaNacimiento);
		}

		Cliente cliente = new Cliente(id, nombre, nif, telefono, email, fechaNacimiento);

		if(!cliente.isValido()) {
			request.setAttribute("cliente", cliente);
			request.setAttribute("alerta", new Alerta("Revisa los datos del formulario", "danger"));

			request.getRequestDispatcher(VISTAS + "/admin/cliente.jsp").forward(request, response);

			return;
		}
		
		if (id != null) {
			DAO.modificar(cliente);
		} else {
			DAO.insertar(cliente);
		}

		response.sendRedirect(request.getContextPath() + "/admin/clientes");
	}

}
