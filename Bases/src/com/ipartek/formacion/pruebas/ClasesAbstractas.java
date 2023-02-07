package com.ipartek.formacion.pruebas;

import java.util.ArrayList;

public class ClasesAbstractas {
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		ArrayList<Number> numeros = new ArrayList<>();
		
		numeros.add(new Integer(5));
		numeros.add(new Double(3.2));
		numeros.add(4);
		numeros.add(6.7);
		
		for(Number numero: numeros) {
			System.out.println(numero.doubleValue());
		}
	}
}
