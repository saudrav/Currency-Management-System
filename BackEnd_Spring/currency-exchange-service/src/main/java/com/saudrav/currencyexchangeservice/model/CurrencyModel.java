package com.saudrav.currencyexchangeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyModel {

    private int id;
    private String currencyFrom;
    private String currencyTo;
    private double currencyRate;
    private String environment;

}
