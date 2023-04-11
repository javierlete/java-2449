package com.ipartek.formacion.springzon.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.springzon.entidades.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	Cliente findByNif(String nif);
}
