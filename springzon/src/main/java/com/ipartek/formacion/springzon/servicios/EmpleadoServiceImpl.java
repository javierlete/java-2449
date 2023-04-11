package com.ipartek.formacion.springzon.servicios;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.springzon.entidades.Empleado;
import com.ipartek.formacion.springzon.entidades.Vacacion;
import com.ipartek.formacion.springzon.repositorios.EmpleadoRepository;
import com.ipartek.formacion.springzon.repositorios.VacacionRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	@Autowired
	private EmpleadoRepository repo;
	
	@Autowired
	private VacacionRepository repoVacacion;
	
	@Override
	public Iterable<Empleado> listado() {
		return repo.findAll();
	}

	@Override
	public Empleado obtenerPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Empleado cambiar(Empleado empleado) {
		return repo.save(empleado);
	}

	@Override
	public Empleado nuevo(Empleado empleado) {
		return repo.save(empleado);
	}

	@Override
	public Map<String, String> obtenerUltimosErrores() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
	}

	@Override
	public void agregarVacacion(Long idEmpleado, LocalDate fecha) {
		Empleado empleado = Empleado.builder().id(idEmpleado).build();
		Vacacion vacacion = Vacacion.builder().empleado(empleado).fecha(fecha).build();
		
		repoVacacion.save(vacacion);
	}
	
}
