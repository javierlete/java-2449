package com.ipartek.formacion.ipartekzon.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "factura_detalles")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FacturaDetalle {
	@Id
	@ManyToOne
	private Factura factura;
	@Id
	@ManyToOne
	private Producto producto;
	
	@NotNull
	@Min(0)
	@Builder.Default
	private Integer cantidad = 1;
}
