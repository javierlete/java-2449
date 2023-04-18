package com.ipartek.formacion.springzon.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.springzon.entidades.Vacacion;

@RepositoryRestResource(path = "vacaciones", collectionResourceRel = "vacaciones")
public interface VacacionRepository extends CrudRepository<Vacacion, Long> {

}
