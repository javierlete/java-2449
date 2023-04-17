package com.ipartek.formacion.restservlets.servicios;

import com.ipartek.formacion.restservlets.entidades.Producto;

public interface ProductoServicio {
	Iterable<Producto> obtenerTodos();
	Producto obtenerPorId(Long id);
	
	Producto insertar(Producto producto);
	Producto modificar(Producto producto);
	void borrar(Long id);
}
