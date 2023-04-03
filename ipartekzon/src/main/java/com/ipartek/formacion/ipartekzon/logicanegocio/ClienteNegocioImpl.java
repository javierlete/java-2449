package com.ipartek.formacion.ipartekzon.logicanegocio;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.ipartek.formacion.ipartekzon.dal.DaoCliente;
import com.ipartek.formacion.ipartekzon.dal.DaoClienteJpa;
import com.ipartek.formacion.ipartekzon.modelos.Cliente;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class ClienteNegocioImpl implements ClienteNegocio {

	private DaoCliente dao = new DaoClienteJpa();
	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	private Map<String, String> errores = new HashMap<>();
	
	public ClienteNegocioImpl() {
		dao.insertar(Cliente.builder().nombre("Javier").nif("12345678Z").build());
		dao.insertar(Cliente.builder().nombre("Pepe").nif("87654321A").build());
		dao.insertar(Cliente.builder().nombre("Pedro").nif("14253647A").build());
	}
	
	@Override
	public Iterable<Cliente> listado() {
		return dao.obtenerTodos();
	}

	@Override
	public Cliente consultarPorId(Long id) {
		return dao.obtenerPorId(id);
	}

	@Override
	public Cliente consultarPorNif(String nif) {
		return dao.buscarPorNif(nif);
	}

	@Override
	public Cliente nuevo(Cliente cliente) {
		if(validar(cliente).size() > 0) {
			return null;
		}
		
		return dao.insertar(cliente);
	}

	@Override
	public Cliente cambiar(Cliente cliente) {
		if(validar(cliente).size() > 0) {
			return null;
		}
		
		return dao.modificar(cliente);
	}

	@Override
	public void eliminar(Long id) {
		dao.borrar(id);
	}

	private Set<ConstraintViolation<Cliente>> validar(Cliente cliente) {
		Set<ConstraintViolation<Cliente>> validaciones = validator.validate(cliente);
		
		errores.clear();
		
		for(ConstraintViolation<Cliente> validacion: validaciones) {
			errores.put(validacion.getPropertyPath().toString(), validacion.getMessage());
		}
		
		return validaciones;
	}
	
	@Override
	public Map<String, String> obtenerUltimosErrores() {
		return errores;
	}

}
