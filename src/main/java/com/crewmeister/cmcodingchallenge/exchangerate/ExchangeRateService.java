package com.crewmeister.cmcodingchallenge.exchangerate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import com.crewmeister.cmcodingchallenge.exchangerate.dto.CurrencyConversionResponse;

@Service
public class ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    @Autowired
    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public List<ExchangeRate> getAllExchangeRates(String currencyCode) {
        return exchangeRateRepository.findByCurrencyCode(currencyCode);
    }

    public ExchangeRate getExchangeRateByDate(String currencyCode, LocalDate date) {
        return exchangeRateRepository.findByCurrencyCodeAndDate(currencyCode, date)
            .stream()
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Exchange rate not found for currency " + currencyCode + " on date " + date));
    }

    // Méthode pour initialiser quelques données de test
    public void initializeTestData() {
        exchangeRateRepository.saveAll(List.of(
            new ExchangeRate("USD", LocalDate.now(), 1.1),
            new ExchangeRate("USD", LocalDate.now().minusDays(1), 1.2),
            new ExchangeRate("GBP", LocalDate.now(), 0.85),
            new ExchangeRate("GBP", LocalDate.now().minusDays(1), 0.86)
        ));
    }

    public CurrencyConversionResponse convertCurrency(String fromCurrency, Double amount, LocalDate date) {
        ExchangeRate rate = exchangeRateRepository.findByCurrencyCodeAndDate(fromCurrency, date)
                .orElseThrow(() -> new RuntimeException("Exchange rate not found for currency " + fromCurrency + " on date " + date));
        
        Double convertedAmount = amount / rate.getRate();
        
        return new CurrencyConversionResponse(
            fromCurrency,
            "EUR",
            amount,
            convertedAmount,
            rate.getRate()
        );
    }
} 