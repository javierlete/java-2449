package com.ipartek.formacion.clientes.filtros;

import static com.ipartek.formacion.clientes.controladores.Globales.*;

import java.io.IOException;

import com.ipartek.formacion.clientes.modelos.Alerta;
import com.ipartek.formacion.clientes.modelos.Usuario;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class LoginFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = -9166974371626064062L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if(usuario == null) {
			request.setAttribute("alerta", new Alerta("Debes estar autenticado para entrar en administración", "danger"));
			request.getRequestDispatcher(VISTAS + "/login.jsp").forward(req, res);
			
			return;
		}
		
		// Continuar la petición como si el filtro no existiera
		chain.doFilter(request, response);
	}
}
