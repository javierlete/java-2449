package com.ipartek.formacion.clientes.modelos;

import java.util.Objects;

public class Usuario {
	private Long id;
	private String identificativo;
	private String password;
	private String nombre;

	private Rol rol = new Rol(null, "USUARIO", null);
	
	public Usuario(Long id, String identificativo, String password, String nombre, Rol rol) {
		setId(id);
		setIdentificativo(identificativo);
		setPassword(password);
		setNombre(nombre);
		setRol(rol);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificativo() {
		return identificativo;
	}

	public void setIdentificativo(String identificativo) {
		this.identificativo = identificativo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, identificativo, nombre, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id) && Objects.equals(identificativo, other.identificativo)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", identificativo=" + identificativo + ", password=" + password + ", nombre="
				+ nombre + "]";
	}

}
