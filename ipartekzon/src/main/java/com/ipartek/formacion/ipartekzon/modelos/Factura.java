package com.ipartek.formacion.ipartekzon.modelos;

import java.time.LocalDate;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Factura {
	private Long id;
	private String codigo;
	private LocalDate fecha;
	
	private Cliente cliente;
	
	private Set<FacturaDetalle> detalles;
}
