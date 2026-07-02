
package com.example.chosenone;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BalanceService {

  
    public BigDecimal balance(Long memberId,
            List<Charge> charges,
            List<Payment> payments,
            LocalDate asOf) {

        BigDecimal sumOfPayments =  payments.stream().filter(it -> it.idOfMember().equals(memberId) && !it.date().isAfter(asOf)).map(Payment::amount).reduce(BigDecimal.ZERO, BigDecimal::add);
        
        BigDecimal sumOfCharges =  charges.stream().filter(it -> it.idOfMember().equals(memberId) && !it.dueDate().isAfter(asOf)).map(Charge::amount).reduce(BigDecimal.ZERO, BigDecimal::add);
                
        return sumOfPayments.subtract(sumOfCharges);
    }

    public boolean isSettled(Long memberId,
            List<Charge> charges,
            List<Payment> payments,
            LocalDate asOf) {
        // TODO: jedna linijka - użyj balance(...) i compareTo(BigDecimal.ZERO)
        balance(memberId, charges, payments, asOf).compareTo(BigDecimal.ZERO);
        return false;
    }
}