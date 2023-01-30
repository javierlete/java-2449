package com.ipartek.formacion.pruebas;

import static com.ipartek.formacion.bibliotecas.Consola.FECHA_ESPANOL;
import static com.ipartek.formacion.bibliotecas.Consola.pedirDoble;
import static com.ipartek.formacion.bibliotecas.Consola.pedirEntero;
import static com.ipartek.formacion.bibliotecas.Consola.pedirFecha;
import static com.ipartek.formacion.bibliotecas.Consola.pedirTexto;
import static com.ipartek.formacion.bibliotecas.Consola.pl;

import java.time.LocalDate;

public class ConsolaPrueba {
	public static void main(String[] args) {
		int numero = pedirEntero("Dime un número");
		pl(numero);
		
		String nombre = pedirTexto("Dime tu nombre");
		pl("Hola " + nombre);
		
		double doble = pedirDoble("Dame un número con coma");
		pl(doble);
		
		LocalDate fecha = pedirFecha("Introduce la fecha", FECHA_ESPANOL);
		pl(fecha);
	}
}
