package com.dovald.CursoAT.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dovald.CursoAT.dto.ErrorDTO;
import com.dovald.CursoAT.exception.NotFoundException;

@ResponseBody
@ControllerAdvice(basePackages = {"com.dovald.CursoAT.controller"})
public class ControllerAdviceV1 {
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDTO error(NotFoundException e)
	{
		return new ErrorDTO(e.getMessage());
	}

}
