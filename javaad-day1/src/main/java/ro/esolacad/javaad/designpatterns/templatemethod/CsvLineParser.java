package ro.esolacad.javaad.designpatterns.templatemethod;

import java.util.Arrays;
import java.util.List;

public class CsvLineParser extends LineParser{

    @Override
    public List<String> getLinesFromFile(final String header, final String file) {
        System.out.println("Read csv lines");
        return Arrays.asList("csv_line_1", "csv_line_2");
    }

    @Override
    public String getHeader(final String file) {
        System.out.println("Read csv header");
        return "csv_header";
    }
}
