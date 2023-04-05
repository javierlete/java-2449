package com.ipartek.formacion.ipartekzon.modelos;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "empleados")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Empleado jefe;
	
	@NotNull
	@Column(columnDefinition = "CHAR(9)")
	@Pattern(regexp = "^[XYZ\\d]\\d{7}[A-Z]$")
	private String nif;
	
	@NotNull
	@Size(min = 2, max = 50)
	private String nombre;
	
	@NotNull
	@Min(0)
	private BigDecimal sueldo;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "empleado")
	private Set<Vacacion> vacaciones;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "jefe")
	private Set<Empleado> empleados;
	
}
