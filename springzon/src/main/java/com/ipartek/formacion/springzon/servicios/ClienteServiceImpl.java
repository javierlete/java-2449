package com.ipartek.formacion.springzon.servicios;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.springzon.entidades.Cliente;
import com.ipartek.formacion.springzon.repositorios.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	private ClienteRepository repo;

	public ClienteServiceImpl(ClienteRepository repo) {
		repo.save(Cliente.builder().nombre("Javier").nif("12345678Z").build());
		repo.save(Cliente.builder().nombre("Pepe").nif("87654321A").build());
		repo.save(Cliente.builder().nombre("Pedro").nif("14253647A").build());
		
		this.repo = repo;
	}
	
	@Override
	public Iterable<Cliente> listado() {
		return repo.findAll();
	}

	@Override
	public Cliente consultarPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Cliente consultarPorNif(String nif) {
		return repo.findByNif(nif);
	}

	@Override
	public Cliente nuevo(Cliente cliente) {
		return repo.save(cliente);
	}

	@Override
	public Cliente cambiar(Cliente cliente) {
		return repo.save(cliente);
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Map<String, String> obtenerUltimosErrores() {
		throw new UnsupportedOperationException();
	}

}
