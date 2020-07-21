package ro.esolacad.javaad.java8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTest {

    @Test
    public void testFirstStream() {
        List<Integer> integers = Arrays.asList(12, 65, 23, 65, 234, 76, 100, 23, 555, 37);

        integers.stream()
                .filter(x -> x > 100)
                .map(x -> x * x)
                .forEach(System.out::println);
    }
}
