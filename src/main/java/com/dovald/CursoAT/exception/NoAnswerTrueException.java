package com.dovald.CursoAT.exception;

public class NoAnswerTrueException extends Exception {

	private static final long serialVersionUID = -2919794563574806225L;
	
	public static final String MSG = "Una pregunta debe tener una respuesta correcta";
	
	public NoAnswerTrueException() {
		super(MSG);
	}
}
