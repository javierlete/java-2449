package com.ipartek.formacion.poo.clasesabstractas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class EmpleadoIndefinido extends EmpleadoAbstracto {
	private static final long serialVersionUID = 5926531866573931859L;
	
	private Integer numeroPagas;
	private BigDecimal sueldoAnual;
	
	public EmpleadoIndefinido(Long id, String nombre, String dni, LocalDate fechaNacimiento,
			String numeroSeguridadSocial, Integer numeroPagas, BigDecimal sueldoAnual) {
		super(id, nombre, dni, fechaNacimiento, numeroSeguridadSocial);
		
		setNumeroPagas(numeroPagas);
		setSueldoAnual(sueldoAnual);
	}
	
	public Integer getNumeroPagas() {
		return numeroPagas;
	}
	public void setNumeroPagas(Integer numeroPagas) {
		this.numeroPagas = numeroPagas;
	}
	public BigDecimal getSueldoAnual() {
		return sueldoAnual;
	}
	public void setSueldoAnual(BigDecimal sueldoAnual) {
		this.sueldoAnual = sueldoAnual;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoAnual.divide(new BigDecimal(numeroPagas), 2, RoundingMode.HALF_UP);
	}
	
	
}
