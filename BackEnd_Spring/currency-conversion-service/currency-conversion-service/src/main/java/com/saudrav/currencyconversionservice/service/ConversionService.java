package com.saudrav.currencyconversionservice.service;

import com.saudrav.currencyconversionservice.model.ConversionModel;

public interface ConversionService {

	public ConversionModel fetchCurrencyConversion(String currFrom, String currTo, int qty);
}
