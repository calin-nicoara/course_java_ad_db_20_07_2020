package ro.esolacad.javaad.cleancode;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapperClassTest {

    @Test
    public void testMapper() {
        List<LocalDate> foreignersBirthDays = MapperClass.getForeignersBirthDays();

        assert foreignersBirthDays.size() == 1;
        assert foreignersBirthDays.get(0).equals(LocalDate.parse("1970-02-01"));
        System.out.println(foreignersBirthDays);
    }
}
