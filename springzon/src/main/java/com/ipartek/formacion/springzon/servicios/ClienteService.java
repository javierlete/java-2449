package com.ipartek.formacion.springzon.servicios;

import java.util.Map;

import com.ipartek.formacion.springzon.entidades.Cliente;

public interface ClienteService {
	Iterable<Cliente> listado();
	Cliente consultarPorId(Long id);
	Cliente consultarPorNif(String nif);
	
	Cliente nuevo(Cliente cliente);
	Cliente cambiar(Cliente cliente);
	void eliminar(Long id);
	
	Map<String, String> obtenerUltimosErrores();
}
