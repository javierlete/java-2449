package com.ipartek.formacion.ipartekzon.logicanegocio;

import com.ipartek.formacion.ipartekzon.dal.DaoCliente;
import com.ipartek.formacion.ipartekzon.dal.DaoClienteJpa;
import com.ipartek.formacion.ipartekzon.modelos.Cliente;

public class ClienteNegocioImpl implements ClienteNegocio {

	private DaoCliente dao = new DaoClienteJpa();
	
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
		return dao.insertar(cliente);
	}

	@Override
	public Cliente cambiar(Cliente cliente) {
		return dao.modificar(cliente);
	}

	@Override
	public void eliminar(Long id) {
		dao.borrar(id);
	}

}
