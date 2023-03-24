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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(VISTAS + "/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");

		Usuario usuario = new Usuario(null, user, password, null, null);

		Usuario usuarioValidado = usuarioValido(usuario);

		if (usuarioValidado != null) {
			HttpSession session = request.getSession();

			session.setAttribute("usuario", usuarioValidado);

			response.sendRedirect(request.getContextPath() + "/index");
		} else {
			request.setAttribute("usuario", usuario);
			request.setAttribute("alerta", new Alerta("Usuario o contraseña incorrectos", "danger"));

			request.getRequestDispatcher(VISTAS + "/login.jsp").forward(request, response);
		}
	}

	private Usuario usuarioValido(Usuario usuarioIntroducido) {
		Usuario usuarioEncontrado = DAO_USUARIO.obtenerPorIdentificativo(usuarioIntroducido.getIdentificativo());

		if (usuarioEncontrado == null) {
			return null;
		}

		if (!usuarioIntroducido.getPassword().equals(usuarioEncontrado.getPassword())) {
			return null;
		}

		return usuarioEncontrado;
	}

}
