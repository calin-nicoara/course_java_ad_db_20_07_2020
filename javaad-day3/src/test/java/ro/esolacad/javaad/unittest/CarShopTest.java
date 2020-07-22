package ro.esolacad.javaad.unittest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CarShopTest {

    @Test
    public void testRepairCar() {
        InvoiceCalculator invoiceCalculator = Mockito.mock(InvoiceCalculator.class);

        CarShop carShop = new CarShop(invoiceCalculator);

        Mockito.when(invoiceCalculator.getInvoiceValue()).thenReturn(BigDecimal.valueOf(50));

        carShop.repairCar();
//        assertEquals(BigDecimal.valueOf(50), carShop.repairCar());

        Mockito.verify(invoiceCalculator, Mockito.times(1)).getInvoiceValue();

        Mockito.verifyNoMoreInteractions(invoiceCalculator);
    }

}
