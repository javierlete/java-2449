package com.ipartek.formacion.clientes.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.clientes.modelos.Rol;

public class DaoRolSQLite implements DaoRol {
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de SQLite", e);
		}
	}
	
	private final String URL;

	private static final String SQL_SELECT = "SELECT * FROM roles";
	private static final String SQL_SELECT_ID = "SELECT * FROM roles WHERE id=?";
	
	public DaoRolSQLite(String fichero) {
		URL = "jdbc:sqlite:" + fichero;
	}

	private Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(URL);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}

	@Override
	public Iterable<Rol> obtenerTodos() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			List<Rol> roles = new ArrayList<>();

			Rol rol;

			while (rs.next()) {
				rol = new Rol(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"));

				roles.add(rol);
			}

			return roles;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros", e);
		}
	}

	@Override
	public Rol obtenerPorId(Long id) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {

			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			Rol rol = null;
			
			if (rs.next()) {
				rol = new Rol(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"));
			}

			return rol;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro id=" + id, e);
		}
	}

}
