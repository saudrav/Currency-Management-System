package com.saudrav.currencyexchangeservice.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.saudrav.currencyexchangeservice.entity.Currency;
import com.saudrav.currencyexchangeservice.exceptions.CurrencySearchInvalidValueException;
import com.saudrav.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.saudrav.currencyexchangeservice.services.CurrencyExchangeService;
import com.saudrav.currencyexchangeservice.services.CurrencyExchangeServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class CurrencyExchangeServiceImplTest {
	
	 @Mock
	 private CurrencyExchangeRepository currencyExchangeRepository;
	 	 
	 @InjectMocks
	 CurrencyExchangeService currencyExchangeService = new CurrencyExchangeServiceImpl();
	 
	 
	 @DisplayName("S01 - Get All Currency Exchange list - Success")
	 @Test
	 void getAllCurrencyExchange_Success_Test() {
		 
		 //Mocking
		 List<Currency> currencyList = getMockCurrencyList();		
		 
		 when(currencyExchangeRepository.findAll()).thenReturn(currencyList);
		 
		 //Actual
		 Optional<List<Currency>> actualCurrencyList = currencyExchangeService.getAllCurrencyExchange();
		 //System.out.println(actualCurrencyList.toString());
		 
		 //verification
		 verify(currencyExchangeRepository, times(1)).findAll();
		 
		 //Assert
		 assertNotNull(actualCurrencyList);
		 assertEquals(currencyList.size(), actualCurrencyList.get().size());
		 assertEquals(currencyList.get(0).getCurrencyRate(), actualCurrencyList.get().get(0).getCurrencyRate());
	 }
	 
	 

	 @DisplayName("S02(a) - Get Currency Exchange details for valid currency type - Success")
	 @Test
	 void getCurrencyExchangeDetails_Success_Test() {
		 
		 //Mocking
		 Currency currency = getMockCurrency();		
		 
		 when(currencyExchangeRepository.findByCurrencyFromAndCurrencyTo("USD", "INR")).thenReturn(Optional.of(currency));
		 
		 //Actual
		 Currency actualCurrency = currencyExchangeService.getCurrencyFromTo("USD", "INR");
		 //System.out.println(actualCurrency);
		 
		 //verification
		 verify(currencyExchangeRepository, times(1)).findByCurrencyFromAndCurrencyTo("USD", "INR");
		 
		 //Assert
		 assertNotNull(actualCurrency);
		 assertEquals(currency.getCurrencyRate(), actualCurrency.getCurrencyRate());
	 }
	 
	 
	 @DisplayName("S02(b) - Get Currency Exchange details for Invalid currency type - Failure")
	 @Test
	 void getCurrencyExchangeDetails_Failure_Test() {
		 
		 //Mocking		 
		 when(currencyExchangeRepository.findByCurrencyFromAndCurrencyTo("EUR", "INR")).thenReturn(Optional.ofNullable(null));
		 
		 //Actual
		 //Currency actualCurrency = currencyExchangeService.getCurrencyFromTo("EUR", "INR");		 
		 CurrencySearchInvalidValueException exception = 
				 assertThrows(CurrencySearchInvalidValueException.class, () -> currencyExchangeService.getCurrencyFromTo("EUR", "INR"));
		 //System.out.println(exception);
		 
		 //verification
		 verify(currencyExchangeRepository, times(1)).findByCurrencyFromAndCurrencyTo("EUR", "INR");
		 
		 //Assert
		 assertEquals("Currency Search Value is not Exist in System", exception.getMessage());
	     //assertEquals("BAD_REQUEST", exception.getStatus());

	 }

	 
	 private Currency getMockCurrency() {		 
		 return new Currency(3, "USD", "INR", 82.7);
	 }
	 
	private List<Currency> getMockCurrencyList() {		
		List<Currency> crr = new ArrayList<>();				
		crr = Stream.of(new Currency(1, "ABC", "XYZ", 46.1), new Currency(2, "PQR", "ZZZ", 40.01)).collect(Collectors.toList());
		crr.add(new Currency(3, "USD", "INR", 82.7)); 
		return crr;
	}

}
