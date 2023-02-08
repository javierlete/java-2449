package com.ipartek.formacion.bases.ejemploholamundo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
		
		Map<String, String> diccionario = new HashMap<>();
		
		diccionario.put("casa", "house");
		diccionario.put("perro", "dog");
		diccionario.put("gato", "cat");
		
		System.out.println(diccionario.get("perro"));
		
		for(Map.Entry<String, String> par: diccionario.entrySet()) {
			System.out.printf("%s: %s\n", par.getKey(), par.getValue());
		}
		
		for(String clave: diccionario.keySet()) {
			System.out.println(clave);
		}
		
		for(String valor: diccionario.values()) {
			System.out.println(valor);
		}
	}
}
