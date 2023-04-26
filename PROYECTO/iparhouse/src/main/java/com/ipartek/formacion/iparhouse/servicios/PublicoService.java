package com.ipartek.formacion.iparhouse.servicios;

import com.ipartek.formacion.iparhouse.entidades.Inmueble;
import com.ipartek.formacion.iparhouse.modelos.Busqueda;

public interface PublicoService {
	Iterable<Inmueble> listado();
	Iterable<Inmueble> listado(Busqueda busqueda);
	Inmueble detalle(Long id);
}
