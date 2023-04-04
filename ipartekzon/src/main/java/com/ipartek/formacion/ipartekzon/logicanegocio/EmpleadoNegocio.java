package com.ipartek.formacion.ipartekzon.logicanegocio;

import com.ipartek.formacion.ipartekzon.modelos.Empleado;

public interface EmpleadoNegocio {
	Iterable<Empleado> listado();
	Empleado obtenerPorId(Long id);
}
