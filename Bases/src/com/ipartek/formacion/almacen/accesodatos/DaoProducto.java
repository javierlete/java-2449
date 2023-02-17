package com.ipartek.formacion.almacen.accesodatos;

import java.math.BigDecimal;

import com.ipartek.formacion.almacen.entidades.Producto;

public interface DaoProducto extends Dao<Producto> {
	Iterable<Producto> buscarPorNombre(String nombre);
	Iterable<Producto> buscarPorRangoPrecio(BigDecimal inferior, BigDecimal superior);
}
