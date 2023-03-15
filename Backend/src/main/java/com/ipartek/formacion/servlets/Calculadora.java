package com.ipartek.formacion.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculadora")
public class Calculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String paramOp1 = request.getParameter("op1");
		String paramOp2 = request.getParameter("op2");
		String paramOp = request.getParameter("op");
		
		double op1 = Double.parseDouble(paramOp1);
		double op2 = Double.parseDouble(paramOp2);
		char op = paramOp.trim().charAt(0);
		Double total;
		
		switch(op) {
		case '+': total = op1 + op2; break;
		case '-': total = op1 - op2; break;
		case '*': total = op1 * op2; break;
		case '/': total = op1 / op2; break;
		default: total = null;
		}
		
		String mensaje;
		
		if(total == null) {
			mensaje = "ERROR. Operación no conocida";
		} else {
			mensaje = String.format("El resultado de %s %s %s = %s", op1, op, op2, total);
		}
		
		out.println(mensaje);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
