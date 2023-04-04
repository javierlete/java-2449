package com.ipartek.formacion.ipartekzon.modelos;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(unique = true, columnDefinition = "CHAR(8)")
	private String codigo;
	
	@NotNull
	@Size(min=2, max=50)
	private String nombre;
	
	@NotNull
	@Min(0)
	private BigDecimal precio;
	
	@Lob
	private String descripcion;
}
