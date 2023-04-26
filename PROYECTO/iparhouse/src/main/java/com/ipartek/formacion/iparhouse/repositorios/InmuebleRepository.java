package com.ipartek.formacion.iparhouse.repositorios;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.iparhouse.entidades.Inmueble;

@RepositoryRestResource(path = "inmuebles", collectionResourceRel = "inmuebles")
public interface InmuebleRepository extends CrudRepository<Inmueble, Long> {
	Iterable<Inmueble> getByOrderByNombre();
	@Query("from Inmueble i where i.nombre like ?1 and (?2 = 'Todas' or i.tipo = ?2) and (?4 = null or (i.precio between ?3 and ?4))")
	Iterable<Inmueble> buscar(String nombreODireccion, String tipo, BigDecimal minimo, BigDecimal maximo);
	// Inmueble primeroConCocina();
	// BigDecimal precioTotalAlquiler3Habitaciones();
	// Iterable<String> listadoServicios();
}
