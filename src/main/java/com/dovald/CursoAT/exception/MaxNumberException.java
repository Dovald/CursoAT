package com.dovald.CursoAT.exception;

public class MaxNumberException extends Exception {

	private static final long serialVersionUID = -2919794563574806225L;
	
	public static final String MSG = "Una Pregunta no puede tener mas de cuatro respuestas";
	
	public MaxNumberException() {
		super(MSG);
	}
}
