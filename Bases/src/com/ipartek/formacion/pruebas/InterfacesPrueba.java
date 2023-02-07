package com.ipartek.formacion.pruebas;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.poo.interfaces.Balon;
import com.ipartek.formacion.poo.interfaces.Comestible;
import com.ipartek.formacion.poo.interfaces.Naranja;
import com.ipartek.formacion.poo.interfaces.Rodable;

public class InterfacesPrueba {
	public static void main(String[] args) {
		List<Rodable> rodables = new ArrayList<>();
		
		rodables.add(new Balon());
		rodables.add(new Naranja());
		
		for(Rodable rodable: rodables) {
			if(rodable instanceof Comestible) {
				Comestible comestible = (Comestible)rodable;
				comestible.comer();
			}
			
			rodable.rodar();
			
			if(rodable instanceof Comestible comestible) {
				comestible.comer();
			}
			
		}
	}
}
