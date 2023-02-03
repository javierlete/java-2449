package com.ipartek.formacion.pruebas;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.poo.Empleado;
import com.ipartek.formacion.poo.Persona;

public class EmpleadoPrueba {

	public static void main(String[] args) {
		Empleado e = new Empleado("   Javier   ", "12345678Z", LocalDate.of(2000, 1, 2), "1234123412341234",
				new BigDecimal("1234.56"));

		System.out.println(e);

		e.setId(1L);
		e.setNombre("Javier");
		e.setDni("12345678Z");
		e.setFechaNacimiento(LocalDate.of(2000, 1, 2));

		e.setNumeroSeguridadSocial("1234123412341234");
		e.setSueldoMensual(new BigDecimal("1234.56"));

		System.out.println(e);
		System.out.println(e.isMayorDeEdad());
		System.out.println(e.getEdad());

		System.out.println(Empleado.getMayoriaDeEdad());

		System.out.println(e.getNumeroSeguridadSocial());
		System.out.println(e.getSueldoMensual());

		Persona p = e;

		System.out.println(p.getNombre());
		// System.out.println(p.getSueldoMensual()); // No está disponible para
		// cualquier persona

		if (p instanceof Empleado) {
			Empleado e2 = (Empleado) p;

			System.out.println(e2.getNombre());
			System.out.println(e2.getSueldoMensual());
		} else {
			System.err.println("p NO es un empleado");
		}
		
		Persona p2 = new Persona("Pepe");

		if (p2 instanceof Empleado) {
			Empleado e3 = (Empleado) p2;
			System.out.println(e3);
		} else {
			System.err.println("p2 NO es un empleado");
		}
		
		Empleado empleado = new Empleado("   Javier   ", "12345678Z", LocalDate.of(2000, 1, 2), "1234123412341234",
				new BigDecimal("1234.56"));
		Persona persona = empleado;
		
		System.out.println(persona);
	}

}
