package com.ipartek.formacion.clientes.controladores.admin;

import static com.ipartek.formacion.clientes.controladores.Globales.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import com.ipartek.formacion.clientes.modelos.Alerta;
import com.ipartek.formacion.clientes.modelos.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

@WebServlet("/admin/cliente")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String IMAGENES = "imgs";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("id");
		String paramBorrarId = request.getParameter("borrarId");

		if (paramBorrarId != null) {
			Long id = Long.parseLong(paramBorrarId);

			DAO_CLIENTES.borrar(id);

			response.sendRedirect(request.getContextPath() + "/admin/clientes");

			return;
		}

		if (paramId != null) {
			Long id = Long.parseLong(paramId);

			request.setAttribute("cliente", DAO_CLIENTES.obtenerPorId(id));
		}

		request.getRequestDispatcher(VISTAS + "/admin/cliente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String nif = request.getParameter("nif");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String paramFechaNacimiento = request.getParameter("fechaNacimiento");

		Long id = null;

		if (paramId.trim().length() > 0) {
			id = Long.parseLong(paramId);
		}

		LocalDate fechaNacimiento = null;

		if (paramFechaNacimiento.trim().length() > 0) {
			fechaNacimiento = LocalDate.parse(paramFechaNacimiento);
		}

		Cliente cliente = new Cliente(id, nombre, nif, telefono, email, fechaNacimiento);

		if (!cliente.isValido()) {
			request.setAttribute("cliente", cliente);
			request.setAttribute("alerta", new Alerta("Revisa los datos del formulario", "danger"));

			request.getRequestDispatcher(VISTAS + "/admin/cliente.jsp").forward(request, response);

			return;
		}

		String estado;
		
		if (id != null) {
			DAO_CLIENTES.modificar(cliente);
			estado = "modificado";
		} else {
			DAO_CLIENTES.insertar(cliente);
			estado = "añadido";
		}

		String uploadPath = getServletContext().getRealPath("") + File.separator + IMAGENES;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();

		Part part = request.getParts().stream().filter(p -> "imagen".equals(p.getName())).findFirst().orElse(null);
		part.write(uploadPath + File.separator + cliente.getId() + ".jpg");

		// String fileName;
		// for (Part part : request.getParts()) {
		// fileName = part.getSubmittedFileName();
		// part.write(uploadPath + File.separator + fileName);
		// }

		request.getSession().setAttribute("alerta", new Alerta("Usuario " + estado, "success"));
		
		response.sendRedirect(request.getContextPath() + "/admin/clientes");
	}

}
