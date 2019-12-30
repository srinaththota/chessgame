package com.chessgame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SomethingWrongException {

	@ExceptionHandler(value = WrongMovesException.class)
	public ResponseEntity<Object> exception(WrongMovesException exception) {
	      return new ResponseEntity<>("Invalid Move", HttpStatus.NOT_FOUND);
	   }
		
}
