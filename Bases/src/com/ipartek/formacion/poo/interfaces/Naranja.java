package com.ipartek.formacion.poo.interfaces;

public class Naranja extends Fruto implements Comestible, Rodable {

	private boolean porElSuelo = false;
	
	@Override
	public void rodar() {
		System.out.println("Naranja rodando");
		porElSuelo = true;
	}

	@Override
	public void comer() {
		if(porElSuelo) {
			System.out.println("¡PUAGGGGG, qué asco!");
		} else {
			System.out.println("ÑAM, qué rica");
		}
	}

}
