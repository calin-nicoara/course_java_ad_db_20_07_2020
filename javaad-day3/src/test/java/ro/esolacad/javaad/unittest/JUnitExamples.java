package ro.esolacad.javaad.unittest;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import ro.esolacad.javaad.csvlab.Citizen;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitExamples {

    @Test
    public void testAssertEquals() {
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5);

//        assert TestJunit.getList().equals(expectedList);

        assertEquals(expectedList,TestJunit.getList());

        assertNotEquals(Arrays.asList(1, 2), TestJunit.getList());

        assertNotSame(expectedList, TestJunit.getList());
        assertSame(expectedList, expectedList);
    }

    @Test
    public void testAssertEquals2() {
        Citizen expectedCitizen = new Citizen(1L, "Daniel Cojocaru", LocalDate.of(1991, 1, 1), false);
        Citizen actualCitizen = new Citizen(1L, "Daniel Cojocaru", LocalDate.of(1990, 1, 1), false);

        assertEquals(expectedCitizen, actualCitizen);
    }

    @Test
    public void testList() {
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actualList = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertIterableEquals(expectedList, actualList);

        List<String> expectedStringList = Arrays.asList("Hello", "World");
        List<String> actualStringList = Arrays.asList("Hello", "World!");

        assertLinesMatch(expectedStringList, actualStringList);
    }

    @Test
    public void testAssertAll() {
        Citizen expectedCitizen = new Citizen(1L, "Daniel Cojocaru", LocalDate.of(1991, 1, 1), false);

        assertAll("Test getters",
                () -> assertEquals(1L, expectedCitizen.getId()),
                () -> assertEquals("Daniel Cojocaru", expectedCitizen.getName())
        );
    }

    @Test
    public void testAssumption() {
        Citizen expectedCitizen = new Citizen(1L, "Daniel Cojocaru", LocalDate.of(1991, 1, 1), false);

        Assumptions.assumeTrue(expectedCitizen.getId() == 2L);

        fail();
    }

    @Test
    public void testException() {
        CarShop carShop = new CarShop(new InvoiceCalculator());

        RuntimeException runtimeException = assertThrows(RuntimeException.class, carShop::repairCar);

        assertEquals("No invoice found!", runtimeException.getMessage());
    }
}










