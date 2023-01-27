package com.ipartek.formacion.bases.ejemploholamundo;

import java.util.Scanner;

public class Conversiones {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean hayError = true;
		
		do {
			System.out.print("Dime un número: ");
			String numeroEnTexto = sc.nextLine();
			
			int numero;
			
			try {
				numero = Integer.parseInt(numeroEnTexto);
				System.out.println(numero + " x 2 = " + numero * 2);
				hayError = false;
			} catch (NumberFormatException e) {
				System.err.println("Necesito el número en dígitos");
			}
		} while (hayError);
		
		sc.close();
	}
}
