package ro.esolacad.javaad.unittest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDate;
import java.util.stream.Stream;

import ro.esolacad.javaad.csvlab.Citizen;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedExampleTest {
//    @Test
//    public void testCalculator() {
//        Calculator calculator = new Calculator();
//
//        int actualValue = calculator.calculate(10, 30);
//        assertEquals(80, actualValue);
//    }
//
//    @Test
//    public void testCalculator2() {
//        Calculator calculator = new Calculator();
//
//        int actualValue = calculator.calculate(15, 30);
//        assertEquals(25, actualValue);
//    }
//
//    @Test
//    public void testCalculator3() {
//        Calculator calculator = new Calculator();
//
//        int actualValue = calculator.calculate(15, 20);
//        assertEquals(35, actualValue);
//    }

    @ParameterizedTest
    @CsvSource({"10,30,80", "15,30,25", "15,20,35"})
    public void testCalculatorParameterized(int firstParam, int secondParam, int expectedResult) {
        Calculator calculator = new Calculator();

        int actualValue = calculator.calculate(firstParam, secondParam);
        assertEquals(expectedResult, actualValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    public void isEven(int number) {
        System.out.println(number);
        assertTrue(number % 2 == 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", "bbb"})
//    @EmptySource
//    @NullSource
    public void  testParamString(String toCheck) {
        assertTrue(toCheck != null && !toCheck.trim().equals(""));
    }

    @ParameterizedTest
    @MethodSource("testForIsForeign")
    void testCitizenIsForeign(Citizen citizen) {
        System.out.println(citizen);

        assertTrue(citizen.isForeigner());
    }

    private static Stream<Arguments> testForIsForeign() {
        return Stream.of(
                Arguments.of(new Citizen(1L, "Daniel Cojocaru", LocalDate.of(1991, 1, 1), true)),
                Arguments.of(new Citizen(2L, "Ionut Cojocaru", LocalDate.of(1991, 1, 1), true)),
                Arguments.of(new Citizen(3L, "Mirela Cojocaru", LocalDate.of(1991, 1, 1), true))
        );
    }
}








