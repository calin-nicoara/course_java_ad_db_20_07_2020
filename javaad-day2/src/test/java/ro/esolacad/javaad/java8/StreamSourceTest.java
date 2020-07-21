package ro.esolacad.javaad.java8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class StreamSourceTest {

    @Test
    public void testSourceStream() {
        Stream.of(1, 2, 3, 4, 5).forEach(System.out::println);

        Arrays.stream(new int[] {6, 7, 8, 9}).forEach(System.out::println);
    }

    @Test
    public void testGenerateStream() {
        final AtomicInteger atomicInteger = new AtomicInteger(0);

        Stream.generate(() -> "test: " + atomicInteger.incrementAndGet())
                .limit(1000)
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void testIterateStream() {
        Stream.iterate(0, x -> x + 2)
                .limit(100)
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void testStream() {
        Stream.concat(Stream.of(1, 2, 3), Stream.of(4, 5, 6)).forEach(x -> System.out.println(x));
    }
}
