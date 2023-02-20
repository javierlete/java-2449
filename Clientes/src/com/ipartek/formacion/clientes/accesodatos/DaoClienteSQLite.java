package com.ipartek.formacion.clientes.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.clientes.entidades.Cliente;

public class DaoClienteSQLite implements DaoCliente {
	private final String URL;
	
	private static final String SQL_SELECT = "SELECT * FROM clientes";
	
	public DaoClienteSQLite(String fichero) {
		URL = "jdbc:sqlite:" + fichero;
	}
	
	private Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(URL);
		} catch (SQLException e) {
			throw new AccesoDatos("No se ha podido conectar a la base de datos", e);
		}
	}
	
	@Override
	public Iterable<Cliente> obtenerTodos() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			List<Cliente> clientes = new ArrayList<>();
			
			Cliente cliente;
			
			while(rs.next()) {
				cliente = new Cliente(rs.getLong("id"), rs.getString("nombre"), rs.getString("nif"), rs.getString("telefono"), rs.getString("email"), textoAFecha(rs.getString("fecha_nacimiento")));
				
				clientes.add(cliente);
			}
			
			return clientes;
		} catch (SQLException e) {
			throw new AccesoDatos("No se han podido obtener todos los registros", e);
		}
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADA");
	}

	@Override
	public Cliente insertar(Cliente entidad) {
		throw new UnsupportedOperationException("NO IMPLEMENTADA");
	}

	@Override
	public Cliente modificar(Cliente entidad) {
		throw new UnsupportedOperationException("NO IMPLEMENTADA");
	}

	@Override
	public void borrar(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADA");
	}

	private LocalDate textoAFecha(String fecha) {
		if(fecha == null) {
			return null;
		}
		
		return LocalDate.parse(fecha);
	}
}
