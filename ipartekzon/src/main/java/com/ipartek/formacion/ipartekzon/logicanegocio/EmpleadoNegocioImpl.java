package com.ipartek.formacion.ipartekzon.logicanegocio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.ipartek.formacion.ipartekzon.dal.DaoEmpleado;
import com.ipartek.formacion.ipartekzon.dal.DaoEmpleadoJpa;
import com.ipartek.formacion.ipartekzon.modelos.Empleado;
import com.ipartek.formacion.ipartekzon.modelos.Vacacion;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class EmpleadoNegocioImpl implements EmpleadoNegocio {
	private DaoEmpleado dao = new DaoEmpleadoJpa();
	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	private Map<String, String> errores = new HashMap<>();
	
	public EmpleadoNegocioImpl() 
	{
		Empleado jefazo = Empleado.builder().nif("11111111A").nombre("JEFAZO").sueldo(new BigDecimal(123456)).build();
		dao.insertar(jefazo);

		Empleado jefe = Empleado.builder().nif("22222222A").nombre("Jefe Intermedio").sueldo(new BigDecimal(54321)).build();
		dao.insertar(jefe);
		
		Empleado empleado1 = Empleado.builder().nif("33333333A").nombre("Empleadillo").sueldo(new BigDecimal(12345)).build();
		dao.insertar(empleado1);

		Empleado enchufado = Empleado.builder().nif("44444444A").nombre("Enchufado").sueldo(new BigDecimal(23456)).build();
		dao.insertar(enchufado);
		
		Empleado e1 = dao.obtenerPorId(1L);
		Empleado e2 = dao.obtenerPorId(2L);
		Empleado e3 = dao.obtenerPorId(3L);
		Empleado e4 = dao.obtenerPorId(4L);
		
		e2.setJefe(e1);
		e3.setJefe(e2);
		e4.setJefe(e1);
		
		dao.insertarVacacion(Vacacion.builder().fecha(LocalDate.of(2024, 1, 1)).empleado(e1).build());
		dao.insertarVacacion(Vacacion.builder().fecha(LocalDate.of(2024, 1, 2)).empleado(e1).build());
		dao.insertarVacacion(Vacacion.builder().fecha(LocalDate.of(2024, 1, 3)).empleado(e1).build());
		dao.insertarVacacion(Vacacion.builder().fecha(LocalDate.of(2024, 1, 4)).empleado(e1).build());
		
		dao.modificar(e1);
		
		dao.modificar(e2);
		dao.modificar(e3);
		dao.modificar(e4);
	}

	@Override
	public Iterable<Empleado> listado() {
		return dao.obtenerTodos();
	}

	@Override
	public Empleado obtenerPorId(Long id) {
		return dao.obtenerPorId(id);
	}

	@Override
	public Empleado cambiar(Empleado empleado) {
		if(validar(empleado).size() > 0) {
			return null;
		}

		return dao.modificar(empleado);
	}

	@Override
	public Empleado nuevo(Empleado empleado) {
		if(validar(empleado).size() > 0) {
			return null;
		}
		
		return dao.insertar(empleado);
	}

	@Override
	public Map<String, String> obtenerUltimosErrores() {
		return errores;
	}

	@Override
	public void eliminar(Long id) {
		dao.borrar(id);
	}
	
	private Set<ConstraintViolation<Empleado>> validar(Empleado empleado) {
		Set<ConstraintViolation<Empleado>> validaciones = validator.validate(empleado);
		
		errores.clear();
		
		for(ConstraintViolation<Empleado> validacion: validaciones) {
			errores.put(validacion.getPropertyPath().toString(), validacion.getMessage());
		}
		
		return validaciones;
	}
	
	
}
