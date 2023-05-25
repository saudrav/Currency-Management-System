package com.saudrav.currencyexchangeservice.services;

import com.saudrav.currencyexchangeservice.entity.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyExchangeService {

    public Currency getCurrencyFromTo(String currFrom, String currTo);

    public Optional<List<Currency>> getAllCurrencyExchange();
    
    public String addNewCurrencyExchange(Currency currency);

	public String modifyCurrencyExchange(Currency currency);

	public String deleteCurrencyExchange(int id);
}
