package ro.esolacad.javaad.designpatterns.templatemethod;

import java.util.Arrays;
import java.util.List;

public class ExcelLineParser extends LineParser{

    @Override
    protected String readFile(final String filePath) {
        System.out.println("Read excel file");
        return "file";
    }

    @Override
    protected List<String> getLinesFromFile(final String header, final String file) {
        System.out.println("Read excel lines");
        return Arrays.asList("excel_line_1", "excel_line_2");
    }

    @Override
    protected String getHeader(final String file) {
        System.out.println("Read excel header");
        return "excel_header";
    }
}
