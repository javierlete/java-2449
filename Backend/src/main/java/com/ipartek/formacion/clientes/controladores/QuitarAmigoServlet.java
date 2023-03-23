package com.ipartek.formacion.clientes.controladores;

import java.io.IOException;

import com.ipartek.formacion.clientes.modelos.ListaAmigos;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/quitar-amigo")
public class QuitarAmigoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Long id = Long.parseLong(paramId);
		
		ListaAmigos listaAmigos = (ListaAmigos) request.getSession().getAttribute("listaAmigos");
		
		listaAmigos.getAmigos().remove(id);
		
		response.sendRedirect(request.getContextPath() + "/amigos");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
