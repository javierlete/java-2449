package com.ipartek.formacion.ipartekzon.dal;

import com.ipartek.formacion.ipartekzon.modelos.Empleado;

public class DaoEmpleadoJpa implements DaoEmpleado, DaoJpa {
	@Override
	public Iterable<Empleado> obtenerTodos() {
		return llamarJpa(em -> em.createQuery("from Empleado", Empleado.class).getResultList());
	}

	@Override
	public Empleado obtenerPorId(Long id) {
		return llamarJpa(em -> em.find(Empleado.class, id));
	}

	@Override
	public Empleado insertar(Empleado empleado) {
		return llamarJpa(em -> em.merge(empleado));
	}

	@Override
	public Empleado modificar(Empleado empleado) {
		return llamarJpa(em -> em.merge(empleado));
	}

	@Override
	public void borrar(Long id) {
		llamarJpa(em -> {
			em.remove(em.find(Empleado.class, id));
			return null;
		});
	}
}
