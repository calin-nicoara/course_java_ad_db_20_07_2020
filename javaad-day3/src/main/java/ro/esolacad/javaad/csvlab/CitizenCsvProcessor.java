package ro.esolacad.javaad.csvlab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CitizenCsvProcessor {
    public void writeCitizens(final String filePath, final List<Citizen> citizens) {
        List<String> csvRows = citizens
                .stream()
                .map(this::getFieldsFromCitizen)
                .map(rowFields -> String.join(",", rowFields))
                .collect(Collectors.toList());

        try {
            Files.write(Paths.get(filePath),csvRows);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File could not be written!");
        }
    }

    private List<String> getFieldsFromCitizen(final Citizen citizen) {
        List<String> citizensFields = new ArrayList<>();
        citizensFields.add(citizen.getId().toString());
        citizensFields.add(citizen.getName());
        citizensFields.add(citizen.getDateOfBirth().toString());
        citizensFields.add(Boolean.toString(citizen.isForeigner()));

        return citizensFields;
    }

    public void writeCitizensWithReflection(final String filePath, final List<Citizen> citizens) {
        List<String> csvRows = citizens
                .stream()
                .map(this::getFieldFromObject)
                .map(rowFields -> String.join(",", rowFields))
                .collect(Collectors.toList());

        try {
            Files.write(Paths.get(filePath),csvRows);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File could not be written!");
        }
    }

    private List<String> getFieldFromObject(final Object object) {
        return Stream.of(object.getClass().getDeclaredFields())
                .map(field -> {
                    field.setAccessible(true);
                    try {
                        return field.get(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    return "";
                }).map(Objects::toString)
                .collect(Collectors.toList());
    }


    public List<Citizen> findAll(String filePath) throws IOException {
        Function<String[], Citizen> citizenRowMapper = csvRow -> {
            Citizen citizen = new Citizen();
            citizen.setId(Long.parseLong(csvRow[0]));
            citizen.setName(csvRow[1]);
            citizen.setDateOfBirth(LocalDate.parse(csvRow[2]));
            citizen.setForeigner(Boolean.parseBoolean(csvRow[3]));

            return citizen;
        };

        return CsvProcessor.findAll(filePath, citizenRowMapper);
    }
}
