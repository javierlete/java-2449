package com.ipartek.formacion.iparhouse.servicios;

import java.math.BigDecimal;

import com.ipartek.formacion.iparhouse.entidades.Inmueble;

public interface PrivadoService {
	Inmueble insertar(Inmueble inmueble);
	Inmueble modificar(Inmueble inmueble);
	void borrar(Long id);
	
	Iterable<Inmueble> listadoOrdenado();
	Inmueble primeroConCocina();
	BigDecimal precioTotalAlquiler3Habitaciones();
	Iterable<String> listadoServicios();
}
