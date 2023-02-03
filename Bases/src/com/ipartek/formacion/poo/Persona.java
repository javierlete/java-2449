package com.ipartek.formacion.poo;

import java.time.LocalDate;
import java.util.Objects;

public class Persona { // extends Object
	// Constantes
	private static final String NOMBRE_POR_DEFECTO = "Anónimo";

	// Variables estáticas ("de clase")
	private static int mayoriaDeEdad = 18;

	// Bloque estático / "Constructor estático"
	static {
		System.out.println("Persona STATIC");
	}
	
	// Variables de instancia
	private Long id;
	private String nombre;
	private String dni;
	private LocalDate fechaNacimiento;

	// Constructores
	public Persona(Long id, String nombre, String dni, LocalDate fechaNacimiento) {
		// super();
		setId(id);
		setNombre(nombre);
		setDni(dni);
		setFechaNacimiento(fechaNacimiento);
	}

	public Persona(String nombre, String dni, LocalDate fechaNacimiento) {
		this(null, nombre, dni, fechaNacimiento);
	}

	public Persona(String nombre) {
		this(null, nombre, null, null);
	}

	public Persona() {
		this(null, NOMBRE_POR_DEFECTO, null, null);
	}
	
	//public Persona() {
	//	super();
	//}

	// (Constructor de copia)
	public Persona(Persona persona) {
		this(persona.id, persona.nombre, persona.dni, persona.fechaNacimiento);
	}

	// Métodos de acceso / Getters y setters
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
		if (nombre == null) {
			throw new IllegalArgumentException("No se puede dejar el nombre sin rellenar");
		}

		if (nombre.trim().length() == 0) {
			throw new IllegalArgumentException("No puedes dejar el nombre en blanco");
		}

		this.nombre = nombre.trim();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if(fechaNacimiento != null && fechaNacimiento.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("No se puede nacer en el futuro");
		}
		
		this.fechaNacimiento = fechaNacimiento;
	}

	public static int getMayoriaDeEdad() {
		return mayoriaDeEdad;
	}

	public static void setMayoriaDeEdad(int mayoriaDeEdad) {
		if (mayoriaDeEdad < 0) {
			throw new IllegalArgumentException("No se puede tener una mayoría de edad negativa");
		}

		Persona.mayoriaDeEdad = mayoriaDeEdad;
	}

	// Métodos de instancia
	public int getEdad() {
		if (fechaNacimiento == null) {
			throw new IllegalArgumentException("No podemos calcular la edad porque no tenemos fecha de nacimiento");
		}

		return fechaNacimiento.until(LocalDate.now()).getYears();
	}

	public boolean isMayorDeEdad() {
		return getEdad() >= mayoriaDeEdad;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(dni, fechaNacimiento, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	// ToString: resumen de la información del objeto en una línea
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento
				+ "]";
	}
}
