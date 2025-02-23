package com.crewmeister.cmcodingchallenge.exchangerate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    List<ExchangeRate> findByCurrencyCode(String currencyCode);
    Optional<ExchangeRate> findByCurrencyCodeAndDate(String currencyCode, LocalDate date);
} 