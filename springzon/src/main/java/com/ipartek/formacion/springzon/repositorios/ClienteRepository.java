package com.ipartek.formacion.springzon.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.springzon.entidades.Cliente;

@RepositoryRestResource(path = "clientes", collectionResourceRel = "clientes")
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	Cliente findByNif(String nif);
}
