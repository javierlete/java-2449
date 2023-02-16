package com.ipartek.formacion.almacen.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.almacen.entidades.Producto;

public class DaoProductoSQLite implements Dao<Producto> {
	private static final String URL = "jdbc:sqlite:";
	private static final String USER = "";
	private static final String PASSWORD = "";

	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_SELECT_ID = "SELECT * FROM productos WHERE id=?";
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, stock, fecha_caducidad) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, stock=?, fecha_caducidad=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

	private String url = URL;
	
	public DaoProductoSQLite(String fichero) {
		this.url += fichero;
	}
	
	private Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(url, USER, PASSWORD);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar con la base de datos", e);
		}
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		try (Connection con = obtenerConexion();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {

			List<Producto> productos = new ArrayList<>();
			Producto producto;
			
			while (rs.next()) {
				producto = resultSetAProducto(rs);
				
				productos.add(producto);
			}
			
			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido consultar los registros", e);
		}
	}

	@Override
	public Producto obtenerPorId(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
				) {
			pst.setLong(1, id);
			
			Producto producto = null;
			
			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					producto = resultSetAProducto(rs);
				}
			}

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido consultar los registros", e);
		}
	}

	@Override
	public Producto insertar(Producto producto) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT);
				) {
			productoAPreparedStatement(producto, pst);
			
			int modificados = pst.executeUpdate();

			if(modificados != 1) {
				throw new AccesoDatosException("No ha podido insertar el registro");
			}
			
			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido consultar los registros", e);
		}
	}

	@Override
	public Producto modificar(Producto producto) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);
				) {
			productoAPreparedStatement(producto, pst);
			
			int modificados = pst.executeUpdate();

			if(modificados != 1) {
				throw new AccesoDatosException("No se puede modificar un registro inexistente " + producto.getId());
			}
			
			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido consultar los registros", e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);
				) {
			pst.setLong(1, id);
			
			int modificados = pst.executeUpdate();

			if(modificados != 1) {
				throw new AccesoDatosException("No se puede borrar un registro inexistente " + id);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido consultar los registros", e);
		}
	}

	private Producto resultSetAProducto(ResultSet rs) throws SQLException {
		Producto producto;
		LocalDate fechaCaducidad;
		String fechaTexto;
		fechaCaducidad = null;
		
		fechaTexto = rs.getString("fecha_caducidad");
		
		if(fechaTexto != null) {
			fechaCaducidad = LocalDate.parse(fechaTexto);
		}
		
		producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"),
				(Integer)rs.getObject("stock"), fechaCaducidad);
		
		return producto;
	}

	private void productoAPreparedStatement(Producto producto, PreparedStatement pst) throws SQLException {
		pst.setString(1, producto.getNombre());
		pst.setBigDecimal(2, producto.getPrecio());
		pst.setObject(3, producto.getStock());
		
		LocalDate fechaCaducidad = producto.getFechaCaducidad();
		
		String fechaTexto = null;
		
		if(fechaCaducidad != null) {
			fechaTexto = fechaCaducidad.format(DateTimeFormatter.ISO_DATE);
		}
		
		pst.setObject(4, fechaTexto);
		
		if(producto.getId() != null) {
			pst.setLong(5, producto.getId());
		}
	}

}
