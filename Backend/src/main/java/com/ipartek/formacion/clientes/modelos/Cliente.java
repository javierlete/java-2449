package com.ipartek.formacion.clientes.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Cliente {
	private Long id;
	private String nombre;
	private String nif;
	private String telefono;
	private String email;
	private LocalDate fechaNacimiento;

	public Cliente(Long id, String nombre, String nif, String telefono, String email, LocalDate fechaNacimiento) {
		setId(id);
		setNombre(nombre);
		setNif(nif);
		setTelefono(telefono);
		setEmail(email);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public Cliente(Long id, String nombre, String nif, String telefono, String email, String fechaNacimiento) {
		setId(id);
		setNombre(nombre);
		setNif(nif);
		setTelefono(telefono);
		setEmail(email);
		setFechaNacimiento(fechaNacimiento);
	}

	public Cliente() {

	}

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
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getFechaNacimientoTexto() {
		if(fechaNacimiento == null) {
			return null;
		}
		
		return fechaNacimiento.format(DateTimeFormatter.ISO_DATE);
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setFechaNacimiento(String texto) {
		if (texto == null) {
			setFechaNacimiento((LocalDate) null);
			return;
		}

		setFechaNacimiento(LocalDate.parse(texto));
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, fechaNacimiento, id, nif, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(email, other.email) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(id, other.id) && Objects.equals(nif, other.nif)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", nif=" + nif + ", telefono=" + telefono + ", email="
				+ email + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
