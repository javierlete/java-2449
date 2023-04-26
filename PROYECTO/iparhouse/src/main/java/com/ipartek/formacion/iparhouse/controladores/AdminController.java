package com.ipartek.formacion.iparhouse.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@GetMapping("/inmuebles")
	public String inmuebles() {
		return "admin";
	}
	
	@GetMapping("/resumen")
	public String resumen() {
		return "resumen";
	}
}
