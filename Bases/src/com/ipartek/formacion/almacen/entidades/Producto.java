package com.ipartek.formacion.almacen.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Producto implements Serializable {
	private static final long serialVersionUID = -908677691196253892L;
	
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private Integer stock;
	private LocalDate fechaCaducidad;
	
	public Producto(Long id, String nombre, BigDecimal precio, Integer stock, LocalDate fechaCaducidad) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setStock(stock);
		setFechaCaducidad(fechaCaducidad);
	}
	
	public Producto(String nombre, BigDecimal precio, Integer stock, LocalDate fechaCaducidad) {
		this(null, nombre, precio, stock, fechaCaducidad);
	}
	
	public Producto(String nombre, BigDecimal precio, Integer stock) {
		this(null, nombre, precio, stock, null);
	}
	
	public Producto(String nombre, BigDecimal precio) {
		this(null, nombre, precio, null, null);
	}
	
	public Producto() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() == 0) {
			throw new IllegalArgumentException("El nombre es obligatorio");
		}
		
		this.nombre = nombre;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		if(precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("El precio es obligatorio y debe ser 0 o superior");
		}
		
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		if(stock != null && stock < 0) {
			throw new IllegalArgumentException("El stock debe ser positivo");
		}
		
		this.stock = stock;
	}
	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		if(fechaCaducidad != null && fechaCaducidad.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("El producto no se puede introducir ya caducado");
		}
		
		this.fechaCaducidad = fechaCaducidad;
	}
	@Override
	public int hashCode() {
		return Objects.hash(fechaCaducidad, id, nombre, precio, stock);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(fechaCaducidad, other.fechaCaducidad) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio)
				&& Objects.equals(stock, other.stock);
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock
				+ ", fechaCaducidad=" + fechaCaducidad + "]";
	}
}
