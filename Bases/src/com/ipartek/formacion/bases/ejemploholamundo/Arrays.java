package com.ipartek.formacion.bases.ejemploholamundo;

public class Arrays {
	public static void main(String[] args) {
		int tamano = 2;
		int[] arr = new int[tamano];
		
		arr[0] = 5;
		arr[1] = 6;
//		arr[2] = 7; // No se puede acceder a este elemento
		// Da una excepción
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		System.out.println(arr.length);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		for(int dato: arr) {
			System.out.println(dato);
		}
		
		String[][] tablero = new String[8][8];
		
		for(int fila = 0; fila < tablero.length; fila++) {
			for(int columna = 0; columna < tablero[fila].length; columna++) {
				tablero[fila][columna] = ".";
			}
		}
		
		tablero[0][0] = "T";
		tablero[0][1] = "C";
		tablero[0][2] = "A";
		tablero[1][0] = "P";
		tablero[7][3] = "R";
		
		for(String[] fila: tablero) {
			for(String casilla: fila) {
				System.out.print(casilla + " ");
			}
			
			System.out.println();
		}
	}
}
