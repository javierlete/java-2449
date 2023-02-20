package com.ipartek.formacion.clientes.presentacion;

import com.ipartek.formacion.clientes.accesodatos.DaoCliente;
import com.ipartek.formacion.clientes.accesodatos.DaoClienteSQLite;
import com.ipartek.formacion.clientes.entidades.Cliente;

public class ClientesConsola {

	private static DaoCliente dao = new DaoClienteSQLite("sql/clientes.db");
	
	public static void main(String[] args) {
		for(Cliente cliente: dao.obtenerTodos()) {
			System.out.println(cliente);
		}
	}

}
