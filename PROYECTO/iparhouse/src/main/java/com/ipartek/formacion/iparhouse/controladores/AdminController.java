package com.ipartek.formacion.iparhouse.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.iparhouse.entidades.Inmueble;
import com.ipartek.formacion.iparhouse.entidades.Servicio;
import com.ipartek.formacion.iparhouse.servicios.PrivadoService;
import com.ipartek.formacion.iparhouse.servicios.PublicoService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private PublicoService servicioPublico;
	
	@Autowired
	private PrivadoService servicioPrivado;
	
	@GetMapping("/inmuebles")
	public String inmuebles(Model modelo, Inmueble inmueble, Servicio servicio) {
		modelo.addAttribute("inmuebles", servicioPublico.listado());
		
		return "admin";
	}
	
	@GetMapping("/resumen")
	public String resumen(Model modelo) {
		modelo.addAttribute("inmuebles", servicioPrivado.listadoOrdenado());
		modelo.addAttribute("inmueble", servicioPrivado.primeroConCocina());
		modelo.addAttribute("total", servicioPrivado.precioTotalAlquiler3Habitaciones());
		modelo.addAttribute("servicios", servicioPrivado.listadoServicios());
		
		return "resumen";
	}
	
	@GetMapping("/inmuebles/editar/{id}") 
	public String editar(@PathVariable Long id, Model modelo, Servicio servicio) {
		modelo.addAttribute("inmueble", servicioPublico.detalle(id));
		modelo.addAttribute("servicios", servicioPublico.serviciosDeInmueble(id));
		modelo.addAttribute("inmuebles", servicioPublico.listado());
		
		return "admin";
	}
	
	@PostMapping("/inmuebles")
	public String guardar(Inmueble inmueble) {
		if(inmueble.getId() == null) {
			servicioPrivado.insertar(inmueble);
		} else {
			servicioPrivado.modificar(inmueble);
		}
		
		return "redirect:/admin/inmuebles";
	}
	
	@GetMapping("/inmuebles/borrar/{id}")
	public String eliminar(@PathVariable Long id) {
		servicioPrivado.borrar(id);
		
		return "redirect:/admin/inmuebles";
	}
	
	@PostMapping("/inmuebles/servicios/guardar")
	public String guardarServicio(Servicio servicio, Long idInmueble) {
		Inmueble inmueble = servicioPublico.detalle(idInmueble);
		servicio.setInmueble(inmueble);
		servicioPrivado.insertarServicio(servicio);
		
		return "redirect:/admin/inmuebles";
	}
}
