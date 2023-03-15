package com.ipartek.formacion.clientes.presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import com.ipartek.formacion.clientes.accesodatos.DaoCliente;
import com.ipartek.formacion.clientes.accesodatos.DaoClienteSQLite;
import com.ipartek.formacion.clientes.modelos.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clientes/modificar")
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String sqliteDb = "/Users/javierlete/git/java-2449/Backend/sql/clientes.db";
		
		DaoCliente dao = new DaoClienteSQLite(sqliteDb);
		
		String paramId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String nif = request.getParameter("nif");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String paramFechaNacimiento = request.getParameter("fechaNacimiento");
		
		Long id = Long.parseLong(paramId);
		
		LocalDate fechaNacimiento = null;
		
		if(paramFechaNacimiento != null) {
			fechaNacimiento = LocalDate.parse(paramFechaNacimiento);
		}
		
		Cliente cliente = new Cliente(id, nombre, nif, telefono, email, fechaNacimiento);
		
		out.println("Se ha modificado el cliente: " + dao.modificar(cliente));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
