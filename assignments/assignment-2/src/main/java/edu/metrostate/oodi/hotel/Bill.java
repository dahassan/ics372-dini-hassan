package main.java.edu.metrostate.oodi.hotel;

import java.time.LocalDate;

public class Bill {
    private final String billNumber;
    private final LocalDate issuedOn;
    private final int total;

    public Bill(String billNumber, LocalDate issuedOn, int total) {
        this.billNumber = billNumber;
        this.issuedOn = issuedOn;
        this.total = total;
    }
    public String getBillNumber() {
        return billNumber;
    }
    public LocalDate getIssuedOn() {
        return issuedOn;
    }
    public int getTotal() {
        return total;
    }
}