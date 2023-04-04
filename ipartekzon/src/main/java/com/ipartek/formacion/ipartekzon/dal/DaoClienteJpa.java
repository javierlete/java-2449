package com.ipartek.formacion.ipartekzon.dal;

import com.ipartek.formacion.ipartekzon.modelos.Cliente;

public class DaoClienteJpa implements DaoCliente, DaoJpa {
	@Override
	public Iterable<Cliente> obtenerTodos() {
		return llamarJpa(em -> em.createQuery("from Cliente", Cliente.class).getResultList());
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		return llamarJpa(em -> em.find(Cliente.class, id));
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		return llamarJpa(em -> em.merge(cliente));
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		return llamarJpa(em -> em.merge(cliente));
	}

	@Override
	public void borrar(Long id) {
		llamarJpa(em -> {
			em.remove(em.find(Cliente.class, id));
			return null;
		});
	}

	@Override
	public Cliente buscarPorNif(String nif) {
		return llamarJpa(em -> em.createQuery("from Cliente c where c.nif = " + nif, Cliente.class).getSingleResult());
	}
}
