
package com.example.chosenone;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BalanceService {

    // saldo = suma wpłat - suma naliczeń
    // liczone dla JEDNEGO członka, uwzględniając tylko zdarzenia do dnia 'asOf'
    // włącznie
    public BigDecimal balance(Long memberId,
            List<Charge> charges,
            List<Payment> payments,
            LocalDate asOf) {

        BigDecimal sumOfPayments = null; // TODO: strumień po payments
        BigDecimal sumOfCharges = null; // TODO: strumień po charges

        return sumOfPayments.subtract(sumOfCharges);
    }

    public boolean isSettled(Long memberId,
            List<Charge> charges,
            List<Payment> payments,
            LocalDate asOf) {
        // TODO: jedna linijka - użyj balance(...) i compareTo(BigDecimal.ZERO)
        return false;
    }
}