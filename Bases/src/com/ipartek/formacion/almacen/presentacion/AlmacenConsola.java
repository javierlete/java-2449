package com.ipartek.formacion.almacen.presentacion;

import static com.ipartek.formacion.bibliotecas.Consola.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.almacen.accesodatos.Dao;
import com.ipartek.formacion.almacen.accesodatos.FabricaDao;
import com.ipartek.formacion.almacen.entidades.Producto;

public class AlmacenConsola {
	private static final int SALIR = 0;

	private static Dao<Producto> dao = FabricaDao.getDaoProducto();
	
	public static void main(String[] args) {
		int opcion;
		
		do {
			mostrarMenu();
			opcion = pedirOpcion();
			ejecutarOpcion(opcion);
		} while(opcion != SALIR);
		
	}

	private static void mostrarMenu() {
		pl();
		pl("1. Listado");
		pl("2. Buscar por id");
		pl("3. Insertar");
		pl("4. Modificar");
		pl("5. Borrar");
		pl();
		pl("0. Salir");
		pl();
	}

	private static int pedirOpcion() {
		return pedirEntero("Introduce la opción deseada");
	}

	private static void ejecutarOpcion(int opcion) {
		switch(opcion) {
		case 0:
			pl("Gracias por usar la aplicación");
			break;
		case 1:
			listado();
			break;
		case 2:
			buscarPorId();
			break;
		case 3:
			insertar();
			break;
		case 4:
			modificar();
			break;
		case 5:
			borrar();
			break;
		default:
			ple("No conozco esa opción");
		}
	}

	private static void listado() {
		boolean hayProductos = false;
		
		for(Producto producto: dao.obtenerTodos()) {
			mostrarProductoLinea(producto);
			hayProductos = true;
		}
		
		if(!hayProductos) {
			pl("No hay ningún producto");
		}
	}

	private static void mostrarProductoLinea(Producto producto) {
		pl(producto);
	}

	private static void buscarPorId() {
		Long id = pedirLong("Introduce el id del producto");
		
		mostrarFichaProducto(dao.obtenerPorId(id));
	}

	private static void mostrarFichaProducto(Producto producto) {
		pl(producto);
	}

	private static void insertar() {
		Producto producto = pedirDatosProducto();
		
		dao.insertar(producto);
	}

	private static Producto pedirDatosProducto() {
		String nombre = pedirTexto("Nombre");
		BigDecimal precio = pedirBigDecimal("Precio");
		Integer stock = pedirEntero("Stock");
		LocalDate fechaCaducidad = pedirFecha("Fecha de caducidad");
		
		Producto producto = new Producto(nombre, precio, stock, fechaCaducidad);
		
		return producto;
	}

	private static void modificar() {
		Long id = pedirLong("Id");
		
		Producto producto = pedirDatosProducto();
		
		producto.setId(id);
		
		dao.modificar(producto);
	}

	private static void borrar() {
		Long id = pedirLong("Introduce el id del producto a borrar");
		
		dao.borrar(id);
	}
}
