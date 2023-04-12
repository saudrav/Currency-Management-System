package com.saudrav.currencyexchangeservice.exceptions;


public class CurrencyRecordNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CurrencyRecordNotFoundException(String message) {
		super(message);
	}

}
