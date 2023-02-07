package com.ipartek.formacion.pruebas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ipartek.formacion.poo.clasesabstractas.EmpleadoAbstracto;
import com.ipartek.formacion.poo.clasesabstractas.EmpleadoIndefinido;
import com.ipartek.formacion.poo.clasesabstractas.EmpleadoPorHoras;

public class EmpleadoAbstractoPrueba {
	public static void main(String[] args) {
		ArrayList<EmpleadoAbstracto> empleados = new ArrayList<>();
		
		empleados.add(new EmpleadoIndefinido(null, "Indefinidez", "12345678Z", LocalDate.of(2000, 2, 3), "1234-1234-1234-1234", 14, new BigDecimal("12345")));
		empleados.add(new EmpleadoPorHoras(null, "Porhorez", "87654321A", LocalDate.of(2002, 1, 3), "4321-4321-4321-4321", 50, new BigDecimal("20.5")));
		
		BigDecimal total = BigDecimal.ZERO;
		
		for(EmpleadoAbstracto empleado: empleados) {
			System.out.println(empleado.getSueldoMensual());
			total = total.add(empleado.getSueldoMensual());
		}
		
		System.out.println("Total: " + total);
	}
}
