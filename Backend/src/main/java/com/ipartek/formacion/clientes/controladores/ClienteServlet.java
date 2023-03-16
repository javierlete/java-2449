package com.ipartek.formacion.clientes.controladores;

import java.io.IOException;
import java.time.LocalDate;

import com.ipartek.formacion.clientes.accesodatos.DaoCliente;
import com.ipartek.formacion.clientes.accesodatos.DaoClienteSQLite;
import com.ipartek.formacion.clientes.modelos.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sqliteDb = "/Users/javierlete/git/java-2449/Backend/sql/clientes.db";

		DaoCliente dao = new DaoClienteSQLite(sqliteDb);

		String paramId = request.getParameter("id");
		String paramBorrarId = request.getParameter("borrarId");
		
		if(paramBorrarId != null) {
			Long id = Long.parseLong(paramBorrarId);
			
			dao.borrar(id);
			
			response.sendRedirect("clientes");
			
			return;
		}
		
		if (paramId != null) {
			Long id = Long.parseLong(paramId);

			request.setAttribute("cliente", dao.obtenerPorId(id));
		}

		request.getRequestDispatcher("cliente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sqliteDb = "/Users/javierlete/git/java-2449/Backend/sql/clientes.db";

		DaoCliente dao = new DaoClienteSQLite(sqliteDb);

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

		if (id != null) {
			dao.modificar(cliente);
		} else {
			dao.insertar(cliente);
		}

		response.sendRedirect("clientes");
	}

}
