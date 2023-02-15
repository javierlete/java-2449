package com.ipartek.formacion.almacen.accesodatos;

import java.io.InputStream;
import java.util.Properties;

import com.ipartek.formacion.almacen.entidades.Producto;

public class FabricaDao {
	private static final String FICHERO_CONFIGURACION = "fabrica.properties";
	private static String tipo;
	private static String fichero;
	
	static {
		try {
			Properties props = new Properties();
			InputStream ficheroProperties = FabricaDao.class.getClassLoader().getResourceAsStream(FICHERO_CONFIGURACION);
			
			if(ficheroProperties == null) {
				throw new AccesoDatosException("No se ha encontrado el fichero de configuración " + FICHERO_CONFIGURACION);
			}
			
			props.load(ficheroProperties);
			
			tipo = props.getProperty("dao.tipo");
			
			if(tipo == null) {
				throw new AccesoDatosException("Necesitamos el valor dao.tipo en la configuración");
			}
			
			fichero = props.getProperty("dao.fichero");

			if("fichero".equals(tipo) && fichero == null) {
				throw new AccesoDatosException("Necesitamos el valor dao.fichero en la configuración");
			}
		} catch (Exception e) {
			throw new AccesoDatosException("No se ha podido leer la configuración", e);
		}
	}
	
	public static Dao<Producto> getDaoProducto() {
		switch(tipo) {
		case "fichero": return new DaoProductoFichero(fichero);
		case "memoria": return new DaoProductoMemoria();
		default: throw new AccesoDatosException("No se acepta ese tipo");
		}
	}
}
