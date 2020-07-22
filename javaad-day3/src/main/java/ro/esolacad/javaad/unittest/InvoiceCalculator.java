package ro.esolacad.javaad.unittest;

import java.math.BigDecimal;

public class InvoiceCalculator {
    public BigDecimal getInvoiceValue() {
        if(true) {
            throw new RuntimeException("No invoice found!");
        }

        return BigDecimal.TEN;
    }

    public void chargeMeDouble(BigDecimal value) {
        System.out.println("Charging you double: " + value.multiply(BigDecimal.valueOf(2)));
    }
}
