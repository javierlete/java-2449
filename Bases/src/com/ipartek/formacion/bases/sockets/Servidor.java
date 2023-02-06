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

		try (ServerSocket ss = new ServerSocket(1234);
				Socket s = ss.accept();
				Scanner sc = new Scanner(s.getInputStream());
				PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTO_FLUSH)) {
			pw.println("Bienvenido al servidor MAYUSCULATOR");

			String texto = sc.nextLine();

			pw.println(texto.toUpperCase());
		} catch (IOException e) {
			System.err.println("Error en el servidor");
		}
	}
}
