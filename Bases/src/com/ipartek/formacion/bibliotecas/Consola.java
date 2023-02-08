package com.ipartek.formacion.bibliotecas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Consola {
	private static Scanner sc = new Scanner(System.in);
	
	public static final boolean ES_ERROR = true;
	
	public static final String FECHA_ESPANOL = "d/M/y";
	public static final String FECHA_EUSKERA = "M/d/y";
	
	public static final String FECHA_ESPANOL_LONGITUD_FIJA = "dd/MM/yyyy";
	public static final String FECHA_EUSKERA_LONGITUD_FIJA = "MM/dd/yyyy";
	
	public static void p(String mensaje) {
		System.out.print(mensaje + ": ");
	}
	
	public static void pl(String mensaje, boolean esError) {
		if(esError) {
			System.err.println(mensaje);
		} else {
			pl(mensaje);
		}
	}

	public static void pl(Object mensaje) {
		System.out.println(mensaje);
	}
	
	public static void ple(Object mensaje) {
		System.err.println(mensaje);
	}
	
	public static void pl() {
		System.out.println();
	}

	public static void pl(LocalDate fecha) {
		pl(fecha, FECHA_ESPANOL_LONGITUD_FIJA);
	}

	public static void pl(LocalDate fecha, String formato) {
		pl(fecha.format(DateTimeFormatter.ofPattern(formato)));
	}

	public static String pedirTexto(String mensaje) {
		p(mensaje);
		return sc.nextLine();
	}
	
	public static int pedirEntero() {
		return pedirEntero("Introduce un número entero");
	}

	public static int pedirEntero(String mensaje) {
		boolean hayError = true;
		
		int numero = 0;

		String numeroEnTexto;
		
		do {
			numeroEnTexto = pedirTexto(mensaje);
			
			try {
				numero = Integer.parseInt(numeroEnTexto);
				hayError = false;
			} catch (NumberFormatException e) {
				pl("Necesito el número en dígitos", ES_ERROR);
			}
		} while (hayError);
		
		return numero;
	}

	public static long pedirLong(String mensaje) {
		boolean hayError = true;
		
		long numero = 0;

		String numeroEnTexto;
		
		do {
			numeroEnTexto = pedirTexto(mensaje);
			
			try {
				numero = Long.parseLong(numeroEnTexto);
				hayError = false;
			} catch (NumberFormatException e) {
				pl("Necesito el número en dígitos", ES_ERROR);
			}
		} while (hayError);
		
		return numero;
	}

	public static BigDecimal pedirBigDecimal(String mensaje) {
		boolean hayError = true;
		
		BigDecimal numero = null;

		String numeroEnTexto;
		
		do {
			numeroEnTexto = pedirTexto(mensaje);
			
			try {
				numero = new BigDecimal(numeroEnTexto);
				hayError = false;
			} catch (NumberFormatException e) {
				pl("Necesito el número en dígitos", ES_ERROR);
			}
		} while (hayError);
		
		return numero;
	}
	
	public static double pedirDoble(String mensaje) {
		boolean hayError = true;
		
		double numero = 0;

		String numeroEnTexto;
		
		do {
			numeroEnTexto = pedirTexto(mensaje);
			
			try {
				numero = Double.parseDouble(numeroEnTexto);
				hayError = false;
			} catch (NumberFormatException e) {
				pl("Necesito el número en dígitos y comas", ES_ERROR);
			}
		} while (hayError);
		
		return numero;
	}
	
	public static LocalDate pedirFecha() {
		return pedirFecha("Introduce una fecha");
	}

	public static LocalDate pedirFecha(String mensaje) {
		return pedirFecha(mensaje, FECHA_ESPANOL_LONGITUD_FIJA);
	}

	public static LocalDate pedirFecha(String mensaje, String formato) {
		boolean hayError = true;
		
		LocalDate fecha = null;

		String fechaEnTexto;
		
		do {
			fechaEnTexto = pedirTexto(mensaje);
			
			try {
				fecha = LocalDate.parse(fechaEnTexto, DateTimeFormatter.ofPattern(formato));
				hayError = false;
			} catch (DateTimeParseException e) {
				pl("Necesito la fecha en el formato " + formato, ES_ERROR);
			}
		} while (hayError);
		
		return fecha;
	}
}
