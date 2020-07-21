package ro.esolacad.javaad.java8;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesTest {

    @Test
    public void testConsumer() {
        Consumer<String> testConsumer = testString -> System.out.println(testString.toUpperCase());

        testConsumer.accept("howdy!");
    }

    @Test
    public void testSupplier() {
        Supplier<User> userSupplier = () -> new User("Bogdan", "Munteanu");

        User user = userSupplier.get();

        System.out.println(user);

        User user1 = userSupplier.get();

        assert user != user1;
    }

    @Test
    public void testFunction() {
        Function<String, Integer> characterCounter = inputString -> inputString.length();

        assert 6 == characterCounter.apply("Hello!");
    }

    @Test
    public void testPredicate() {
        Predicate<Integer> checkEven = number -> number % 2 == 0;

        assert checkEven.test(10);
        assert !checkEven.test(11);
    }

    @Test
    public void testDefaultMethods() {
        Consumer<String> testConsumer = testString -> System.out.println(testString);

        Consumer<String> stringConsumer = testConsumer.andThen(testString -> System.out.println("Another one: " + testString.toUpperCase()));

        stringConsumer.accept("hello there!");

        Predicate<Integer> isEven = x -> x % 2 == 0;

        assert isEven.test(10);
        assert !isEven.negate().test(10);

        Function<Integer, Integer> doubleFunc = x -> x *2;

//        doubleFunc.compose(result -> result * 10);


    }
}







