package ro.esolacad.javaad.unittest;

import java.math.BigDecimal;

public class CarShop {

    private final InvoiceCalculator invoiceCalculator;

    public CarShop(final InvoiceCalculator invoiceCalculator) {
        this.invoiceCalculator = invoiceCalculator;
    }

    public void repairCar() {
        System.out.println("Car is repaired");
        BigDecimal invoiceValue = invoiceCalculator.getInvoiceValue();

//        invoiceCalculator.chargeMeDouble(invoiceValue);

        System.out.println("Here is your invoice: " + invoiceValue);
    }
}
