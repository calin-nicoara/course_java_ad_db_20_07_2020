package ro.esolacad.javaad.csvlab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvProcessor {

    public static <T> List<T> findAll(String filePath,
                                      Function<String[], T> rowMapper) throws IOException {
         return Files
                .readAllLines(Paths.get(filePath))
                .stream()
                .map(line -> line.split(","))
                .map(rowMapper)
                .collect(Collectors.toList());
    }
}
