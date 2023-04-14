package com.ipartek.formacion.springzon.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.springzon.entidades.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
	@Query("from Empleado e left join fetch e.jefe")
	Iterable<Empleado> obtenerEmpleadosConJefes();
	
	@Query(value = "SELECT * FROM empleados ORDER BY id DESC LIMIT 3", nativeQuery = true)
	Iterable<Empleado> obtenerUltimosEmpleados();
}
