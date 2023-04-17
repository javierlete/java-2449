package com.ipartek.formacion.springzon.controladores.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.springzon.entidades.Cliente;
import com.ipartek.formacion.springzon.servicios.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesApiController {
	@Autowired
	private ClienteService servicio;
	
	@GetMapping
	public Iterable<Cliente> get() {
		return servicio.listado();
	}
	
	@GetMapping("/{id}")
	public Cliente getId(@PathVariable Long id) {
		return servicio.consultarPorId(id);
	}
	
	@PostMapping
	public Cliente post(@RequestBody Cliente cliente) {
		servicio.nuevo(cliente);
		return cliente;
	}
	
	@PutMapping("/{id}")
	public Cliente put(@RequestBody Cliente cliente) {
		servicio.cambiar(cliente);
		return cliente;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		servicio.eliminar(id);
	}
}
