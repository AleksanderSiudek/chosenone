
package com.example.chosenone;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class MembershipAccountService {

    public BigDecimal balance(Long memberId,
            List<Fee> fees,
            List<Deposit> deposits,
            LocalDate asOf) {

        BigDecimal totalPaid = deposits.stream()
                .filter(deposit -> deposit.idOfMember().equals(memberId) && !deposit.date().isAfter(asOf))
                .map(Deposit::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalFees = fees.stream()
                .filter(fee -> fee.idOfMember().equals(memberId) && !fee.dueDate().isAfter(asOf))
                .map(Fee::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalPaid.subtract(totalFees);
    }

    public boolean isSettled(Long memberId,
            List<Fee> fees,
            List<Deposit> deposits,
            LocalDate asOf) {
        balance(memberId, fees, deposits, asOf).compareTo(BigDecimal.ZERO);
        return false;
    }

    public List<Long> debtors(List<Fee> fees, List<Deposit> deposits, LocalDate asOf) {
       
        List<Long> sumOfDebt = fees.stream().map(it -> it.idOfMember()).toList();
       

    }
}