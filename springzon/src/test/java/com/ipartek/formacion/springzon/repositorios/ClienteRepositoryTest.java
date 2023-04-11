package com.ipartek.formacion.springzon.repositorios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipartek.formacion.springzon.entidades.Cliente;

@SpringBootTest
class ClienteRepositoryTest {
	@Autowired
	private ClienteRepository repo;
	
	@Test
	void insertar() {
		Cliente cliente = Cliente.builder().nombre("Pepe").nif("12345678Z").build();
		repo.save(cliente);
		
		Cliente recibido = repo.findById(1L).orElse(null);
		
		assertNotNull(recibido);
		assertEquals(cliente, recibido);
	}
}
