package com.ipartek.formacion.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hola")
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); // "text/plain")
		PrintWriter out = response.getWriter();
		
		String nombre = request.getParameter("nombre");

		out.println("""
			<!DOCTYPE html>
			<html>
			<body>
				<h1>
				""");
		
		if (nombre == null) {
			out.println("Hola a todos");
		} else {
			out.println("Hola " + nombre);
		}
		
		out.println("""
				</h1>
			</body>
			</html>
				""");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
