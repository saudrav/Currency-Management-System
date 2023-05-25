package com.saudrav.currencyexchangeservice.exceptions;


public class CurrencySearchInvalidValueException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CurrencySearchInvalidValueException(String message) {
		super(message);
	}

}
