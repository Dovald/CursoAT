package com.dovald.CursoAT.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dovald.CursoAT.dto.ErrorDTO;
import com.dovald.CursoAT.exception.DuplicatedKeyException;
import com.dovald.CursoAT.exception.EmptyFieldException;
import com.dovald.CursoAT.exception.MaxNumberException;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.exception.TrueException;

@ControllerAdvice(basePackages = {"com.dovald.CursoAT.controller"})
public class ControllerAdviceV1 {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDTO> error(NotFoundException e)
	{
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicatedKeyException.class)
	public ResponseEntity<ErrorDTO> error(DuplicatedKeyException e)
	{
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MaxNumberException.class)
	public ResponseEntity<ErrorDTO> error(MaxNumberException e)
	{
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TrueException.class)
	public ResponseEntity<ErrorDTO> error(TrueException e)
	{
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyFieldException.class)
	public ResponseEntity<ErrorDTO> error(EmptyFieldException e)
	{
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
	}

}
