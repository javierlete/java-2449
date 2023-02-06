package com.ipartek.formacion.bases.hilos;

public class Carrera {
	public static void main(String[] args) {
		Corredor c1 = new Corredor(1);
		Corredor c2 = new Corredor(2);
		
		c1.start();
		c2.start();
	}
}
