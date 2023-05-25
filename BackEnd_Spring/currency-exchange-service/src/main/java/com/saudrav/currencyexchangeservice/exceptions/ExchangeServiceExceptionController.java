package com.saudrav.currencyexchangeservice.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExchangeServiceExceptionController extends Throwable {		//ResponseEntityExceptionHandler
	
	@ExceptionHandler(CurrencyRecordNotFoundException.class)
	public ResponseEntity<ErrorMapper> handleCurrencyRecordNotFoundException(CurrencyRecordNotFoundException exception) {
		ErrorMapper em = new ErrorMapper(HttpStatus.NOT_FOUND.value(), exception.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
	}
	
	@ExceptionHandler(CurrencyRecordAlreadyAddedException.class)
	public ResponseEntity<ErrorMapper> handleCurrencyRecordAlreadyAddedException(CurrencyRecordAlreadyAddedException exception) {
		ErrorMapper em = new ErrorMapper(HttpStatus.NOT_ACCEPTABLE.value(), exception.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(em);
	}
	
	@ExceptionHandler(CurrencySearchInvalidValueException.class)
	public ResponseEntity<ErrorMapper> handleCurrencySearchInvalidValueException(CurrencySearchInvalidValueException exception) {
		ErrorMapper em = new ErrorMapper(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), new Date());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(em);
	}
	
}
