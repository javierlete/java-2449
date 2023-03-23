package com.ipartek.formacion.clientes.modelos;

import java.util.Map;
import java.util.TreeMap;

public class ListaAmigos {
	private Map<Long, Cliente> amigos = new TreeMap<>();

	public Map<Long, Cliente> getAmigos() {
		return amigos;
	}

	public void setAmigos(Map<Long, Cliente> amigos) {
		this.amigos = amigos;
	}
}
