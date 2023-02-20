package com.ipartek.formacion.clientes.presentacion;

import com.ipartek.formacion.clientes.accesodatos.DaoCliente;
import com.ipartek.formacion.clientes.accesodatos.DaoClienteSQLite;
import com.ipartek.formacion.clientes.entidades.Cliente;

public class ClientesConsola {

	private static DaoCliente dao = new DaoClienteSQLite("sql/clientes.db");
	
	public static void main(String[] args) {
		buscarPorId();
		
		//dao.insertar(new Cliente(null, "Juan", "13243546A", "61625344", "asdf@asdf.df", LocalDate.of(2003, 4, 5)));
		
		listado();
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
