package com.ipartek.formacion.iparhouse.modelos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Busqueda {
	private String nombreODireccion;
	private String tipo;
	private BigDecimal minimo;
	private BigDecimal maximo;
}
