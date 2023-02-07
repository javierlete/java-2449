package com.ipartek.formacion.bases.hilos;

import java.util.Random;

import com.ipartek.formacion.poo.Persona;

public class Corredor extends Persona implements Runnable {
	private static final long serialVersionUID = 553866882458666000L;

	private static final int META = 10;
	
	private Integer dorsal;
	private Integer posicion;

	public Corredor(Integer dorsal) {
		this.dorsal = dorsal;
	}
	
	@Override
	public void run() {
		for (posicion = 0; posicion <= META; posicion++) {
			try {
				Thread.sleep(new Random().nextLong(1, 1000));
			} catch (InterruptedException e) {
				// No hacemos nada ya que queremos que se interrumpa
			}
			System.out.println(dorsal + ": " + posicion);
		}
	}
}
