package com.ipartek.formacion.ipartekzon.dal;

import java.util.List;

import com.ipartek.formacion.ipartekzon.modelos.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoClienteJpa implements DaoCliente {
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.ipartekzon.modelos");

	@Override
	public Iterable<Cliente> obtenerTodos() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<Cliente> clientes = em.createQuery("from Cliente", Cliente.class).getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return clientes;
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Cliente cliente = em.find(Cliente.class, id);
		
		em.getTransaction().commit();
		em.close();
		
		return cliente;
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
		
		return cliente;
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(cliente);
		
		em.getTransaction().commit();
		em.close();
		
		return cliente;
	}

	@Override
	public void borrar(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.remove(em.find(Cliente.class, id));
		
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Cliente buscarPorNif(String nif) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Cliente cliente = em.createQuery("from Cliente c where c.nif = " + nif, Cliente.class).getSingleResult();
		
		em.getTransaction().commit();
		em.close();
		
		return cliente;
	}
}
