package com.saudrav.currencyconversionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saudrav.currencyconversionservice.model.ConversionModel;
import com.saudrav.currencyconversionservice.service.ConversionService;

@RestController
public class ConversionController {
	
	@Autowired
	private ConversionService conversionService;
	
	
	
	@GetMapping("/currency-conversion/{currFrom}/to/{currTo}")
	public ConversionModel getConversion(@PathVariable String currFrom, @PathVariable String currTo, @RequestParam("quantity") int qty) {
		
		ConversionModel ccm = conversionService.fetchCurrencyConversion(currFrom, currTo, qty);
		return ccm;
	}

	
}
