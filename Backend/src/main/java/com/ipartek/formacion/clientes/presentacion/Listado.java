package com.ipartek.formacion.clientes.presentacion;

import java.io.IOException;
import java.io.PrintWriter;

import com.ipartek.formacion.clientes.accesodatos.DaoCliente;
import com.ipartek.formacion.clientes.accesodatos.DaoClienteSQLite;
import com.ipartek.formacion.clientes.modelos.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clientes/listado")
public class Listado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sqliteDb = "/Users/javierlete/git/java-2449/Backend/sql/clientes.db";
		
		PrintWriter out = response.getWriter();
		
		DaoCliente dao = new DaoClienteSQLite(sqliteDb);
		
		for(Cliente c: dao.obtenerTodos()) {
			out.println(c);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
