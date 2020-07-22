package ro.esolacad.javaad.csvlab;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ro.esolacad.javaad.csvlab.Citizen;
import ro.esolacad.javaad.csvlab.CitizenCsvProcessor;

class CitizenCsvProcessorTest {

    @Test
    public void writeCsv() {
        List<Citizen> citizens = Arrays.asList(
                new Citizen(1L, "Daniel Cojocaru", LocalDate.of(1991, 1, 1), false),
                new Citizen(2L, "Ana Dumitru", LocalDate.of(1980, 1, 1), false),
                new Citizen(3L, "John sMith", LocalDate.of(1970, 2, 1), true)
        );

        CitizenCsvProcessor citizenCsvProcessor = new CitizenCsvProcessor();

        citizenCsvProcessor.writeCitizens("test_csv", citizens);
    }

    @Test
    public void writeCsvWithReflection() {
        List<Citizen> citizens = Collections.singletonList(
                new Citizen(4L, "Ionut Popescu", LocalDate.of(1991, 1, 1), false)
        );

        CitizenCsvProcessor citizenCsvProcessor = new CitizenCsvProcessor();

        citizenCsvProcessor.writeCitizensWithReflection("test_csv", citizens);
    }

    @Test
    public void readCsv() throws IOException {
        Citizen citizenToTest = new Citizen(1L, "Daniel Cojocaru", LocalDate.of(1991, 1, 1), false);
        CitizenCsvProcessor citizenCsvProcessor = new CitizenCsvProcessor();

        List<Citizen> citizens = citizenCsvProcessor.findAll("test_csv");

        assert citizens.size() == 3;
        assert citizens.get(0).equals(citizenToTest);

        System.out.println(citizens);
    }
}
