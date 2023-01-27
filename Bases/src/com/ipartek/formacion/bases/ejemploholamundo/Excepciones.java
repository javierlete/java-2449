package com.ipartek.formacion.bases.ejemploholamundo;

public class Excepciones {
	public static void main(String[] args) {
		int a = 100, b = 1, total;

		System.out.println("ANTES");

		try {
			int[] arr = new int[2];
			
			arr[3] = 5;
			
			String s = "Hola";
			
			System.out.println(s.toUpperCase());
			
			total = a / b;
		} catch (ArithmeticException e) {
			total = Integer.MAX_VALUE;
		} catch (NullPointerException e) {
			System.err.println("Error no esperado");
			return;
		} finally {
			System.out.println("Pase lo que pase");
		}

		System.out.println(total);

		System.out.println("DESPUÉS");
	}
}
