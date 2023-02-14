package com.ipartek.formacion.almacen.accesodatos;

import java.util.Properties;

import com.ipartek.formacion.almacen.entidades.Producto;

public class FabricaDao {
	private static String tipo;
	private static String fichero;
	
	static {
		try {
			Properties props = new Properties();
			props.load(FabricaDao.class.getClassLoader().getResourceAsStream("fabrica.properties"));
			
			tipo = props.getProperty("dao.tipo");
			fichero = props.getProperty("dao.fichero");
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
