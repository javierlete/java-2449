package com.ipartek.formacion.iparhouse.servicios;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.iparhouse.entidades.Inmueble;
import com.ipartek.formacion.iparhouse.modelos.Busqueda;
import com.ipartek.formacion.iparhouse.repositorios.InmuebleRepository;

@Service
public class PublicoServiceImpl implements PublicoService {

	public PublicoServiceImpl(InmuebleRepository repo) {
		this.repo = repo;
		
		Inmueble inmueble1 = Inmueble.builder().id(1L).nombre("Casa en la playa superchula").direccion("Calle 123")
				.tipo("Alquiler").precio(new BigDecimal("1500.00")).build();

		Inmueble inmueble2 = Inmueble.builder().id(2L).nombre("Apartamento en la ciudad").direccion("Avenida 456")
				.tipo("Venta").precio(new BigDecimal("200000.00")).build();

		repo.save(inmueble1);
		repo.save(inmueble2);
	}
	
	private InmuebleRepository repo;
	
	@Override
	public Iterable<Inmueble> listado() {
		return repo.findAll();
	}

	@Override
	public Iterable<Inmueble> listado(Busqueda busqueda) {
		// TODO Sustituir por el de búsqueda real
		return repo.findAll();
	}

	@Override
	public Inmueble detalle(Long id) {
		return repo.findById(id).orElse(null);
	}

}
