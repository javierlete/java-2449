package com.ipartek.formacion.iparhouse.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ipartek.formacion.iparhouse.entidades.Servicio;

public interface ServicioRepository extends CrudRepository<Servicio, Long> {
	@Transactional
	void deleteByInmuebleId(Long idInmueble);
	@Query("select distinct s.nombre from Servicio s")
	Iterable<String> listadoNombreServicios();  
}
