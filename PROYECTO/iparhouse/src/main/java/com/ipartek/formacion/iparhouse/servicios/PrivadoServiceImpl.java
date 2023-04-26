package com.ipartek.formacion.iparhouse.servicios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.iparhouse.entidades.Inmueble;

@Service
public class PrivadoServiceImpl implements PrivadoService{

	@Override
	public Inmueble insertar(Inmueble inmueble) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inmueble modificar(Inmueble inmueble) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Inmueble> listadoOrdenado() {
		List<Inmueble> inmuebles = new ArrayList<>();

		Inmueble inmueble1 = Inmueble.builder().id(1L).nombre("Casa en la playa superchula").direccion("Calle 123")
				.tipo("Alquiler").precio(new BigDecimal("1500.00")).build();

		Inmueble inmueble2 = Inmueble.builder().id(2L).nombre("Apartamento en la ciudad").direccion("Avenida 456")
				.tipo("Venta").precio(new BigDecimal("200000.00")).build();

		inmuebles.add(inmueble2);
		inmuebles.add(inmueble1);
		
		return inmuebles;
	}

	@Override
	public Inmueble primeroConCocina() {
		Inmueble inmueble1 = Inmueble.builder().id(1L).nombre("Casa en la playa superchula").direccion("Calle 123")
				.tipo("Alquiler").precio(new BigDecimal("1500.00")).build();
		return inmueble1;
	}

	@Override
	public BigDecimal precioTotalAlquiler3Habitaciones() {
		return new BigDecimal(12345678);
	}

	@Override
	public Iterable<String> listadoServicios() {
		List<String> servicios = new ArrayList<>();
		
		servicios.add("Uno");
		servicios.add("Dos");
		servicios.add("Tres");
		
		return servicios;
	}
	
}
