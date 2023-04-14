package com.ipartek.formacion.springzon.servicios;

import java.math.BigDecimal;
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
	private EmpleadoRepository repo;
	
	@Autowired
	private VacacionRepository repoVacacion;
	
	public EmpleadoServiceImpl(EmpleadoRepository repo) {
		this.repo = repo;
		
		Empleado jefazo = Empleado.builder().nif("11111111A").nombre("JEFAZO").sueldo(new BigDecimal(123456)).build();
		repo.save(jefazo);

		Empleado jefe = Empleado.builder().nif("22222222A").nombre("Jefe Intermedio").sueldo(new BigDecimal(54321)).build();
		repo.save(jefe);
		
		Empleado empleado1 = Empleado.builder().nif("33333333A").nombre("Empleadillo").sueldo(new BigDecimal(12345)).build();
		repo.save(empleado1);

		Empleado enchufado = Empleado.builder().nif("44444444A").nombre("Enchufado").sueldo(new BigDecimal(23456)).build();
		repo.save(enchufado);
		
		Empleado e1 = repo.findById(1L).orElse(null);
		Empleado e2 = repo.findById(2L).orElse(null);
		Empleado e3 = repo.findById(3L).orElse(null);
		Empleado e4 = repo.findById(4L).orElse(null);
		
		e2.setJefe(e1);
		e3.setJefe(e2);
		e4.setJefe(e1);
		
//		dao.insertarVacacion(Vacacion.builder().fecha(LocalDate.of(2024, 1, 1)).empleado(e1).build());
//		dao.insertarVacacion(Vacacion.builder().fecha(LocalDate.of(2024, 1, 2)).empleado(e1).build());
//		dao.insertarVacacion(Vacacion.builder().fecha(LocalDate.of(2024, 1, 3)).empleado(e1).build());
//		dao.insertarVacacion(Vacacion.builder().fecha(LocalDate.of(2024, 1, 4)).empleado(e1).build());
//		
//		dao.modificar(e1);
//		
//		dao.modificar(e2);
//		dao.modificar(e3);
//		dao.modificar(e4);

	}
	
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
