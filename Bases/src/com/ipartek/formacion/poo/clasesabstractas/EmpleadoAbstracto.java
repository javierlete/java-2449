package com.ipartek.formacion.poo.clasesabstractas;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.poo.Persona;

public abstract class EmpleadoAbstracto extends Persona {
	private static final long serialVersionUID = -2891442279362904541L;
	
	private String numeroSeguridadSocial;
	
	public EmpleadoAbstracto(Long id, String nombre, String dni, LocalDate fechaNacimiento,
			String numeroSeguridadSocial) {
		super(id, nombre, dni, fechaNacimiento);
		setNumeroSeguridadSocial(numeroSeguridadSocial);
	}

	public abstract BigDecimal getSueldoMensual();

	public String getNumeroSeguridadSocial() {
		return numeroSeguridadSocial;
	}

	public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
		this.numeroSeguridadSocial = numeroSeguridadSocial;
	}
}
