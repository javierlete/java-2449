package com.ipartek.formacion.bases.ejemploholamundo;

import java.util.ArrayList;

public class Colecciones {
	public static void main(String[] args) {
		ArrayList<String> textos = new ArrayList<>();
		
		textos.add("Uno");
		textos.add("Dos");
		textos.add("Tres");
		
		for(String texto: textos) {
			System.out.println(texto);
		}
		
		System.out.println(textos.size());
		
		System.out.println(textos.get(1));
		
		textos.remove(1);

		textos.add(0, "NUEVO");
		
		textos.set(2, "MODIFICADO");
		
		for(String texto: textos) {
			System.out.println(texto);
		}

	}
}
