package com.ipartek.formacion.ipartekzon.logicanegocio;

import com.ipartek.formacion.ipartekzon.modelos.Empleado;
import java.util.Map;

public interface EmpleadoNegocio {
	Iterable<Empleado> listado();
	Empleado obtenerPorId(Long id);
	Empleado cambiar(Empleado empleado);
	Empleado nuevo(Empleado empleado);
	Map<String, String> obtenerUltimosErrores();
	void eliminar(Long id);
}
