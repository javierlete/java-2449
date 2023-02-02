package com.ipartek.formacion.poo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Empleado extends Persona {
	private String numeroSeguridadSocial;
	private BigDecimal sueldoMensual;
	
	public Empleado(Long id, String nombre, String dni, LocalDate fechaNacimiento, String numeroSeguridadSocial,
			BigDecimal sueldoMensual) {
		super(id, nombre, dni, fechaNacimiento);
		
		setNumeroSeguridadSocial(numeroSeguridadSocial);
		setSueldoMensual(sueldoMensual);
	}

	public Empleado(String nombre, String dni, LocalDate fechaNacimiento, String numeroSeguridadSocial,
			BigDecimal sueldoMensual) {
		this(null, nombre, dni, fechaNacimiento, numeroSeguridadSocial, sueldoMensual);
	}
//	public Empleado() {
//		super();
//	}

	
	
	@Override
	public void setDni(String dni) {
		if(dni == null) {
			throw new IllegalArgumentException("Un empleado debe tener número de DNI");
		}
		
		super.setDni(dni);
	}

	@Override
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento == null) {
			throw new IllegalArgumentException("Es obligatorio saber la fecha de nacimiento de un empleado");
		}
		
		super.setFechaNacimiento(fechaNacimiento);
		
		if(!isMayorDeEdad()) {
			throw new IllegalArgumentException("La persona debe ser mayor de edad para poder ser empleado");
		}
	}

	public String getNumeroSeguridadSocial() {
		return numeroSeguridadSocial;
	}

	public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
		if(numeroSeguridadSocial == null) {
			throw new IllegalArgumentException("Se necesita un número de la seguridad social");
		}
		
		this.numeroSeguridadSocial = numeroSeguridadSocial;
	}

	public BigDecimal getSueldoMensual() {
		return sueldoMensual;
	}

	public void setSueldoMensual(BigDecimal sueldoMensual) {
		if(sueldoMensual == null) {
			throw new IllegalArgumentException("Se necesita el sueldo mensual del empleado");
		}
		
		if(sueldoMensual.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("El sueldo mensual debe ser mayor o igual que 0");
		}
		
		this.sueldoMensual = sueldoMensual;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + getId() + ", nombre=" + getNombre() + ", dni=" + getDni() + ", fechaNacimiento="
				+ getFechaNacimiento() + ", numeroSeguridadSocial=" + numeroSeguridadSocial + ", sueldoMensual="
				+ sueldoMensual + "]";
	}
}
