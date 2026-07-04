
package com.example.chosenone;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MembershipAccountService {

    public BigDecimal balance(Long memberId,
            List<Charge> charges,
            List<Payment> payments,
            LocalDate asOf) {

        BigDecimal totalPayment = payments.stream()
                .filter(payment -> payment.idOfMember().equals(memberId) && !payment.date().isAfter(asOf))
                .map(Payment::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalCharge = charges.stream()
                .filter(charge -> charge.idOfMember().equals(memberId) && !charge.dueDate().isAfter(asOf))
                .map(Charge::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalPayment.subtract(totalCharge);
    }

    public boolean isSettled(Long memberId,
            List<Charge> charges,
            List<Payment> payments,
            LocalDate asOf) {
        return balance(memberId, charges, payments, asOf).compareTo(BigDecimal.ZERO) >= 0;
    }

    public List<Long> debtors(List<Charge> charges, List<Payment> payments, LocalDate asOf) {

        List<Long> debtorsId = charges.stream().map(charge -> charge.idOfMember()).distinct()
                .filter(idOfMember -> balance(idOfMember, charges, payments, asOf).compareTo(BigDecimal.ZERO) < 0)
                .toList();

        return debtorsId;
    }

    public BigDecimal totalDebt(List<Charge> charges, List<Payment> payments, LocalDate asOf) {
        List<Long> debtorIds = debtors(charges, payments, asOf);

        BigDecimal sum = BigDecimal.ZERO;
        for (Long memberId : debtorIds) {
            BigDecimal saldo = balance(memberId, charges, payments, asOf);
            sum = sum.add(saldo);
        }
        return sum;
    }
}