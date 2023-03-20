package com.ipartek.formacion.clientes.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String interruptor = request.getParameter("tema");
		
		String tema = interruptor == null ? "claro" : "oscuro";
		
		Cookie c = new Cookie("tema", tema);
		c.setMaxAge(60 * 60 * 24 * 30 * 2);

		response.addCookie(c);

		response.sendRedirect("index");
		//request.getRequestDispatcher("index").forward(request, response);
	}

}
