package com.example.chosenone;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChosenoneApplication {

	public static void main(String[] args) {
		var service = new MembershipAccountService();

		var fees = List.of(
				new Fee(1L, new BigDecimal("10.00"), LocalDate.of(2026, 7, 3), "czynsz 07/2026"),
				new Fee(2L, new BigDecimal("10.00"), LocalDate.of(2026, 7, 3), "czynsz 07/2026"));
		var deposits = List.of(
				new Deposit(1L, new BigDecimal("10.00"), LocalDate.of(2026, 7, 2)), // zapłacił całość
				new Deposit(2L, new BigDecimal("7.00"), LocalDate.of(2026, 7, 2)) // zapłacił za mało
		);

		LocalDate checkDay = LocalDate.of(2026, 7, 3);

		System.out.println("Członek 1 saldo: " + service.balance(1L, fees, deposits, checkDay)); // oczekuję: 0.00
		System.out.println("Członek 1 czysty: " + service.isSettled(1L, fees, deposits, checkDay)); // true
		System.out.println("Członek 2 saldo: " + service.balance(2L, fees, deposits, checkDay)); // oczekuję: -3.00
		System.out.println("Członek 2 czysty: " + service.isSettled(2L, fees, deposits, checkDay)); // false
	}
}