package com.dovald.CursoAT.exception;

public class NotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public static final String MSG = "No se ha encontrado el elemento solicitado";
	
	public NotFoundException() {
		super(MSG);
	}
	

}
