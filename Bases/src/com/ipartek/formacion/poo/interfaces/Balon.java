package com.ipartek.formacion.poo.interfaces;

public class Balon extends ObjetoDeporte implements Rodable {

	@Override
	public void rodar() {
		System.out.println("Balón rodando");
	}

}
