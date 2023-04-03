package com.ipartek.formacion.ipartekzon.logicanegocio;

import java.util.Map;

import com.ipartek.formacion.ipartekzon.modelos.Cliente;

public interface ClienteNegocio {
	Iterable<Cliente> listado();
	Cliente consultarPorId(Long id);
	Cliente consultarPorNif(String nif);
	
	Cliente nuevo(Cliente cliente);
	Cliente cambiar(Cliente cliente);
	void eliminar(Long id);
	
	Map<String, String> obtenerUltimosErrores();
}
