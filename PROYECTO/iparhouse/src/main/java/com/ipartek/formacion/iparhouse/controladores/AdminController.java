package com.ipartek.formacion.iparhouse.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.iparhouse.entidades.Inmueble;
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
	public String inmuebles(Model modelo, Inmueble inmueble) {
		modelo.addAttribute("inmuebles", servicioPublico.listado());
		
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
	
	@GetMapping("/inmuebles/editar/{id}") 
	public String editar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("inmueble", servicioPublico.detalle(id));
		modelo.addAttribute("inmuebles", servicioPublico.listado());
		
		return "admin";
	}
	
	@PostMapping("/inmuebles")
	public String guardar(Inmueble inmueble) {
		if(inmueble.getId() == null) {
			servicio.insertar(inmueble);
		} else {
			servicio.modificar(inmueble);
		}
		
		return "redirect:/admin/inmuebles";
	}
	
	@GetMapping("/inmuebles/borrar/{id}")
	public String eliminar(@PathVariable Long id) {
		servicio.borrar(id);
		
		return "redirect:/admin/inmuebles";
	}
}
