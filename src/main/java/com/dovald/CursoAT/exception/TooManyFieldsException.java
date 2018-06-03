package com.dovald.CursoAT.exception;

public class TooManyFieldsException extends Exception {

	private static final long serialVersionUID = -2919794563574806225L;
	
	public static final String MSG = "Has introducido mas de 10 respuestas";
	
	public TooManyFieldsException() {
		super(MSG);
	}

}

