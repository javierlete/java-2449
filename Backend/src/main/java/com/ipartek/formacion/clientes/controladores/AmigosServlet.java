package com.ipartek.formacion.clientes.controladores;

import static com.ipartek.formacion.clientes.controladores.Globales.*;

import java.io.IOException;

import com.ipartek.formacion.clientes.modelos.ListaAmigos;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/amigos")
public class AmigosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListaAmigos listaAmigos = (ListaAmigos) request.getSession().getAttribute("listaAmigos");
		request.setAttribute("amigos", listaAmigos.getAmigos().values());
		
		request.getRequestDispatcher(VISTAS + "/amigos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
