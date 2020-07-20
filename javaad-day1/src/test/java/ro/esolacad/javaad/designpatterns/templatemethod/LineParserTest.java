package ro.esolacad.javaad.designpatterns.templatemethod;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineParserTest {

    @Test
    public void lineParser() {
//        LineParser lineParser = new CsvLineParser();
        LineParser lineParser = new ExcelLineParser();

        List<String> path = lineParser.getLines("path");

        System.out.println(path);
    }
}
