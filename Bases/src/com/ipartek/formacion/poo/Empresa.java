package com.ipartek.formacion.poo;

import java.util.ArrayList;

public class Empresa {
	private Long id;
	private String nombre;
	private Persona gerente;

	private ArrayList<Persona> personas = new ArrayList<>();

	public Empresa(Long id, String nombre, Persona gerente) {
		setId(id);
		setNombre(nombre);
		setGerente(gerente);
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
		if (nombre == null || nombre.trim().length() == 0) {
			throw new IllegalArgumentException("No se aceptan nombres vacíos o nulos");
		}

		this.nombre = nombre.trim();
	}

	public Persona getGerente() {
		return gerente;
	}

	public void setGerente(Persona gerente) {
		validarPersona(gerente);
		
		this.gerente = gerente;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void contratar(Persona persona) {
		validarPersona(persona);
		
		personas.add(persona);
	}

	private void validarPersona(Persona persona) {
		if (persona == null) {
			throw new IllegalArgumentException("Necesitamos una persona");
		}
		
		if(persona.getDni() == null) {
			throw new IllegalArgumentException("La persona debe tener DNI");
		}
		
		if(!persona.isMayorDeEdad()) {
			throw new IllegalArgumentException("La persona debe ser mayor de edad");
		}
	}

	public void despedir(String nombre) {
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getNombre().equals(nombre)) {
				personas.remove(i);
				return;
			}
		}
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", gerente=" + gerente + "]";
	}
}
