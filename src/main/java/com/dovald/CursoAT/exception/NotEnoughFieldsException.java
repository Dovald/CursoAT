package com.dovald.CursoAT.exception;

public class NotEnoughFieldsException extends Exception {

	private static final long serialVersionUID = -2919794563574806225L;
	
	public static final String MSG = "Has introducido menos de 10 respuestas";
	
	public NotEnoughFieldsException() {
		super(MSG);
	}

}

