package com.ipartek.formacion.ipartekzon.modelos;

import lombok.Builder;
import lombok.Data;
import java.util.Set;

@Data
@Builder
public class Cliente {
	private Long id;
	private String nif;
	private String nombre;
	
	private Set<Factura> facturas;
}
