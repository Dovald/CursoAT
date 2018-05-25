package com.dovald.CursoAT.exception;

public class DuplicatedKeyException extends Exception {

	private static final long serialVersionUID = -2919794563574806225L;
	
	public static final String MSG = "No se puede introducir valores duplicados";
	
	public DuplicatedKeyException() {
		super(MSG);
	}

}
