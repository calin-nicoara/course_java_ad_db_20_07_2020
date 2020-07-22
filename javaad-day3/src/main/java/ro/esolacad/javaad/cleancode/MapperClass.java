package ro.esolacad.javaad.cleancode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ro.esolacad.javaad.csvlab.Citizen;

public class MapperClass {

    public static List<LocalDate> getForeignersBirthDays() {
        List<Citizen> citizens = Arrays.asList(
                new Citizen(1L, "Daniel Cojocaru", LocalDate.of(1991, 1, 1), false),
                new Citizen(2L, "Ana Dumitru", LocalDate.of(1980, 1, 1), false),
                new Citizen(3L, "John sMith", LocalDate.of(1970, 2, 1), true)
        );

        return citizens.stream()
                .filter(Citizen::isForeigner)
                .map(Citizen::getDateOfBirth)
                .collect(Collectors.toList());
    }
}
