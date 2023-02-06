package com.ipartek.formacion.pruebas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.poo.Empleado;
import com.ipartek.formacion.poo.Empresa;
import com.ipartek.formacion.poo.Persona;

public class FicheroObjetosPrueba {
	public static void main(String[] args) {
		Persona p = new Persona("Pepe", "12345678Z", LocalDate.of(2000, 2, 3));
		Empleado e = new Empleado("   Javier   ", "12345678Z", LocalDate.of(2000, 1, 2), "1234123412341234",
				new BigDecimal("1234.56"));
		
		Empresa empresa = new Empresa(1L, "Demostración de ficheros", e);
		
		empresa.contratar(e);
		empresa.contratar(p);
		
		try (FileOutputStream fos = new FileOutputStream("empresa.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(empresa);
		} catch (IOException e1) {
			System.err.println("No se ha podido escribir la empresa");
			e1.printStackTrace();
		}
		
		try (FileInputStream fis = new FileInputStream("empresa.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			Empresa empresaLeida = (Empresa) ois.readObject();
			
			System.out.println(empresaLeida);
			
			for(Persona persona: empresaLeida.getPersonas()) {
				System.out.println(persona);
			}
		} catch (ClassNotFoundException | IOException e1) {
			System.err.println("No se ha podido leer la empresa");
			System.err.println(e1.getMessage());
		}
	}
}
