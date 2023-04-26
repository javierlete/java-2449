package com.ipartek.formacion.iparhouse.servicios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.iparhouse.entidades.Inmueble;
import com.ipartek.formacion.iparhouse.modelos.Busqueda;

@Service
public class PublicoServiceImpl implements PublicoService {

	@Override
	public Iterable<Inmueble> listado() {
		List<Inmueble> inmuebles = new ArrayList<>();

		Inmueble inmueble1 = Inmueble.builder().id(1L).nombre("Casa en la playa superchula").direccion("Calle 123")
				.tipo("Alquiler").precio(new BigDecimal("1500.00")).build();

		Inmueble inmueble2 = Inmueble.builder().id(2L).nombre("Apartamento en la ciudad").direccion("Avenida 456")
				.tipo("Venta").precio(new BigDecimal("200000.00")).build();

		inmuebles.add(inmueble1);
		inmuebles.add(inmueble2);
		
		return inmuebles;
	}

	@Override
	public Iterable<Inmueble> listado(Busqueda busqueda) {
		List<Inmueble> inmuebles = new ArrayList<>();

		Inmueble inmueble1 = Inmueble.builder().id(1L).nombre("Casa en la playa").direccion("Calle 123")
				.tipo("Alquiler").precio(new BigDecimal("1500.00")).build();

		inmuebles.add(inmueble1);
		
		return inmuebles;
	}

	@Override
	public Inmueble detalle(Long id) {
		Inmueble inmueble2 = Inmueble.builder().id(2L).nombre("Apartamento en la ciudad de lujo").direccion("Avenida 456")
				.tipo("Venta").precio(new BigDecimal("200000.00")).build();
		return inmueble2;
	}

}
