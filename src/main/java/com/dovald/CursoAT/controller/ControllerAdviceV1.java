package com.dovald.CursoAT.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dovald.CursoAT.dto.ErrorDTO;
import com.dovald.CursoAT.exception.BadAnswersException;
import com.dovald.CursoAT.exception.BadFieldsException;
import com.dovald.CursoAT.exception.DateException;
import com.dovald.CursoAT.exception.DuplicatedKeyException;
import com.dovald.CursoAT.exception.EmptyFieldException;
import com.dovald.CursoAT.exception.MaxNumberException;
import com.dovald.CursoAT.exception.NoAnswerTrueException;
import com.dovald.CursoAT.exception.NotEnoughFieldsException;
import com.dovald.CursoAT.exception.NotFoundException;
import com.dovald.CursoAT.exception.RepeatQuestionsException;
import com.dovald.CursoAT.exception.TooManyFieldsException;
import com.dovald.CursoAT.exception.TwoAnswersTrueException;

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
	
	@ExceptionHandler(TwoAnswersTrueException.class)
	public ResponseEntity<ErrorDTO> error(TwoAnswersTrueException e)
	{
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoAnswerTrueException.class)
	public ResponseEntity<ErrorDTO> error(NoAnswerTrueException e)
	{
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyFieldException.class)
	public ResponseEntity<ErrorDTO> error(EmptyFieldException e)
	{
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BadAnswersException.class)
	public ResponseEntity<ErrorDTO> error(BadAnswersException e)
	{
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BadFieldsException.class)
	public ResponseEntity<ErrorDTO> error(BadFieldsException e)
	{
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TooManyFieldsException.class)
	public ResponseEntity<ErrorDTO> error(TooManyFieldsException e)
	{
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotEnoughFieldsException.class)
	public ResponseEntity<ErrorDTO> error(NotEnoughFieldsException e)
	{
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DateException.class)
	public ResponseEntity<ErrorDTO> error(DateException e)
	{
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RepeatQuestionsException.class)
	public ResponseEntity<ErrorDTO> error(RepeatQuestionsException e)
	{
		return new ResponseEntity<ErrorDTO>(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
	}

}
