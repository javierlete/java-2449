package com.ipartek.formacion.ipartekzon.modelos;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Producto {
	private Long id;
	private String codigo;
	private String nombre;
	private BigDecimal precio;
	private String descripcion;
}
