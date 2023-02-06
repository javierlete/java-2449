package com.ipartek.formacion.bases.ejemploholamundo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ficheros {
	private static final boolean APPEND = true;

	public static void main(String[] args) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter("fichero.txt", APPEND);
			pw = new PrintWriter(fw);
			
			pw.println("Hola");
			pw.println("Qué tal");
		} catch (IOException e) {
			System.err.println("No se ha podido escribir en el fichero");
			return;
		} finally {
			if(pw != null) {
				pw.close();
			}
			
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					System.err.println("No se ha podido cerrar el fichero");
				}
			}
		}
		
		try (FileReader fr = new FileReader("fichero.txt");
				Scanner sc = new Scanner(fr)) {
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.err.println("No se ha podido leer del fichero");
			return;
		}
	}
}
