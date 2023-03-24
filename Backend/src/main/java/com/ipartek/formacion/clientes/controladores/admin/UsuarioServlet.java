package com.ipartek.formacion.clientes.controladores.admin;

import static com.ipartek.formacion.clientes.controladores.Globales.*;

import java.io.IOException;

import com.ipartek.formacion.clientes.modelos.Alerta;
import com.ipartek.formacion.clientes.modelos.Rol;
import com.ipartek.formacion.clientes.modelos.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

@WebServlet("/admin/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("id");
		String paramBorrarId = request.getParameter("borrarId");

		if (paramBorrarId != null) {
			Long id = Long.parseLong(paramBorrarId);

			DAO_USUARIO.borrar(id);

			response.sendRedirect(request.getContextPath() + "/admin/usuarios");

			return;
		}

		if (paramId != null) {
			Long id = Long.parseLong(paramId);

			request.setAttribute("usuario", DAO_USUARIO.obtenerPorId(id));
		}
		
		request.setAttribute("roles", DAO_ROL.obtenerTodos());

		request.getRequestDispatcher(VISTAS + "/admin/usuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String identificativo = request.getParameter("identificativo");
		String password = request.getParameter("password");
		
		String paramRolId = request.getParameter("rol");

		Long id = null;
		Long rolId = null;

		if (paramId.trim().length() > 0) {
			id = Long.parseLong(paramId);
		}
		
		if (paramRolId.trim().length() > 0) {
			rolId = Long.parseLong(paramRolId);
		}

		Rol rol = null;
		
		if(rolId != 0) {
			rol = new Rol(rolId, null, null);
		}
		
		Usuario usuario = new Usuario(id, identificativo, password, nombre, rol);
		
		if (!usuario.isValido()) {
			request.setAttribute("usuario", usuario);
			request.setAttribute("alerta", new Alerta("Revisa los datos del formulario", "danger"));
			request.setAttribute("roles", DAO_ROL.obtenerTodos());
			
			request.getRequestDispatcher(VISTAS + "/admin/usuario.jsp").forward(request, response);

			return;
		}

		String estado;
		
		if (id != null) {
			DAO_USUARIO.modificar(usuario);
			estado = "modificado";
		} else {
			DAO_USUARIO.insertar(usuario);
			estado = "añadido";
		}

		request.getSession().setAttribute("alerta", new Alerta("Usuario " + estado, "success"));
		
		response.sendRedirect(request.getContextPath() + "/admin/usuarios");
	}

}
