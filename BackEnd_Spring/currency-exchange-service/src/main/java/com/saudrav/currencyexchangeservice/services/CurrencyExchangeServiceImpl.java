package com.saudrav.currencyexchangeservice.services;

import com.saudrav.currencyexchangeservice.entity.Currency;
import com.saudrav.currencyexchangeservice.exceptions.CurrencyRecordNotFoundException;
import com.saudrav.currencyexchangeservice.exceptions.CurrencySearchInvalidValueException;
import com.saudrav.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

//    public CurrencyExchangeServiceImpl(CurrencyExchangeRepository currencyExchangeRepository) {
//        this.currencyExchangeRepository = currencyExchangeRepository;
//    }
    

    @Override
    public Optional<List<Currency>> getAllCurrencyExchange() {
        return Optional.of(currencyExchangeRepository.findAll());    	
    }

    @Override
    public Currency getCurrencyFromTo(String currFrom, String currTo) {
    	
    	Optional<Currency> currency = currencyExchangeRepository.findByCurrencyFromAndCurrencyTo(currFrom, currTo);
        return currency
                .orElseThrow(() -> new CurrencySearchInvalidValueException("Currency Search Value is not Exist in System"));
    }
    

	@Override
	public String addNewCurrencyExchange(Currency currency) {
		if(currencyExchangeRepository.existsById(currency.getId()) || currencyExchangeRepository.findByCurrencyFromAndCurrencyTo(currency.getCurrencyFrom(),currency.getCurrencyTo()).isPresent()) {
			return "Records already added, please check";
		}
		currencyExchangeRepository.save(currency);
		return "Records added Successfully";
	}

	@Override
	public String modifyCurrencyExchange(Currency currency) {
		if(!currencyExchangeRepository.existsById(currency.getId())) {
			return "Records not found with id: "+currency.getId()+", please check";
		}
		currencyExchangeRepository.save(currency);
		return "Records Updated Successfully";
	}

	@Override
	public String deleteCurrencyExchange(int id) {
		currencyExchangeRepository.deleteById(id);
		return "Record deleted successfully";
	}
}
