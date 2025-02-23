package com.crewmeister.cmcodingchallenge.exchangerate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    List<ExchangeRate> findByCurrencyCode(String currencyCode);
    List<ExchangeRate> findByCurrencyCodeAndDate(String currencyCode, LocalDate date);
} 