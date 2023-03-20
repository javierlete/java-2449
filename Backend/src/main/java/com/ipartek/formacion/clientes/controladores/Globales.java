package com.ipartek.formacion.clientes.controladores;

import com.ipartek.formacion.clientes.accesodatos.DaoCliente;
import com.ipartek.formacion.clientes.accesodatos.DaoClienteSQLite;

public class Globales {
	private static final String SQLITE_DB = "/Users/javierlete/git/java-2449/Backend/sql/clientes.db";

	public static final String VISTAS = "/WEB-INF/vistas";
	public static final DaoCliente DAO = new DaoClienteSQLite(SQLITE_DB);
}
