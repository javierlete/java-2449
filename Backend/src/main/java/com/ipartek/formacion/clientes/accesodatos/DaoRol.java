package com.ipartek.formacion.clientes.accesodatos;

import com.ipartek.formacion.clientes.modelos.Rol;

public interface DaoRol extends Dao<Rol> {
	default Rol insertar(Rol entidad) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default Rol modificar(Rol entidad) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default void borrar(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}
