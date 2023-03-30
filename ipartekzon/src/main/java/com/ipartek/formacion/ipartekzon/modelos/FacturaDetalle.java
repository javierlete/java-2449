package com.ipartek.formacion.ipartekzon.modelos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FacturaDetalle {
	private Producto producto;
	private Integer cantidad;
}
