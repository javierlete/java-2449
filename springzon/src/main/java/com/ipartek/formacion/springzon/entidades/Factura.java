package com.ipartek.formacion.springzon.entidades;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "facturas")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(unique = true, columnDefinition = "CHAR(8)")
	@Pattern(regexp = "^\\d{8}$")
	private String codigo;
	
	@NotNull
	@PastOrPresent
	private LocalDate fecha;
	
	@NotNull
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Empleado empleado;
	
	@OneToMany(mappedBy = "factura")
	private Set<FacturaDetalle> detalles;
}
