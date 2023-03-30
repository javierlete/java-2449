package com.ipartek.formacion.ipartekzon.modelos;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vacacion {
	private Long id;
	private LocalDate fecha;
	private Empleado empleado;
}
