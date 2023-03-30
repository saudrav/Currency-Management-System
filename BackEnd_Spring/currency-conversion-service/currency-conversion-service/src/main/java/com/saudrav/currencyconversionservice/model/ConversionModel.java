package com.saudrav.currencyconversionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversionModel {

	private int id;
    private String currencyFrom;
    private String currencyTo;
    private double currencyRate;
    private int qantity;
    private double netAmount;
    private String environment;
    
}
