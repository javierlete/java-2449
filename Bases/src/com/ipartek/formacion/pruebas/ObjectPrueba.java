package com.ipartek.formacion.pruebas;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.poo.Empleado;
import com.ipartek.formacion.poo.Persona;

public class ObjectPrueba {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Object o = new Object();
		Object o2 = new Object();

		System.out.println(o == o2);
		System.out.println(o.equals(o2));

		System.out.println(Integer.toHexString(o.hashCode()));
		System.out.println(Integer.toHexString(o2.hashCode()));

		System.out.println(o.getClass().getName());

		System.out.println(o.toString());

		Empleado e = new Empleado("   Javier   ", "12345678Z", LocalDate.of(2000, 1, 2), "1234123412341234",
				new BigDecimal("1234.56"));

		Object oEmpleado = e;

		for (Field f : oEmpleado.getClass().getDeclaredFields()) {
			f.setAccessible(true);

			if (Modifier.isPrivate(f.getModifiers())) {
				System.out.print("private");
			}

			System.out.print(" ");
			System.out.print(f.getType().getSimpleName());
			System.out.print(" ");
			System.out.print(f.getName());
			System.out.print(" = ");
			System.out.print(f.get(oEmpleado));
			System.out.println();
		}

		Persona p = new Persona("Javier");
		Persona p2 = new Persona("Javier");

		System.out.println(p == p2);
		System.out.println(p.equals(p2));
		System.out.println(Integer.toHexString(p.hashCode()));
		System.out.println(Integer.toHexString(p2.hashCode()));

		System.out.println("Los datos de persona son " + p);

		String log = "Esto va a ser un histórico\n";

		for (int i = 1; i <= 10; i++) {
			log += "Línea " + i + '\n';
		}

		System.out.println(log);

		log = "Esto va a ser un histórico\n";

		for (int i = 1; i <= 10; i++) {
			log = new StringBuffer(log).append("Línea ").append(i).append('\n').toString();
		}

		System.out.println(log);
		
		StringBuffer logBuffer = new StringBuffer("Esto va a ser un histórico\n");
		
		for (int i = 1; i <= 10; i++) {
			logBuffer.append("Línea ").append(i).append('\n');
		}
		
		System.out.println(logBuffer);
	}
}
