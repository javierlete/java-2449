package com.ipartek.formacion.springzon.servicios;

import java.time.LocalDate;
import java.util.Map;

import com.ipartek.formacion.springzon.entidades.Empleado;

public interface EmpleadoService {
	Iterable<Empleado> listado();
	Empleado obtenerPorId(Long id);
	Empleado cambiar(Empleado empleado);
	Empleado nuevo(Empleado empleado);
	Map<String, String> obtenerUltimosErrores();
	void eliminar(Long id);
	void agregarVacacion(Long idEmpleado, LocalDate fecha);
	
	Iterable<Empleado> recibirUltimos();
}
