
package com.example.chosenone;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MembershipAccountService implements MembershipAccountServiceInterface {

    @Override
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

    @Override
    public boolean isSettled(Long memberId,
            List<Charge> charges,
            List<Payment> payments,
            LocalDate asOf) {
        return balance(memberId, charges, payments, asOf).compareTo(BigDecimal.ZERO) >= 0;
    }

    @Override
    public List<Long> debtors(List<Charge> charges, List<Payment> payments, LocalDate asOf) {

        List<Long> debtorsId = charges.stream().map(charge -> charge.idOfMember()).distinct()
                .filter(idOfMember -> balance(idOfMember, charges, payments, asOf).compareTo(BigDecimal.ZERO) < 0)
                .toList();

        return debtorsId;
    }

    @Override
    public BigDecimal totalDebt(List<Charge> charges, List<Payment> payments, LocalDate asOf) {
        List<Long> debtorIds = debtors(charges, payments, asOf);

        var sum = debtorIds.stream().map(memberId -> balance(memberId, charges, payments, asOf)).reduce(BigDecimal.ZERO,
                BigDecimal::add);

        return sum;
    }
}