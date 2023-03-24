package com.ipartek.formacion.clientes.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.clientes.modelos.Rol;
import com.ipartek.formacion.clientes.modelos.Usuario;

public class DaoUsuarioSQLite implements DaoUsuario {
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de SQLite", e);
		}
	}
	
	private final String URL;

	private static final String SQL_SELECT = "SELECT * FROM usuarios";
	private static final String SQL_SELECT_ID = """
			SELECT u.id u_id, u.nombre u_nombre, u.identificativo u_identificativo, u.password u_password, r.id r_id, r.nombre r_nombre, r.descripcion r_descripcion
			FROM usuarios u
			JOIN roles r ON u.rol_id = r.id
			WHERE u.id=?;
			""";
	
	private static final String SQL_SELECT_IDENTIFICATIVO = """
			SELECT u.id u_id, u.nombre u_nombre, u.identificativo u_identificativo, u.password u_password, r.id r_id, r.nombre r_nombre, r.descripcion r_descripcion
			FROM usuarios u
			JOIN roles r ON u.rol_id = r.id
			WHERE u.identificativo=?;
			""";
	private static final String SQL_INSERT = "INSERT INTO usuarios (identificativo, password, nombre, rol_id) VALUES (?,?,?,?)";

	private static final String SQL_UPDATE = "UPDATE usuarios SET identificativo=?,password=?,nombre=?,rol_id=? WHERE id=?";

	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id=?";

	public DaoUsuarioSQLite(String fichero) {
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
	public Iterable<Usuario> obtenerTodos() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			List<Usuario> usuarios = new ArrayList<>();

			Usuario usuario;

			while (rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("identificativo"), rs.getString("password"), rs.getString("nombre"), null);

				usuarios.add(usuario);
			}

			return usuarios;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros", e);
		}
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {

			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			Usuario usuario = null;
			Rol rol = null;
			
			if (rs.next()) {
				rol = new Rol(rs.getLong("r_id"), rs.getString("r_nombre"), rs.getString("r_descripcion"));
				usuario = new Usuario(rs.getLong("u_id"), rs.getString("u_identificativo"), rs.getString("u_password"), rs.getString("u_nombre"), rol);
			}

			return usuario;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro id=" + id, e);
		}
	}

	@Override
	public Usuario obtenerPorIdentificativo(String identificativo) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_IDENTIFICATIVO);) {

			pst.setString(1, identificativo);

			ResultSet rs = pst.executeQuery();

			Usuario usuario = null;
			Rol rol = null;
			
			if (rs.next()) {
				rol = new Rol(rs.getLong("r_id"), rs.getString("r_nombre"), rs.getString("r_descripcion"));
				usuario = new Usuario(rs.getLong("u_id"), rs.getString("u_identificativo"), rs.getString("u_password"), rs.getString("u_nombre"), rol);
			}

			return usuario;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el registro identificativo=" + identificativo, e);
		}	}
	
	@Override
	public Usuario insertar(Usuario usuario) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			pst.setString(1, usuario.getIdentificativo());
			pst.setString(2, usuario.getPassword());
			pst.setString(3, usuario.getNombre());
			pst.setLong(4, usuario.getRol().getId());

			int modificados = pst.executeUpdate();

			if (modificados != 1) {
				throw new AccesoDatosException("Se ha insertado 0 o más de un usuario");
			}
			
			ResultSet rs = pst.getGeneratedKeys();
			
			rs.next();
			
			Long id = rs.getLong(1);
			
			usuario.setId(id);

			return usuario;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el registro", e);
		}
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, usuario.getIdentificativo());
			pst.setString(2, usuario.getPassword());
			pst.setString(3, usuario.getNombre());
			pst.setLong(4, usuario.getRol().getId());
			
			pst.setLong(5, usuario.getId());

			int modificados = pst.executeUpdate();

			if (modificados != 1) {
				throw new AccesoDatosException("Se ha modificado 0 o más de un usuario");
			}

			return usuario;
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
				throw new AccesoDatosException("Se ha borrado 0 o más de un usuario");
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido borrar el registro", e);
		}
	}

	
}
