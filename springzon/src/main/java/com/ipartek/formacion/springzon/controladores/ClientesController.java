package com.ipartek.formacion.springzon.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springzon.servicios.ClienteService;

@Controller
@RequestMapping("/admin/clientes")
public class ClientesController {
	@Autowired
	private ClienteService servicio;
	
	@GetMapping
	public String listado(Model modelo) {
		modelo.addAttribute("clientes", servicio.listado());
		
		return "admin/clientes";
	}
}
