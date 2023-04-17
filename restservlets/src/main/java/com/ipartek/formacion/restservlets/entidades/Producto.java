package com.ipartek.formacion.restservlets.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private LocalDate garantia;
}
