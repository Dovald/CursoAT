package com.dovald.CursoAT.exception;

public class BadFieldsException extends Exception {

	private static final long serialVersionUID = -2919794563574806225L;
	
	public static final String MSG = "Todas las respuestas tienen que ser del mismo cuestionario y por el mismo usuario";
	
	public BadFieldsException() {
		super(MSG);
	}
}