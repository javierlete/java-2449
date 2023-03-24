package com.ipartek.formacion.clientes.modelos;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Usuario {
	private Long id;
	private String identificativo;
	private String password;
	private String nombre;

	private Rol rol = new Rol(null, "USUARIO", null);
	
	private Map<String, String> errores = new TreeMap<>();
	
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
		if(identificativo == null || identificativo.trim().length() < 2) {
			errores.put("identificativo", "El identificativo es obligatorio y debe tener al menos dos caracteres");
		}
		this.identificativo = identificativo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(password == null || password.trim().length() < 4) {
			errores.put("password", "La contraseña debe tener al menos 4 caracteres y es obligatoria");
		}
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().length() < 2) {
			errores.put("nombre", "El nombre es obligatorio y debe tener al menos dos caracteres");
		}
		this.nombre = nombre;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		if(rol == null) {
			errores.put("rol", "Debes seleccionar un rol");
		}
		this.rol = rol;
	}

	public Map<String, String> getErrores() {
		return errores;
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

	public boolean isValido() {
		return errores.size() == 0;
	}

}
