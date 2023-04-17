package com.ipartek.formacion.restservlets.servicios;

import com.ipartek.formacion.restservlets.entidades.Producto;

import java.util.TreeMap;

public class ProductoServicioImpl implements ProductoServicio {
	private TreeMap<Long, Producto> productos = new TreeMap<>();
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		return productos.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return productos.get(id);
	}

	@Override
	public Producto insertar(Producto producto) {
		Long id = productos.size() > 0 ? productos.lastKey() + 1L: 1L;
		producto.setId(id);
		
		productos.put(id, producto);
		
		return producto;
	}
	
	@Override
	public Producto modificar(Producto producto) {
		productos.put(producto.getId(), producto);
		return producto;
	}

	@Override
	public void borrar(Long id) {
		productos.remove(id);
	}
	
}
