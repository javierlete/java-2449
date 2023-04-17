package com.ipartek.formacion.restservlets.servicios;

import java.util.TreeMap;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.restservlets.entidades.Producto;

public class ProductoServicioImpl implements ProductoServicio {
	private TreeMap<Long, Producto> productos = new TreeMap<>();
	
	public ProductoServicioImpl() {
		productos.put(1L, Producto.builder().id(1L).nombre("Producto1").precio(new BigDecimal(12345)).garantia(LocalDate.of(2024, 1, 1)).build());
		productos.put(2L, Producto.builder().id(2L).nombre("Producto2").precio(new BigDecimal(2345)).garantia(LocalDate.of(2024, 1, 2)).build());
		productos.put(3L, Producto.builder().id(3L).nombre("Producto3").precio(new BigDecimal(345)).garantia(LocalDate.of(2024, 1, 3)).build());
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
