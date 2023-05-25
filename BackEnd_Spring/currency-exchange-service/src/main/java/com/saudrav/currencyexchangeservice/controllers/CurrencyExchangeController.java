package com.saudrav.currencyexchangeservice.controllers;

import com.saudrav.currencyexchangeservice.entity.Currency;
import com.saudrav.currencyexchangeservice.exceptions.CurrencyRecordAlreadyAddedException;
import com.saudrav.currencyexchangeservice.exceptions.CurrencyRecordNotFoundException;
import com.saudrav.currencyexchangeservice.exceptions.CurrencySearchInvalidValueException;
import com.saudrav.currencyexchangeservice.model.CurrencyModel;
import com.saudrav.currencyexchangeservice.services.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;
    
    @Autowired
    private Environment environment;


    @GetMapping("/all")
    public List<Currency> getAllCurrencyExchange() {
        Optional<List<Currency>> currencylist = currencyExchangeService.getAllCurrencyExchange();
        
        return currencylist
                .orElseThrow(() -> new CurrencyRecordNotFoundException("No Record found, please contact admin"));

//        if(currencylist != null) {
//            return currencylist;        	
//        }
//        else{
//    		throw new CurrencyRecordNotFoundException("No Record found, please contact admin");
//    	}
        
    }

    @GetMapping("/{currFrom}/to/{currTo}")
    public CurrencyModel getCurrencyExchange(@PathVariable String currFrom, @PathVariable String currTo) {
        Currency currency =  currencyExchangeService.getCurrencyFromTo(currFrom, currTo);
        CurrencyModel cm = new CurrencyModel(currency.getId(), currency.getCurrencyFrom(), currency.getCurrencyTo(),
        							currency.getCurrencyRate(), environment.getProperty("local.server.port"));
        return cm;
    }
    
    @PostMapping("/addcurrency")
    public String addNewCurrencyExchange(@RequestBody Currency currency) {
        String addRecordStatus = currencyExchangeService.addNewCurrencyExchange(currency);
        if(addRecordStatus.equals("Records added Successfully")) {
        	return addRecordStatus;
        }
        else {
        	throw new CurrencyRecordAlreadyAddedException("Records already added, please check");
        }
    }    

    @PutMapping("/modifycurrency")
    public String modifyCurrencyExchange(@RequestBody Currency currency) {
        return currencyExchangeService.modifyCurrencyExchange(currency);
    }
    
    @DeleteMapping("/deletecurrency")
    public String deleteCurrencyExchange(@RequestParam("id") int id) {
        return currencyExchangeService.deleteCurrencyExchange(id);
    } 

}
