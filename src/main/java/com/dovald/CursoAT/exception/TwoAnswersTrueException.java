package com.dovald.CursoAT.exception;

public class TwoAnswersTrueException extends Exception {

	private static final long serialVersionUID = -2919794563574806225L;
	
	public static final String MSG = "Una Pregunta no puede tener mas de una pregunta correcta";
	
	public TwoAnswersTrueException() {
		super(MSG);
	}
}
