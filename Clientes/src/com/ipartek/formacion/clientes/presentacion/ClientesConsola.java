package com.ipartek.formacion.clientes.presentacion;

import java.time.LocalDate;

import com.ipartek.formacion.clientes.accesodatos.DaoCliente;
import com.ipartek.formacion.clientes.accesodatos.DaoClienteSQLite;
import com.ipartek.formacion.clientes.entidades.Cliente;

public class ClientesConsola {

	private static DaoCliente dao = new DaoClienteSQLite("sql/clientes.db");
	
	public static void main(String[] args) {
		//buscarPorId();
		
		listado();
		
		borrar();
		//modificar();
		//insertar();
		
		listado();
	}

	private static void borrar() {
		dao.borrar(6L);
	}

	private static void modificar() {
		dao.modificar(new Cliente(4L, "Juan Pedro", "18273645A", "616253444", "juan@pedro.df", LocalDate.of(2005, 6, 7)));
	}

	private static void insertar() {
		dao.insertar(new Cliente(null, "Juan", "13243546A", "61625344", "asdf@asdf.df", LocalDate.of(2003, 4, 5)));
		dao.insertar(new Cliente(null, "Juan", "13243546A", null, null, (LocalDate)null));
	}

	private static void buscarPorId() {
		System.out.println(dao.obtenerPorId(2L));
	}

	private static void listado() {
		for(Cliente cliente: dao.obtenerTodos()) {
			System.out.println(cliente);
		}
	}

}
