package com.crewmeister.cmcodingchallenge.exchangerate.dto;

public class CurrencyConversionResponse {
    private String fromCurrency;
    private String toCurrency;
    private Double amount;
    private Double convertedAmount;
    private Double rate;

    public CurrencyConversionResponse() {}

    public CurrencyConversionResponse(String fromCurrency, String toCurrency, Double amount, Double convertedAmount, Double rate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.rate = rate;
    }

    // Getters and Setters
    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
} 