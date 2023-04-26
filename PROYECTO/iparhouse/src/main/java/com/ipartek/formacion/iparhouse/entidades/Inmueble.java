package com.ipartek.formacion.iparhouse.entidades;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Inmueble {
	private Long id;
	private String nombre;
	private String direccion;
	private String tipo; // Alquiler o Venta
	private BigDecimal precio;
}
