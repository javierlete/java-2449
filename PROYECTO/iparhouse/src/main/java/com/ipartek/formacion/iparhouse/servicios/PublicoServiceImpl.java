package com.ipartek.formacion.iparhouse.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.iparhouse.entidades.Inmueble;
import com.ipartek.formacion.iparhouse.entidades.Servicio;
import com.ipartek.formacion.iparhouse.modelos.Busqueda;
import com.ipartek.formacion.iparhouse.repositorios.InmuebleRepository;
import com.ipartek.formacion.iparhouse.repositorios.ServicioRepository;

@Service
public class PublicoServiceImpl implements PublicoService {
	@Autowired
	private InmuebleRepository repo;
	
	@Autowired
	private ServicioRepository repoServicio;

//	public PublicoServiceImpl(InmuebleRepository repo, ServicioRepository repoServicio) {
//		this.repo = repo;
//		
//		Inmueble inmueble1 = Inmueble.builder().nombre("Casa en la playa superchula").direccion("Calle 123")
//				.tipo("Alquiler").precio(new BigDecimal("1500.00")).build();
//
//		Inmueble inmueble2 = Inmueble.builder().nombre("Apartamento en la ciudad").direccion("Avenida 456")
//				.tipo("Venta").precio(new BigDecimal("200000.00")).build();
//		
//		Inmueble inmueble3 = Inmueble.builder().nombre("Casa en la ciudad superchula").direccion("Calle 123")
//				.tipo("Alquiler").precio(new BigDecimal("2000.00")).build();
//		
//		repo.save(inmueble1);
//		repo.save(inmueble2);
//		repo.save(inmueble3);
//		
//		Servicio servicio1 = Servicio.builder().nombre("Habitaciones").cantidad(3).inmueble(inmueble1).build();
//		Servicio servicio2 = Servicio.builder().nombre("Baños").cantidad(2).inmueble(inmueble1).build();
//		Servicio servicio3 = Servicio.builder().nombre("Cocinas").cantidad(2).inmueble(inmueble2).build();
//		Servicio servicio4 = Servicio.builder().nombre("Habitaciones").cantidad(3).inmueble(inmueble3).build();
//		
//		
//		repoServicio.save(servicio1);
//		repoServicio.save(servicio2);
//		repoServicio.save(servicio3);
//		repoServicio.save(servicio4);
//	}
	
	
	@Override
	public Iterable<Inmueble> listado() {
		return repo.findAll();
	}

	@Override
	public Iterable<Inmueble> listado(Busqueda busqueda) {
		return repo.buscar("%" + busqueda.getNombreODireccion() + "%", busqueda.getTipo(), busqueda.getMinimo(), busqueda.getMaximo());
	}

	@Override
	public Inmueble detalle(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Iterable<Servicio> serviciosDeInmueble(Long id) {
		return repoServicio.findByInmuebleId(id);
	}

}
