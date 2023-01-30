package com.ipartek.formacion.bases.ejemploholamundo;

import java.util.Scanner;

public class Funciones {
	private static final boolean ES_ERROR = true;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int numero = pedirEntero();
		int numero2 = pedirEntero("Dame otro número");
		
		pl(numero + " x " + numero2 + " = " + numero * numero2);
		
		sc.close();
	}

	private static int pedirEntero() {
		return pedirEntero("Introduce un número entero");
	}
	
	private static int pedirEntero(String mensaje) {
		boolean hayError = true;
		
		int numero = 0;

		do {
			p(mensaje);
			String numeroEnTexto = sc.nextLine();
			
			try {
				numero = Integer.parseInt(numeroEnTexto);
				hayError = false;
			} catch (NumberFormatException e) {
				pl("Necesito el número en dígitos", ES_ERROR);
			}
		} while (hayError);
		
		return numero;
	}

	private static void p(String mensaje) {
		System.out.print(mensaje + ": ");
	}
	
	private static void pl(String mensaje) {
		System.out.println(mensaje);
	}
	
	// DRY: Don't Repeat Yourself
	
	private static void pl(String mensaje, boolean esError) {
		if(esError) {
			System.err.println(mensaje);
		} else {
			pl(mensaje);
		}
	}
}
