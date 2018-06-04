package com.dovald.CursoAT.exception;

public class RepeatQuestionsException extends Exception {

	private static final long serialVersionUID = -2919794563574806225L;
	
	public static final String MSG = "No se puede repetir preguntas dentro de un cuestionario";
	
	public RepeatQuestionsException() {
		super(MSG);
	}

}
