package com.ipartek.formacion.bases.hilos;

public class Carrera {
	public static void main(String[] args) {
		Corredor c1 = new Corredor(1);
		Corredor c2 = new Corredor(2);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		
		t1.start();
		t2.start();
	}
}
