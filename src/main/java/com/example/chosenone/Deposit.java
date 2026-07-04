package com.example.chosenone;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Deposit(Long idOfMember, BigDecimal amount, LocalDate date) {
    public Deposit {
        if (idOfMember == null || idOfMember < 0) {
            throw new IllegalArgumentException("Id of member cannot be null");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount cannot be null");
        }
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
    }
}