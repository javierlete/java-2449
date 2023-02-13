package com.ipartek.formacion.almacen.accesodatos;

import java.util.TreeMap;

import com.ipartek.formacion.almacen.entidades.Producto;

public class DaoProductoMemoria implements Dao<Producto> {

	private TreeMap<Long, Producto> productos = new TreeMap<>();
	
	DaoProductoMemoria() {}
	
	DaoProductoMemoria(TreeMap<Long, Producto> productos) {
		this.productos = productos;
	}
	
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
