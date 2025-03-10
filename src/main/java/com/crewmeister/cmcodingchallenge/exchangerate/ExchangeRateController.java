package com.crewmeister.cmcodingchallenge.exchangerate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import com.crewmeister.cmcodingchallenge.exchangerate.dto.CurrencyConversionRequest;
import com.crewmeister.cmcodingchallenge.exchangerate.dto.CurrencyConversionResponse;

@RestController
@RequestMapping("/api")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @Autowired
    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/exchange-rates/{currencyCode}")
    public ResponseEntity<List<ExchangeRate>> getAllExchangeRates(@PathVariable String currencyCode) {
        List<ExchangeRate> rates = exchangeRateService.getAllExchangeRates(currencyCode);
        return ResponseEntity.ok(rates);
    }

    @GetMapping("/exchange-rates/{currencyCode}/date/{date}")
    public ResponseEntity<ExchangeRate> getExchangeRateByDate(
            @PathVariable String currencyCode,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(exchangeRateService.getExchangeRateByDate(currencyCode, date));
    }

    @PostMapping("/convert")
    public ResponseEntity<CurrencyConversionResponse> convertCurrency(@RequestBody CurrencyConversionRequest request) {
        return ResponseEntity.ok(exchangeRateService.convertCurrency(
            request.getFromCurrency(),
            request.getAmount(),
            request.getDate()
        ));
    }
} 