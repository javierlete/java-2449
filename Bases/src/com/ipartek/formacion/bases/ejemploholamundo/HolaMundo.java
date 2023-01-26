package com.ipartek.formacion.bases.ejemploholamundo;

import java.math.BigDecimal;

/**
 * Clase de ejemplo de bases de programación
 * 
 * @author javierlete
 *
 */
public class HolaMundo {
	/**
	 * Método de entrada por defecto de la aplicación
	 * 
	 * @param argumentosDeEntrada lista de datos recibidos por consola
	 */
	public static void main(String[] argumentosDeEntrada) {
		/*
		 * Ejemplo de programa básico. Uso de variables etc.
		 */

		// Esta línea muestra el texto por consola
		System.out.println("Hola"); // Mostrará "Hola"

		int i; // Declaración de una variable, en este caso i de tipo int (32 bits)

		i = 5;

		System.out.println(i);

		int x = 3; // Declaración con inicialización de x de tipo int con el valor 3

		System.out.println(x);

		int suma = x + i;

		System.out.println(suma);

		System.out.println(2 ^ 3);
		System.out.println(Math.pow(2.0, 3.0));

		double a = 0.1, b = 0.2;
		double total = a + b;

		long l = 2148000000l;
		long milong = 1;
		Long miLong = 1l;
		
		byte mibyte = 5;
		Byte miByte = mibyte;
		Byte nulo = null;
		byte convertido = miByte;

		System.out.println(l+milong+miLong+miByte+convertido);
		System.out.println(nulo);
		
		@SuppressWarnings("unused")
		float mifloat = 5.0f;
		
		System.out.println(total);

		BigDecimal bda, bdb;
		BigDecimal bdTotal;

		bda = new BigDecimal("0.1");
		bdb = new BigDecimal("0.2");

		bdTotal = bda.add(bdb);

		System.out.println(bdTotal);

		System.out.println(a > b);

		double supuestoTotal = 0.3;

		System.out.println(total == supuestoTotal); // No usar en doubles ==

		System.out.println(1 + 2 + 3);

		System.out.println(supuestoTotal - 1E-16 < total && total < supuestoTotal + 1E-16);

		int c, d, e, f;
		c = d = e = f = 0;

		System.out.println(++c);
		System.out.println(d++);
		System.out.println(--e);
		System.out.println(f--);

		System.out.println(a > b ? "A es mayor" : "B es mayor");

		boolean booleano = false;

		System.out.println(booleano ? "VERDADERO" : "FALSO");

		String juan = new String("Prueba");
		String pedro = new String("Prueba");
		
		System.out.println("Son EL MISMO? " + (juan == pedro));
		System.out.println("Son iguales? " + (juan.equals(pedro)));
		
		// SENTENCIAS DE CONTROL
		if (booleano) {
			System.out.println("VERDADERO");
		} else {
			System.out.println("FALSO");
		}

		String nombre = "Pepe";

		if (nombre.equals("Pepe")) {
			System.out.println("Este es mi Pepillo");
		} else if (nombre.equals("Juan")) {
			System.out.println("¡Qué pasa Juanito!");
		} else if (nombre.equals("Pedro")) {
			System.out.println("Pedrito, cuanto tiempo sin verte");
		} else {
			System.out.println("Pues no te conozco de nada");
		}

		String mensaje;

		switch (nombre) {
		case "Juan":
			mensaje = "Hola Juanito";
			break;
		case "Pedro":
			mensaje = "¡PedroooooOOOOoooo!";
			break;
		case "Pepe":
			mensaje = "¡Cuanto tiempo Pepe!";
			break;
		default:
			mensaje = "Pues no te conozco, ¿y tú quién eres?";
		}

		System.out.println(mensaje);

		int mes = 2, dias;

		switch (mes) {
		case 2:
			dias = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dias = 30;
			break;
		default:
			dias = 31;
		}

		System.out.println("El mes " + mes + " tiene " + dias + " días");
		
		int contador = 1;
		
		while(contador <= 5) {
			System.out.println(contador++);
		}
		
		contador = 1;
		
		do {
			System.out.println(contador++);
		} while(contador <= 5);
		
		// (inicialización; condición de permanencia; "postmodificación")
		for(int cont = 1; cont <= 5; cont++) {
			System.out.println(cont);
		}
		
//		int cont = 1;
//		
//		while(cont <= 5) {
//			System.out.println(cont);
//			cont++;
//		}
		
	}
}
