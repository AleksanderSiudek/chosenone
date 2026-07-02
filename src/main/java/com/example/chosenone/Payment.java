package com.example.chosenone;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Payment(String idOfMember, BigDecimal amount, LocalDate data) {
    public Payment { // <- bez nawiasów z parametrami! to konstruktor kompaktowy
        if (idOfMember == null || idOfMember.isBlank()) {
            throw new IllegalArgumentException("Id of member cannot be null");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount cannot be null");
        }
        if (data == null) {
            throw new IllegalArgumentException("date cannot be null");
        }
    }
}