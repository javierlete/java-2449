package com.ipartek.formacion.iparhouse.controladores;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.iparhouse.entidades.Inmueble;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@GetMapping("/inmuebles")
	public String inmuebles(Model modelo) {
		List<Inmueble> inmuebles = new ArrayList<>();

		Inmueble inmueble1 = Inmueble.builder().id(1L).nombre("Casa en la playa").direccion("Calle 123")
				.tipo("Alquiler").precio(new BigDecimal("1500.00")).build();

		Inmueble inmueble2 = Inmueble.builder().id(2L).nombre("Apartamento en la ciudad").direccion("Avenida 456")
				.tipo("Venta").precio(new BigDecimal("200000.00")).build();

		inmuebles.add(inmueble1);
		inmuebles.add(inmueble2);

		modelo.addAttribute("inmuebles", inmuebles);
		modelo.addAttribute("inmueble", inmueble1);
		
		return "admin";
	}
	
	@GetMapping("/resumen")
	public String resumen(Model modelo) {
		List<Inmueble> inmuebles = new ArrayList<>();

		Inmueble inmueble1 = Inmueble.builder().id(1L).nombre("Casa en la playa").direccion("Calle 123")
				.tipo("Alquiler").precio(new BigDecimal("1500.00")).build();

		Inmueble inmueble2 = Inmueble.builder().id(2L).nombre("Apartamento en la ciudad").direccion("Avenida 456")
				.tipo("Venta").precio(new BigDecimal("200000.00")).build();

		inmuebles.add(inmueble1);
		inmuebles.add(inmueble2);

		modelo.addAttribute("inmuebles", inmuebles);
		modelo.addAttribute("inmueble", inmueble1);
		modelo.addAttribute("total", new BigDecimal("1234567"));
		modelo.addAttribute("servicios", new String[] {"Cocina", "Baño", "Nevera"});
		
		return "resumen";
	}
}
