package com.saudrav.currencyexchangeservice.services;

import com.saudrav.currencyexchangeservice.entity.Currency;
import com.saudrav.currencyexchangeservice.exceptions.CurrencyRecordNotFoundException;
import com.saudrav.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

//    public CurrencyExchangeServiceImpl(CurrencyExchangeRepository currencyExchangeRepository) {
//        this.currencyExchangeRepository = currencyExchangeRepository;
//    }

    @Override
    public Currency getCurrencyFromTo(String currFrom, String currTo) {
    	System.out.println(currFrom);
    	System.out.println(currTo);
        return currencyExchangeRepository.findByCurrencyFromAndCurrencyTo(currFrom, currTo);
    }

    @Override
    public List<Currency> getAllCurrencyExchange() {
    	try {
        return currencyExchangeRepository.findAll();
    	}catch (Exception e) {
    		throw new CurrencyRecordNotFoundException("No Record found, please contact admin");
    	}
    	
    }

	@Override
	public String addNewCurrencyExchange(Currency currency) {
		if(currencyExchangeRepository.existsById(currency.getId()) || currencyExchangeRepository.findByCurrencyFromAndCurrencyTo(currency.getCurrencyFrom(),currency.getCurrencyTo())!=null) {
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
