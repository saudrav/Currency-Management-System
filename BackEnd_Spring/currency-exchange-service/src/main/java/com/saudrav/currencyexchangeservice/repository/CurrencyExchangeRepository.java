package com.saudrav.currencyexchangeservice.repository;

import com.saudrav.currencyexchangeservice.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<Currency, Integer> {

	@Query("SELECT c FROM Currency c WHERE c.currencyFrom = ?1 AND c.currencyTo = ?2")
    Currency findByCurrencyFromAndCurrencyTo(String currFrom, String currTo);
}
