package ro.esolacad.javaad.designpatterns.templatemethod;

import java.util.Arrays;
import java.util.List;

public abstract class LineParser {

    public final List<String> getLines(String filePath) {
        String file = readFile(filePath);

        String header = getHeader(file);

        return getLinesFromFile(header, file);
    }

    protected String readFile(final String filePath) {
        System.out.println("Read file");
        return "file";
    }

    protected abstract List<String> getLinesFromFile(final String header, final String file);

    protected abstract String getHeader(final String file);
}
