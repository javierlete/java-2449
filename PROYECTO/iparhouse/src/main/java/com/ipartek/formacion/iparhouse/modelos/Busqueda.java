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
	
	@Builder.Default
	private String tipo = "Todas";
	
	@Builder.Default
	private BigDecimal minimo = BigDecimal.ZERO;
	
	private BigDecimal maximo;
}
