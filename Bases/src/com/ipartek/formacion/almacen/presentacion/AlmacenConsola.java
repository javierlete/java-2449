package com.ipartek.formacion.almacen.presentacion;

import static com.ipartek.formacion.bibliotecas.Consola.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.almacen.accesodatos.DaoProducto;
import com.ipartek.formacion.almacen.accesodatos.FabricaDao;
import com.ipartek.formacion.almacen.entidades.Producto;

public class AlmacenConsola {
	private static final String TEXTO_VACIO = "___";
	private static final String FORMATO_FICHA = "%-10s %-70s\n";
	private static final String FORMATO_LINEA = "%3s  %-20s  %10s  %6s  %-11s\n";

	private static final int SALIR = 0;

	private static DaoProducto dao = FabricaDao.getDaoProducto();

	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenu();
			opcion = pedirOpcion();
			ejecutarOpcion(opcion);
		} while (opcion != SALIR);

	}

	private static void mostrarMenu() {
		pl();
		pl("1. Listado");
		pl("2. Buscar por id");
		pl("3. Insertar");
		pl("4. Modificar");
		pl("5. Borrar");
		pl("6. Buscar por nombre");
		pl("7. Buscar por precio");
		pl();
		pl("0. Salir");
		pl();
	}

	private static int pedirOpcion() {
		return pedirEntero("Introduce la opción deseada");
	}

	private static void ejecutarOpcion(int opcion) {
		switch (opcion) {
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
		case 6:
			buscarPorNombre();
			break;
		case 7:
			buscarPorPrecio();
			break;
		default:
			ple("No conozco esa opción");
		}
	}

	private static void listado() {
		listarProductos(dao.obtenerTodos());
	}

	private static void buscarPorId() {
		pedirProductoPorId();
	}

	private static void insertar() {
		Producto producto = pedirDatosProducto();

		dao.insertar(producto);
	}

	private static void modificar() {
		Producto producto = pedirProductoPorId();

		if (producto == null) {
			return;
		}

		Long id = producto.getId();

		producto = pedirDatosProducto();

		producto.setId(id);

		dao.modificar(producto);
	}

	private static void borrar() {
		Producto producto = pedirProductoPorId();

		if (producto == null) {
			return;
		}

		dao.borrar(producto.getId());
	}

	private static void buscarPorNombre() {
		String nombre = pedirTexto("Nombre");

		listarProductos(dao.buscarPorNombre(nombre));
	}

	private static void buscarPorPrecio() {
		BigDecimal inferior = pedirBigDecimal("Precio inferior");
		BigDecimal superior = pedirBigDecimal("Precio superior");

		listarProductos(dao.buscarPorRangoPrecio(inferior, superior));
	}

	private static void listarProductos(Iterable<Producto> productos) {
		boolean hayProductos = false;

		plf(FORMATO_LINEA, "Id", "Nombre", "Precio", "Stock", "Caducidad");
		plf(FORMATO_LINEA, "==", "======", "======", "=====", "=========");

		for (Producto producto : productos) {
			mostrarProductoLinea(producto);
			hayProductos = true;
		}

		if (!hayProductos) {
			pl("No hay ningún producto");
		}
	}

	private static Producto pedirDatosProducto() {
		Producto producto = new Producto();

		reintentar(() -> producto.setNombre(pedirTexto("Nombre")));
		reintentar(() -> producto.setPrecio(pedirBigDecimal("Precio")));
		reintentar(() -> producto.setStock(pedirEntero("Stock", OPCIONAL)));
		reintentar(() -> producto.setFechaCaducidad(pedirFecha("Fecha de caducidad", OPCIONAL)));
		
		return producto;
	}

	private static void mostrarProductoLinea(Producto producto) {
		Long id = producto.getId();
		String nombre = producto.getNombre();
		String precio = formatearPrecio(producto.getPrecio());
		String stock = formatearEntero(producto.getStock());
		String fecha = formatearFecha(producto.getFechaCaducidad());
	
		plf(FORMATO_LINEA, id, nombre, precio, stock, fecha);
	}

	private static void mostrarFichaProducto(Producto producto) {
		pl();
		plf(FORMATO_FICHA, "Id", producto.getId());
		plf(FORMATO_FICHA, "Nombre", producto.getNombre());
		plf(FORMATO_FICHA, "Precio", formatearPrecio(producto.getPrecio()));
		plf(FORMATO_FICHA, "Stock", formatearEntero(producto.getStock()));
		plf(FORMATO_FICHA, "Caducidad", formatearFecha(producto.getFechaCaducidad()));
		pl();
	}

	private static Producto pedirProductoPorId() {
		Long id = pedirLong("Id");

		Producto producto = dao.obtenerPorId(id);

		if (producto == null) {
			ple("No se ha encontrado el producto");
		} else {
			mostrarFichaProducto(producto);
		}

		return producto;
	}

	private static String formatearPrecio(BigDecimal precio) {
		return String.format("%,.2f €", precio);
	}

	private static String formatearEntero(Integer entero) {
		return entero == null ? TEXTO_VACIO : entero.toString();
	}

	private static String formatearFecha(LocalDate fecha) {
		return fecha == null ? TEXTO_VACIO : String.format("%1$td/%1$tm/%1$tY", fecha);
	}
	
	private static void reintentar(Runnable runnable) {
		boolean esIncorrecto = true;
		
		do {
			try {
				runnable.run();
				esIncorrecto = false;
			} catch (Exception e) {
				ple(e.getMessage());
			}
		} while (esIncorrecto);
	}
}
