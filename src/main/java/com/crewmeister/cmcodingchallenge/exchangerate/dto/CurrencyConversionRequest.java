package com.crewmeister.cmcodingchallenge.exchangerate.dto;

import java.time.LocalDate;

public class CurrencyConversionRequest {
    private String fromCurrency;
    private Double amount;
    private LocalDate date;

    public CurrencyConversionRequest() {}

    public CurrencyConversionRequest(String fromCurrency, Double amount, LocalDate date) {
        this.fromCurrency = fromCurrency;
        this.amount = amount;
        this.date = date;
    }

    // Getters and Setters
    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
} 