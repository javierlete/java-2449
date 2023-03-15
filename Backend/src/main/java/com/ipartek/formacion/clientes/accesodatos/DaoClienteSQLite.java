package com.ipartek.formacion.clientes.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.clientes.modelos.Cliente;

public class DaoClienteSQLite implements DaoCliente {
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de SQLite", e);
		}
	}
	
	private final String URL;

	private static final String SQL_SELECT = "SELECT * FROM clientes";
	private static final String SQL_SELECT_ID = "SELECT * FROM clientes WHERE id=?";

	private static final String SQL_INSERT = "INSERT INTO clientes (nombre, nif, telefono, email, fecha_nacimiento) VALUES (?,?,?,?,?)";

	private static final String SQL_UPDATE = "UPDATE clientes SET nombre=?, nif=?, telefono=?, email=?, fecha_nacimiento=? WHERE id=?";

	private static final String SQL_DELETE = "DELETE FROM clientes WHERE id=?";

	public DaoClienteSQLite(String fichero) {
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
	public Iterable<Cliente> obtenerTodos() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			List<Cliente> clientes = new ArrayList<>();

			Cliente cliente;

			while (rs.next()) {
				cliente = new Cliente(rs.getLong("id"), rs.getString("nombre"), rs.getString("nif"),
						rs.getString("telefono"), rs.getString("email"), rs.getString("fecha_nacimiento"));

				clientes.add(cliente);
			}

			return clientes;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros", e);
		}
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {

			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			Cliente cliente = null;

			if (rs.next()) {
				cliente = new Cliente(rs.getLong("id"), rs.getString("nombre"), rs.getString("nif"),
						rs.getString("telefono"), rs.getString("email"), rs.getString("fecha_nacimiento"));
			}

			return cliente;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro id=" + id, e);
		}
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, cliente.getNombre());
			pst.setString(2, cliente.getNif());
			pst.setString(3, cliente.getTelefono());
			pst.setString(4, cliente.getEmail());
			pst.setString(5, cliente.getFechaNacimientoTexto());

			int modificados = pst.executeUpdate();

			if (modificados != 1) {
				throw new AccesoDatosException("Se ha insertado 0 o más de un cliente");
			}
			
			ResultSet rs = pst.getGeneratedKeys();
			
			rs.next();
			
			Long id = rs.getLong(1);
			
			cliente.setId(id);

			return cliente;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el registro", e);
		}
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, cliente.getNombre());
			pst.setString(2, cliente.getNif());
			pst.setString(3, cliente.getTelefono());
			pst.setString(4, cliente.getEmail());
			pst.setString(5, cliente.getFechaNacimientoTexto());
			
			pst.setLong(6, cliente.getId());

			int modificados = pst.executeUpdate();

			if (modificados != 1) {
				throw new AccesoDatosException("Se ha modificado 0 o más de un cliente");
			}

			return cliente;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el registro", e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {

			pst.setLong(1, id);

			int modificados = pst.executeUpdate();

			if (modificados != 1) {
				throw new AccesoDatosException("Se ha borrado 0 o más de un cliente");
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido borrar el registro", e);
		}
	}
}
