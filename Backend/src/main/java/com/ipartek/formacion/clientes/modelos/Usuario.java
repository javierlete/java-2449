package com.ipartek.formacion.clientes.modelos;

import java.util.Objects;

public class Usuario {
	private String identificativo;
	private String password;
	private String nombre;

	public Usuario(String identificativo, String password, String nombre) {
		super();
		this.identificativo = identificativo;
		this.password = password;
		this.nombre = nombre;
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

	@Override
	public int hashCode() {
		return Objects.hash(identificativo, nombre, password);
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
		return Objects.equals(identificativo, other.identificativo) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Usuario [identificativo=" + identificativo + ", password=" + password + ", nombre=" + nombre + "]";
	}

}
