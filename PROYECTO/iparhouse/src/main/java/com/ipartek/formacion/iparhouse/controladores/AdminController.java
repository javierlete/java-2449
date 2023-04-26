package com.ipartek.formacion.iparhouse.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.iparhouse.servicios.PrivadoService;
import com.ipartek.formacion.iparhouse.servicios.PublicoService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private PublicoService servicioPublico;
	
	@Autowired
	private PrivadoService servicio;
	
	@GetMapping("/inmuebles")
	public String inmuebles(Model modelo) {
		modelo.addAttribute("inmuebles", servicioPublico.listado());
		modelo.addAttribute("inmueble", servicioPublico.detalle(1L));
		
		return "admin";
	}
	
	@GetMapping("/resumen")
	public String resumen(Model modelo) {
		modelo.addAttribute("inmuebles", servicio.listadoOrdenado());
		modelo.addAttribute("inmueble", servicio.primeroConCocina());
		modelo.addAttribute("total", servicio.precioTotalAlquiler3Habitaciones());
		modelo.addAttribute("servicios", servicio.listadoServicios());
		
		return "resumen";
	}
}
