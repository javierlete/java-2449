package com.ipartek.formacion.iparhouse.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.iparhouse.modelos.Busqueda;
import com.ipartek.formacion.iparhouse.servicios.PublicoService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private PublicoService servicio;
	
	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("inmuebles", servicio.listado());
		modelo.addAttribute("inmueble", servicio.detalle(1L));
		
		return "index";
	}
	
	@PostMapping
	public String busqueda(Model modelo, Busqueda busqueda) {
		modelo.addAttribute("inmuebles", servicio.listado(busqueda));
		
		return "index";
	}
}
