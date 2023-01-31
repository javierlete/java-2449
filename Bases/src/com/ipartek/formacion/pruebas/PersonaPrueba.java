package com.ipartek.formacion.pruebas;

import java.time.LocalDate;

import com.ipartek.formacion.poo.Persona;

public class PersonaPrueba {

	public static void main(String[] args) {
		Persona p; // Crea una referencia a un objeto de tipo Persona
		// Por defecto vale null
		
		p = new Persona(); // new busca una nueva zona de memoria donde guardar todos los datos del objeto de tipo Persona que se va a crear
		
		System.out.println(p);
		
		p.setId(5L);
		p.setNombre("   Javier	  ");
		p.setDni("12345678Z");
		p.setFechaNacimiento(LocalDate.of(2000, 1, 2));
		
		System.out.println(p.getNombre());
		
		System.out.println(p.toString());
		
		Persona p2 = new Persona(1L, "  Pepe  ", "87654321Z", LocalDate.of(2003, 1, 31));
		
		System.out.println(p2.getNombre());
		System.out.println(p2.getFechaNacimiento());
		
		System.out.println(p2);
		
		System.out.println(p2.obtenerEdad());
		System.out.println(p2.isMayorDeEdad());
		
		Persona copia = p2; // (Copia de "tarjeta de visita"/dirección de memoria) 
		//Persona copia = new Persona(p2); // (CLON)
		
		copia.setNombre("COPIA");
		
		System.out.println(copia);
		System.out.println(p2);
	}

}
