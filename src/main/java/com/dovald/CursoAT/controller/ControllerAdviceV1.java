package com.dovald.CursoAT.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dovald.CursoAT.dto.ErrorDTO;
import com.dovald.CursoAT.exception.DuplicatedKeyException;
import com.dovald.CursoAT.exception.NotFoundException;

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
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.PRECONDITION_FAILED);
	}

}
