package com.ipartek.formacion.iparhouse.servicios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.iparhouse.entidades.Inmueble;
import com.ipartek.formacion.iparhouse.repositorios.InmuebleRepository;

@Service
public class PrivadoServiceImpl implements PrivadoService{
	@Autowired
	private InmuebleRepository repo;
	
	@Override
	public Inmueble insertar(Inmueble inmueble) {
		return repo.save(inmueble);
	}

	@Override
	public Inmueble modificar(Inmueble inmueble) {
		return repo.save(inmueble);
	}

	@Override
	public void borrar(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Iterable<Inmueble> listadoOrdenado() {
		return repo.getByOrderByNombre();
	}

	@Override
	public Inmueble primeroConCocina() {
		// TODO: Primero con cocina 
		Inmueble inmueble1 = Inmueble.builder().id(1L).nombre("Casa en la playa superchula").direccion("Calle 123")
				.tipo("Alquiler").precio(new BigDecimal("1500.00")).build();
		return inmueble1;
	}

	@Override
	public BigDecimal precioTotalAlquiler3Habitaciones() {
		// TODO: Precio total
		return new BigDecimal(12345678);
	}

	@Override
	public Iterable<String> listadoServicios() {
		// TODO: listado servicios
		List<String> servicios = new ArrayList<>();
		
		servicios.add("Uno");
		servicios.add("Dos");
		servicios.add("Tres");
		
		return servicios;
	}
	
}
