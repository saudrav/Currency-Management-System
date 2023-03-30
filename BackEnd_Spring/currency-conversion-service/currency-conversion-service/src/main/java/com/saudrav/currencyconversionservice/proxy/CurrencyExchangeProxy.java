package com.saudrav.currencyconversionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.saudrav.currencyconversionservice.model.ConversionModel;

//@FeignClient(name="currency-exchange", url="localhost:8000")
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/{currFrom}/to/{currTo}")
	public ConversionModel retrieveExchangeValue(@PathVariable String currFrom,	@PathVariable String currTo);

}
