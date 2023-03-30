package com.saudrav.currencyconversionservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saudrav.currencyconversionservice.model.ConversionModel;
import com.saudrav.currencyconversionservice.proxy.CurrencyExchangeProxy;
import com.saudrav.currencyconversionservice.util.ConversionUtil;

@Service
public class ConversionServiceImpl implements ConversionService {

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	@Autowired
	private ConversionUtil conversionUtil;
	
	@Override
	public ConversionModel fetchCurrencyConversion(String currFrom, String currTo, int qty) {
		
		//new RestTemplate().getForEntity(URI, resposeType, URI-Variables)		
		
		ConversionModel conversionModel = currencyExchangeProxy.retrieveExchangeValue(currFrom, currTo);
		if(conversionModel!=null) {
			conversionModel.setQantity(qty);
			conversionModel.setNetAmount(conversionUtil.totalCalculatedAmount(conversionModel.getCurrencyRate(),qty));
			return conversionModel;
		}
		else {
			return null;
		}
	}

}
