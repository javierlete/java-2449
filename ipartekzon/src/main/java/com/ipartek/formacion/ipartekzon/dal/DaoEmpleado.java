package com.ipartek.formacion.ipartekzon.dal;

import com.ipartek.formacion.ipartekzon.modelos.Empleado;
import com.ipartek.formacion.ipartekzon.modelos.Vacacion;

public interface DaoEmpleado extends Dao<Empleado> {
	void insertarVacacion(Vacacion vacacion);
}
