package com.ipartek.formacion.almacen.accesodatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import com.ipartek.formacion.almacen.entidades.Producto;

public class DaoProductoFichero implements Dao<Producto> {

	private String fichero;

	DaoProductoFichero(String fichero) {
		this.fichero = fichero;

		File f = new File(fichero);

		if (!f.exists()) {
			escribirProductos(new TreeMap<Long, Producto>());
		}
	}

	private TreeMap<Long, Producto> leerProductos() {
		try (FileInputStream fis = new FileInputStream(fichero); ObjectInputStream ois = new ObjectInputStream(fis)) {
			@SuppressWarnings("unchecked")
			TreeMap<Long, Producto> productos = (TreeMap<Long, Producto>) ois.readObject();
			ois.close();
			return productos;
		} catch (ClassNotFoundException | IOException e) {
			throw new AccesoDatosException("No se ha podido leer el fichero", e);
		}
	}

	private void escribirProductos(TreeMap<Long, Producto> productos) {
		try (FileOutputStream fos = new FileOutputStream(fichero);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(productos);
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido escribir el fichero", e);
		}
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		return new DaoProductoMemoria(leerProductos()).obtenerTodos();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return new DaoProductoMemoria(leerProductos()).obtenerPorId(id);
	}

	@Override
	public Producto insertar(Producto entidad) {
		TreeMap<Long, Producto> productos = leerProductos();
		Producto producto = new DaoProductoMemoria(productos).insertar(entidad);
		escribirProductos(productos);

		return producto;
	}

	@Override
	public Producto modificar(Producto entidad) {
		TreeMap<Long, Producto> productos = leerProductos();
		Producto producto = new DaoProductoMemoria(productos).modificar(entidad);
		escribirProductos(productos);

		return producto;
	}

	@Override
	public void borrar(Long id) {
		TreeMap<Long, Producto> productos = leerProductos();
		new DaoProductoMemoria(productos).borrar(id);
		escribirProductos(productos);
	}

}
