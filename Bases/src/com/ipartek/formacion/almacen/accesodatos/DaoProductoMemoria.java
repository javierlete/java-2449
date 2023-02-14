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
		if(id == null) {
			throw new AccesoDatosException("No se admite buscar un id nulo");
		}
		
		return productos.get(id);
	}

	@Override
	public Producto insertar(Producto producto) {
		if(producto.getId() != null) {
			throw new AccesoDatosException("No se puede pasar un id para un nuevo registro");
		}
		
		Long id = productos.size() > 0 ? productos.lastKey() + 1L: 1L;
		
		producto.setId(id);
		
		productos.put(id, producto);
		
		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		if(obtenerPorId(producto.getId())== null) {
			throw new AccesoDatosException("No se puede modificar un producto que no existe");
		}
		
		productos.put(producto.getId(), producto);
		
		return producto;
	}

	@Override
	public void borrar(Long id) {
		if(obtenerPorId(id)== null) {
			throw new AccesoDatosException("No se puede borrar un producto que no existe");
		}
		
		productos.remove(id);
	}

}
