package com.ipartek.formacion.bases.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) {
		System.out.println("Arrancando cliente");
		
		try (Socket s = new Socket(
				"localhost", 1234); // Conectamos al servidor que está en la IP de localhost (nuestro propio ordenador) y al servicio que está activo en el puerto 1234
				Scanner sc = new Scanner(s.getInputStream());
				PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTO_FLUSH)) {
			String texto = sc.nextLine();
			
			System.out.println("SERVIDOR: " + texto);
			
			pw.println("Texto a convertir a mayúsculas");
			
			texto = sc.nextLine();
			
			System.out.println("SERVIDOR: " + texto);
		} catch (IOException e) {
			System.err.println("Error en el cliente");
			System.err.println(e);
		}
	}
}
