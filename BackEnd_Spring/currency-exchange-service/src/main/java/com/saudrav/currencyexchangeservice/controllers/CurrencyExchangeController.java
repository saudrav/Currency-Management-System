package com.saudrav.currencyexchangeservice.controllers;

import com.saudrav.currencyexchangeservice.entity.Currency;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeService currencyExchangeService;
    
    @Autowired
    private Environment environment;


    @GetMapping("/currency-exchange/all")
    public List<Currency> getAllCurrencyExchange() {
        List<Currency> currencylist = currencyExchangeService.getAllCurrencyExchange();
        return currencylist;
    }

    @GetMapping("/currency-exchange/{currFrom}/to/{currTo}")
    public CurrencyModel getCurrencyExchange(@PathVariable String currFrom, @PathVariable String currTo) {
        Currency currency =  currencyExchangeService.getCurrencyFromTo(currFrom, currTo);
        CurrencyModel cm = new CurrencyModel(currency.getId(), currency.getCurrencyFrom(), currency.getCurrencyTo(),
        							currency.getCurrencyRate(), environment.getProperty("local.server.port"));
        return cm;
    }
    
    @PostMapping("/currency-exchange/addcurrency")
    public String addNewCurrencyExchange(@RequestBody Currency currency) {
        return currencyExchangeService.addNewCurrencyExchange(currency);
    }    

    @PutMapping("/currency-exchange/modifycurrency")
    public String modifyCurrencyExchange(@RequestBody Currency currency) {
        return currencyExchangeService.modifyCurrencyExchange(currency);
    }
    
    @DeleteMapping("/currency-exchange/deletecurrency")
    public String deleteCurrencyExchange(@RequestParam("id") int id) {
        return currencyExchangeService.deleteCurrencyExchange(id);
    } 

}
