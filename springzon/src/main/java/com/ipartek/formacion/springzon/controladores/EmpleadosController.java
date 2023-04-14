package com.ipartek.formacion.springzon.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		modelo.addAttribute("empleados", servicio.listado());
		return "admin/empleados";
	}
}
