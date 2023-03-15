package com.ipartek.formacion.clientes.presentacion;

import java.io.IOException;

import com.ipartek.formacion.clientes.accesodatos.DaoCliente;
import com.ipartek.formacion.clientes.accesodatos.DaoClienteSQLite;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clientes/borrar")
public class Borrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sqliteDb = "/Users/javierlete/git/java-2449/Backend/sql/clientes.db";
		
		DaoCliente dao = new DaoClienteSQLite(sqliteDb);
		
		String paramId = request.getParameter("id");
		
		Long id = Long.parseLong(paramId);
		
		dao.borrar(id);
		
		//response.sendRedirect("listado"); // Cambia URL
		request.getRequestDispatcher("listado").forward(request, response); // NO cambia URL
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
