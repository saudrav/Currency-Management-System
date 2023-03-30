package com.saudrav.currencyexchangeservice.services;

import com.saudrav.currencyexchangeservice.entity.Currency;

import java.util.List;

public interface CurrencyExchangeService {

    public Currency getCurrencyFromTo(String currFrom, String currTo);

    public List<Currency> getAllCurrencyExchange();
    
    public String addNewCurrencyExchange(Currency currency);

	public String modifyCurrencyExchange(Currency currency);

	public String deleteCurrencyExchange(int id);
}
