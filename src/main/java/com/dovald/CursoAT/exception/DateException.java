package com.dovald.CursoAT.exception;

public class DateException extends Exception {

	private static final long serialVersionUID = -2919794563574806225L;
	
	public static final String MSG = "La fecha de inicio tiene que ser anterior a la de finalización";
	
	public DateException() {
		super(MSG);
	}
}
