package com.saudrav.currencyconversionservice.util;

import org.springframework.stereotype.Component;

@Component
public class ConversionUtil {
	
	public double totalCalculatedAmount(double currRate, int qnt) {
		return currRate*qnt;
	}

}
