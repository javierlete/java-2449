package com.ipartek.formacion.iparhouse.servicios;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.iparhouse.entidades.Inmueble;
import com.ipartek.formacion.iparhouse.entidades.Servicio;
import com.ipartek.formacion.iparhouse.modelos.Busqueda;
import com.ipartek.formacion.iparhouse.repositorios.InmuebleRepository;
import com.ipartek.formacion.iparhouse.repositorios.ServicioRepository;

@Service
public class PublicoServiceImpl implements PublicoService {

	private InmuebleRepository repo;
	private ServicioRepository repoServicio;

	public PublicoServiceImpl(InmuebleRepository repo, ServicioRepository repoServicio) {
		this.repo = repo;
		this.repoServicio = repoServicio;
		
		Inmueble inmueble1 = Inmueble.builder().nombre("Casa en la playa superchula").direccion("Calle 123")
				.tipo("Alquiler").precio(new BigDecimal("1500.00")).build();

		Inmueble inmueble2 = Inmueble.builder().nombre("Apartamento en la ciudad").direccion("Avenida 456")
				.tipo("Venta").precio(new BigDecimal("200000.00")).build();
		
		repo.save(inmueble1);
		repo.save(inmueble2);
		
		Servicio servicio1 = Servicio.builder().nombre("Habitaciones").cantidad(3).inmueble(inmueble1).build();
		Servicio servicio2 = Servicio.builder().nombre("Baños").cantidad(2).inmueble(inmueble1).build();
		Servicio servicio3 = Servicio.builder().nombre("Habitaciones").cantidad(2).inmueble(inmueble2).build();

		repoServicio.save(servicio1);
		repoServicio.save(servicio2);
		repoServicio.save(servicio3);
	}
	
	
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
