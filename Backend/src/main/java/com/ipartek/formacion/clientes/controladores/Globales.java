package com.ipartek.formacion.clientes.controladores;

import com.ipartek.formacion.clientes.accesodatos.DaoCliente;
import com.ipartek.formacion.clientes.accesodatos.DaoClienteMySQL;
import com.ipartek.formacion.clientes.accesodatos.DaoRol;
import com.ipartek.formacion.clientes.accesodatos.DaoRolMySQL;
import com.ipartek.formacion.clientes.accesodatos.DaoUsuario;
import com.ipartek.formacion.clientes.accesodatos.DaoUsuarioMySQL;

public class Globales {
//	private static final String SQLITE_DB = "/Users/javierlete/git/java-2449/Backend/sql/clientes.db";

	private static final String BASE_DE_DATOS = "root:admin@localhost:3306/tienda2449";
	
	public static final String VISTAS = "/WEB-INF/vistas";
	
	public static final DaoCliente DAO_CLIENTES = new DaoClienteMySQL(BASE_DE_DATOS);
	public static final DaoUsuario DAO_USUARIO = new DaoUsuarioMySQL(BASE_DE_DATOS);
	public static final DaoRol DAO_ROL = new DaoRolMySQL(BASE_DE_DATOS);
	
//	public static final DaoCliente DAO_CLIENTES = new DaoClienteSQLite(SQLITE_DB);
//	public static final DaoUsuario DAO_USUARIO = new DaoUsuarioSQLite(SQLITE_DB);
//	public static final DaoRol DAO_ROL = new DaoRolSQLite(SQLITE_DB);
}
