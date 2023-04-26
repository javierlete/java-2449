package com.ipartek.formacion.iparhouse.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.iparhouse.entidades.Inmueble;

@RepositoryRestResource(path = "inmuebles", collectionResourceRel = "inmuebles")
public interface InmuebleRepository extends CrudRepository<Inmueble, Long> {
	Iterable<Inmueble> getByOrderByNombre();
	// Inmueble primeroConCocina();
	// BigDecimal precioTotalAlquiler3Habitaciones();
	// Iterable<String> listadoServicios();
}
