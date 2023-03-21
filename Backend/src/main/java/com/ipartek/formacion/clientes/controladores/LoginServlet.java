package com.ipartek.formacion.clientes.controladores;

import static com.ipartek.formacion.clientes.controladores.Globales.*;

import java.io.IOException;

import com.ipartek.formacion.clientes.modelos.Alerta;
import com.ipartek.formacion.clientes.modelos.Usuario;

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
		request.getRequestDispatcher(VISTAS + "/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(user, password, null);
		
		if(usuarioValido(usuario)) {
			HttpSession session = request.getSession();
			
			session.setAttribute("usuario", usuario);
			
			response.sendRedirect(request.getContextPath() + "/index");
		} else {
			request.setAttribute("usuario", usuario);
			request.setAttribute("alerta", new Alerta("Usuario o contraseña incorrectos", "danger"));
			
			request.getRequestDispatcher(VISTAS + "/login.jsp").forward(request, response);
		}
	}

	private boolean usuarioValido(Usuario usuario) {
		if("javier".equals(usuario.getIdentificativo()) && "lete".equals(usuario.getPassword())) {
			usuario.setNombre("Javier Lete");
			return true;
		}
		
		return false;
	}

}
