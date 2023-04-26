package com.ipartek.formacion.iparhouse.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.iparhouse.modelos.Busqueda;
import com.ipartek.formacion.iparhouse.servicios.PublicoService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private PublicoService servicio;

	@GetMapping
	public String index(Model modelo, Busqueda busqueda) {
		modelo.addAttribute("inmuebles", servicio.listado());

		return "index";
	}

	@PostMapping
	public String busqueda(Model modelo, Busqueda busqueda) {
		log.info(busqueda.toString());

		modelo.addAttribute("inmuebles", servicio.listado(busqueda));

		return "index";
	}

	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable Long id, Model modelo, Busqueda busqueda) {
		modelo.addAttribute("inmueble", servicio.detalle(id));
		modelo.addAttribute("inmuebles", servicio.listado());

		return "index";
	}
}
