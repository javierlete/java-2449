package com.ipartek.formacion.ipartekzon.dal;

import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

interface DaoJpa {
	static final EntityManagerFactory EMF = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.ipartekzon.modelos");
	
	default <T> T llamarJpa(Function<EntityManager, T> funcion) {
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();

		T resultado = funcion.apply(em);

		em.getTransaction().commit();
		em.close();

		return resultado;
	}

}
