package com.ipartek.formacion.almacen.accesodatos;

// Data
// Access
// Object
interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	T insertar(T entidad);
	T modificar(T entidad);
	void borrar(Long id);
}
