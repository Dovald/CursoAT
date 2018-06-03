package com.dovald.CursoAT.exception;

public class BadAnswersException extends Exception {

	private static final long serialVersionUID = -2919794563574806225L;
	
	public static final String MSG = "No se puede responder dos veces a la misma pregunta";
	
	public BadAnswersException() {
		super(MSG);
	}

}
