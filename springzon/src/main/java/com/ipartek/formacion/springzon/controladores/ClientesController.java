package com.ipartek.formacion.springzon.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springzon.entidades.Cliente;
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
	
	@GetMapping("/anadir")
	public String anadir(Cliente cliente) {
		return "admin/cliente";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("cliente", servicio.consultarPorId(id));
		
		return "admin/cliente";
	}
	
	@GetMapping("/borrar/{id}")
	public String editar(@PathVariable Long id) {
		servicio.eliminar(id);
		
		return "redirect:/admin/clientes";
	}
	
	@PostMapping
	public String guardar(@Validated Cliente cliente, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "admin/cliente";
		}
		
		if(cliente.getId() == null) {
			servicio.cambiar(cliente);
		} else {
			servicio.nuevo(cliente);
		}
		
		return "redirect:/admin/clientes";
	}
}
