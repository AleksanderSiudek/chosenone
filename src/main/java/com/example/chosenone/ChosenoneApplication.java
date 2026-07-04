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

		var charges = List.of(
				new Charge(1L, new BigDecimal("10.00"), LocalDate.of(2026, 7, 3), "rent 07/2026"),
				new Charge(2L, new BigDecimal("10.00"), LocalDate.of(2026, 7, 3), "rent 07/2026"));
		var payments = List.of(
				new Payment(1L, new BigDecimal("10.00"), LocalDate.of(2026, 7, 2)), // paid in full
				new Payment(2L, new BigDecimal("7.00"), LocalDate.of(2026, 7, 2)) // paid too little
		);

		LocalDate checkDay = LocalDate.of(2026, 7, 3);

		System.out.println("Member 1 balance: " + service.balance(1L, charges, payments, checkDay)); // expected: 0.00
		System.out.println("Member 1 settled: " + service.isSettled(1L, charges, payments, checkDay)); // true
		System.out.println("Member 2 balance: " + service.balance(2L, charges, payments, checkDay)); // expected: -3.00
		System.out.println("Member 2 settled: " + service.isSettled(2L, charges, payments, checkDay)); // false
	}
}