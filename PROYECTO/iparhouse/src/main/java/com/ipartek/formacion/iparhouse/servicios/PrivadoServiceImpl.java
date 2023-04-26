package com.ipartek.formacion.iparhouse.servicios;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.iparhouse.entidades.Inmueble;
import com.ipartek.formacion.iparhouse.repositorios.InmuebleRepository;
import com.ipartek.formacion.iparhouse.repositorios.ServicioRepository;

@Service
public class PrivadoServiceImpl implements PrivadoService{
	@Autowired
	private InmuebleRepository repo;
	@Autowired
	private ServicioRepository repoServicio;
	
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
		repoServicio.deleteByInmuebleId(id);
		
		repo.deleteById(id);
	}

	@Override
	public Iterable<Inmueble> listadoOrdenado() {
		return repo.getByOrderByNombre();
	}

	@Override
	public Inmueble primeroConCocina() {
		return repo.primeroConCocina();
	}

	@Override
	public BigDecimal precioTotalAlquiler3Habitaciones() {
		// TODO: Precio total
		return new BigDecimal(12345678);
	}

	@Override
	public Iterable<String> listadoServicios() {
		return repoServicio.listadoNombreServicios();
	}
	
}
