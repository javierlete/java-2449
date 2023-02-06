package com.ipartek.formacion.bases.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) {
		System.out.println("Arrancando servidor");

		try (ServerSocket ss = new ServerSocket(1234); // Abrir el puerto 1234 en el ordenador
				Socket s = ss.accept(); // Espera a recibir una conexión
				Scanner sc = new Scanner(s.getInputStream()); // Canal para leer lo que llega
				PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTO_FLUSH) // Canal para escribir lo que queremos enviar
						) {
			pw.println("Bienvenido al servidor MAYUSCULATOR"); // Enviamos al cliente el texto

			String texto = sc.nextLine(); // Quedamos esperando la recepción de un texto

			pw.println(texto.toUpperCase()); // Enviamos el texto convertido a mayúsculas al cliente
		} catch (IOException e) {
			System.err.println("Error en el servidor");
		}
	}
}
