package com.ipartek.formacion.poo.clasesabstractas;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmpleadoPorHoras extends EmpleadoAbstracto {
	private static final long serialVersionUID = -8856245269494026000L;
	
	private Integer numeroHoras;
	private BigDecimal precioHora;
	
	public EmpleadoPorHoras(Long id, String nombre, String dni, LocalDate fechaNacimiento, String numeroSeguridadSocial,
			Integer numeroHoras, BigDecimal precioHora) {
		super(id, nombre, dni, fechaNacimiento, numeroSeguridadSocial);
		
		setNumeroHoras(numeroHoras);
		setPrecioHora(precioHora);
	}
	
	public Integer getNumeroHoras() {
		return numeroHoras;
	}
	public void setNumeroHoras(Integer numeroHoras) {
		this.numeroHoras = numeroHoras;
	}
	public BigDecimal getPrecioHora() {
		return precioHora;
	}
	public void setPrecioHora(BigDecimal precioHora) {
		this.precioHora = precioHora;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return precioHora.multiply(new BigDecimal(numeroHoras));
	}
	
	
}
