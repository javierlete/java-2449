package com.ipartek.formacion.clientes.accesodatos;

public class AccesoDatos extends RuntimeException {

	private static final long serialVersionUID = 9223323982058674803L;

	public AccesoDatos() {
		super();
	}

	public AccesoDatos(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccesoDatos(String message, Throwable cause) {
		super(message, cause);
	}

	public AccesoDatos(String message) {
		super(message);
	}

	public AccesoDatos(Throwable cause) {
		super(cause);
	}
}
