package ro.esolacad.javaad.java8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediatOpsTest {

    @Test
    public void testIntermediate() {
        List<Integer> integers = Arrays.asList(65, 23, 65, 234, 76, 100, 23, 555, 37, 12, 12);

        integers.stream()
                .filter(x -> x % 2 == 0)
                .filter(x -> x % 5 != 0)
                .map(x -> "Number: " + x)
                .peek(x -> System.out.println("Peek " + x))
//                .distinct()
//                .skip(2)
                .limit(5)
                .sorted()
                .forEach(x -> System.out.println("Consuming data: " + x));
    }

    @Test
    public void testIntermediate2() {
        List<Integer> integers = Arrays.asList(12, 12, 65, 23, 65, 234, 76, 100, 23, 555, 37);

        integers.stream()
                .filter(x -> x % 2 == 0)
                .filter(x -> x % 5 != 0)
                .map(x -> "Number: " + x)
                .peek(x -> System.out.println("Peek " + x))
//                .distinct()
//                .skip(2)
//                .limit(2)
//                .sorted()
                .forEach(x -> System.out.println("Consuming data: " + x));
    }

    @Test
    public void testFlatMap() {
        User user1 = new User("Daniel", "Bode", Arrays.asList(5, 7, 4, 9));
        User user2 = new User("Ana", "Dumitru", Arrays.asList(8, 8, 8, 10));
        User user3 = new User("Marian", "Dobrin", Arrays.asList(2, 3, 4, 5));

        List<User> users = Arrays.asList(user1, user2, user3);

        users.stream()
                .flatMap(user -> user.getReviews().stream())
                .forEach(score -> System.out.println(score));
    }

    @Test
    public void testReuseStream() {
        List<Integer> integers = Arrays.asList(65, 23, 65, 234, 76, 100, 23, 555, 37, 12, 12);

        Supplier<Stream<String>> sorted = () -> integers.stream()
                .filter(x -> x % 2 == 0)
                .filter(x -> x % 5 != 0)
                .map(x -> "Number: " + x)
                .peek(x -> System.out.println("Peek " + x))
//                .distinct()
//                .skip(2)
                .limit(5)
                .sorted();

        // Stream can only be operated upon once
        sorted.get().forEach(x -> System.out.println(x));
        sorted.get().forEach(x -> System.out.println(x));
    }

    @Test
    public void testSomething() {
        List<Integer> collect = Stream.iterate(0, x -> x + 10)
//                .parallel()
                .filter(x -> x % 3 != 0)
                .map(x -> x / 3)
                .limit(1000000)
//                .sorted()
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
