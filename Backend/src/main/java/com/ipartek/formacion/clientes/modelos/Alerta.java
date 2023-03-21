package com.ipartek.formacion.clientes.modelos;

import java.util.Objects;

public class Alerta {
	private String texto;
	private String nivel;
	public Alerta(String texto, String nivel) {
		this.texto = texto;
		this.nivel = nivel;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nivel, texto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alerta other = (Alerta) obj;
		return Objects.equals(nivel, other.nivel) && Objects.equals(texto, other.texto);
	}
	@Override
	public String toString() {
		return "Alerta [texto=" + texto + ", nivel=" + nivel + "]";
	}
	
	
}
