package com.ipartek.formacion.almacen.accesodatos;

import java.io.InputStream;
import java.util.Properties;

public class FabricaDao {
	private static final String FICHERO_CONFIGURACION = "fabrica.properties";
	private static DaoProducto tipo;

	static {
		String tipoTexto = null;

		try {
			Properties props = new Properties();
			InputStream ficheroProperties = FabricaDao.class.getClassLoader()
					.getResourceAsStream(FICHERO_CONFIGURACION);

			if (ficheroProperties == null) {
				throw new AccesoDatosException(
						"No se ha encontrado el fichero de configuración " + FICHERO_CONFIGURACION);
			}

			props.load(ficheroProperties);

			tipoTexto = props.getProperty("dao.tipo");

			if (tipoTexto == null) {
				throw new AccesoDatosException("Necesitamos el valor dao.tipo en la configuración");
			}

			Class<?> clase = Class.forName(tipoTexto);

			String argumento = props.getProperty("dao.argumento");

			if (argumento == null) {
				tipo = (DaoProducto) clase.getDeclaredConstructor().newInstance();
			} else {
				tipo = (DaoProducto) clase.getDeclaredConstructor(String.class).newInstance(argumento);
			}

		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado la clase " + tipoTexto, e);
		} catch (ClassCastException e) {
			throw new AccesoDatosException("La clase debe implementar Dao<Producto>", e);
		} catch (NoSuchMethodException e) {
			throw new AccesoDatosException("No se ha encontrado el constructor requerido", e);
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido leer la configuración", e);
		}
	}

	public static DaoProducto getDaoProducto() {
		return tipo;
	}
}
