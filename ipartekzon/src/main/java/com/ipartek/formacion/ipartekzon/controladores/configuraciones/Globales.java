package com.ipartek.formacion.ipartekzon.controladores.configuraciones;

import com.ipartek.formacion.ipartekzon.logicanegocio.ClienteNegocio;
import com.ipartek.formacion.ipartekzon.logicanegocio.ClienteNegocioImpl;
import com.ipartek.formacion.ipartekzon.logicanegocio.EmpleadoNegocio;
import com.ipartek.formacion.ipartekzon.logicanegocio.EmpleadoNegocioImpl;

public class Globales {
	public static final String VISTAS = "/WEB-INF/vistas";
	
	public static final ClienteNegocio CLIENTE_NEGOCIO = new ClienteNegocioImpl();
	public static final EmpleadoNegocio EMPLEADO_NEGOCIO = new EmpleadoNegocioImpl();
}
