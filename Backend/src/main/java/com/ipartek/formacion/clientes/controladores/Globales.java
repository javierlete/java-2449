package com.ipartek.formacion.clientes.controladores;

import com.ipartek.formacion.clientes.accesodatos.DaoCliente;
import com.ipartek.formacion.clientes.accesodatos.DaoClienteSQLite;
import com.ipartek.formacion.clientes.accesodatos.DaoUsuario;
import com.ipartek.formacion.clientes.accesodatos.DaoUsuarioSQLite;

public class Globales {
	private static final String SQLITE_DB = "/Users/javierlete/git/java-2449/Backend/sql/clientes.db";

	public static final String VISTAS = "/WEB-INF/vistas";
	public static final DaoCliente DAO_CLIENTES = new DaoClienteSQLite(SQLITE_DB);
	public static final DaoUsuario DAO_USUARIO = new DaoUsuarioSQLite(SQLITE_DB);
}
