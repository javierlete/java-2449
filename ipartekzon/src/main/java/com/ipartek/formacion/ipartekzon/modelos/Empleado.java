package com.ipartek.formacion.ipartekzon.modelos;

import java.math.BigDecimal;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Empleado {
	private Long id;
	private Empleado jefe;
	private String nif;
	private String nombre;
	private BigDecimal sueldo;
	
	private Set<Vacacion> vacaciones;
}
