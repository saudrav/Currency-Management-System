package com.saudrav.currencyexchangeservice.exceptions;


public class CurrencyRecordAlreadyAddedException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CurrencyRecordAlreadyAddedException(String message) {
		super(message);
	}

}
