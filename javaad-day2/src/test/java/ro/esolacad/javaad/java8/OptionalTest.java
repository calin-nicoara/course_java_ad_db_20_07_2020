package ro.esolacad.javaad.java8;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import javax.swing.text.html.Option;

public class OptionalTest {

    @Test
    public void testOptional() {
//        Optional<User> userOptional = Optional.of(new User());
//        Optional<User> userOptional = Optional.empty();

        User newuser = new User("Ana", "Coanda");

        Optional<User> userOptional = Optional.ofNullable(newuser);

//        userOptional.get();

        if(userOptional.isPresent()) {
            User user = userOptional.get();

            System.out.println(user);
        } else {
            System.out.println("No user!");
        }
    }

    @Test
    public void testOptionalFunctional() {
        User newuser = new User("Ana", "Coanda");
        Optional<User> userOptional = Optional.ofNullable(null);

//        userOptional.ifPresent(user -> System.out.println(user));

        User user = userOptional.orElseGet(() -> new User("DEfault", "Name"));

        System.out.println(user);
    }
}
