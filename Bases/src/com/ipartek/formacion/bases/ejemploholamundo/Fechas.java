package com.ipartek.formacion.bases.ejemploholamundo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Fechas {
	public static void main(String[] args) {
		LocalDate hoy = LocalDate.now();
		System.out.println(hoy);
		
		LocalTime ahora = LocalTime.now();
		System.out.println(ahora);
		
		LocalDateTime todoJunto = LocalDateTime.now();
		System.out.println(todoJunto);
		
		LocalDateTime fechaHoraInicioCurso = LocalDateTime.of(2023, 1, 25, 8, 0);
		System.out.println(fechaHoraInicioCurso);
		
		System.out.println(hoy.plusMonths(1));
		
		LocalDate fechaInicioCurso = fechaHoraInicioCurso.toLocalDate();
		
		System.out.println(fechaInicioCurso.until(hoy).getDays());
		
		Scanner sc = new Scanner(System.in);
		
		String fechaEnTexto = sc.nextLine();
		
		LocalDate fecha = LocalDate.parse(fechaEnTexto);
		System.out.println(fecha);
		
		fechaEnTexto = sc.nextLine();
		
		DateTimeFormatter formatoEspanol = DateTimeFormatter.ofPattern("d/M/y");
		LocalDate fechaEspanol = LocalDate.parse(fechaEnTexto, formatoEspanol);
		System.out.println(fechaEspanol.format(formatoEspanol));
		System.out.println(fechaEspanol.getMonthValue());
		
		DateTimeFormatter formatoEuskera = DateTimeFormatter.ofPattern("M/d/y");
		LocalDate fechaEuskera = LocalDate.parse(fechaEnTexto, formatoEuskera);
		System.out.println(fechaEuskera.format(formatoEuskera));
		System.out.println(fechaEuskera.getMonthValue());
		
		sc.close();
	}
}
