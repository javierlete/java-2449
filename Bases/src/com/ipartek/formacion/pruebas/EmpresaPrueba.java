package com.ipartek.formacion.pruebas;

import java.time.LocalDate;

import com.ipartek.formacion.poo.Empresa;
import com.ipartek.formacion.poo.Persona;

public class EmpresaPrueba {
	public static void main(String[] args) {
		Empresa empresa = new Empresa(1L, "Ipartek", new Persona("Gerentez", "12345678Z", LocalDate.of(2000, 1, 2)));

		System.out.println(empresa);

		Persona p = new Persona("Pepe", "12346789Z", LocalDate.of(2001, 1, 1));

		empresa.contratar(p);
		empresa.contratar(new Persona("Juan", "12346789Z", LocalDate.of(2001, 1, 1)));
		empresa.contratar(new Persona("Pedro", "12346789Z", LocalDate.of(2001, 1, 1)));

		for (Persona persona : empresa.getPersonas()) {
			System.out.println(persona);
		}

		empresa.despedir("Pepe");
		empresa.despedir("Juan");

		for (Persona persona : empresa.getPersonas()) {
			System.out.println(persona);
		}

		Empresa e = new Empresa(null, "	 Pepe S.A.  ", new Persona("Jefazo", "12345678Z", LocalDate.of(2003, 2, 1)));

		System.out.println(e);
	}
}
