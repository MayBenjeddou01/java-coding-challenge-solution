package com.crewmeister.cmcodingchallenge.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    public void initializeCurrencies() {
        currencyRepository.saveAll(List.of(
            new Currency("EUR", "Euro"),
            new Currency("USD", "US Dollar"),
            new Currency("GBP", "British Pound"),
            new Currency("JPY", "Japanese Yen")
        ));
    }
} 