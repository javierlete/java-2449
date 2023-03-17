package com.ipartek.formacion.clientes.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		if(usuarioValido(user, password)) {
			HttpSession session = request.getSession();
			
			session.setAttribute("usuario", user);
			
			response.sendRedirect("index");
		} else {
			response.sendRedirect("login");
		}
	}

	private boolean usuarioValido(String user, String password) {
		return "javier".equals(user) && "lete".equals(password);
	}

}
