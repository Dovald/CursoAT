package com.dovald.CursoAT.exception;

public class EmptyFieldException extends Exception {

	private static final long serialVersionUID = -2919794563574806225L;
	
	public static final String MSG = "Campos obligatorios vacios";
	
	public EmptyFieldException() {
		super(MSG);
	}
}
