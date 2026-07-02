package com.example.chosenone;

public class SaldoService {

    // saldo = suma wplat - suma naliczeń, dla danej osoby,
    // uwzględniając tylko zdarzenia do dnia 'naDzien' włącznie
    public BigDecimal saldo(String idCzlonka,
                            List<Naliczenie> naliczenia,
                            List<Wplata> wplaty,
                            LocalDate naDzien) {
        // TODO: dwa strumienie.
        // 1) wplaty.stream() -> filter po idCzlonka i data <= naDzien
        //    -> map do kwoty -> reduce(BigDecimal.ZERO, BigDecimal::add)
        // 2) to samo dla naliczeń (filter po terminPlatnosci <= naDzien)
        // 3) return sumaWplat.subtract(sumaNaliczen);
    }

    public boolean czyCzysty(String idCzlomka, ..., LocalDate naDzien) {
        // TODO: saldo(...) i compareTo(BigDecimal.ZERO) >= 0
    }
}