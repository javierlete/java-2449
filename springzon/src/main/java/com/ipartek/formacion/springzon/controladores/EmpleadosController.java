package com.ipartek.formacion.springzon.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.springzon.servicios.EmpleadoService;

import jakarta.annotation.security.RolesAllowed;

@Controller
@RolesAllowed({"ADMIN"})
@RequestMapping("/admin/empleados")
public class EmpleadosController {
	@Autowired
	private EmpleadoService servicio;
	
	@GetMapping
	public String listado(Model modelo) {
		modelo.addAttribute("empleados", servicio.listadoConJefes());
		return "admin/empleados";
	}
	
	@GetMapping("/anadir")
	public String anadir() {
		return "admin/empleado";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("empleado", servicio.obtenerPorId(id));
		modelo.addAttribute("jefes", servicio.listado());
		
		return "admin/empleado";
	}
}
