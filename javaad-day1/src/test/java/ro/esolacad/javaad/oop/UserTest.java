package ro.esolacad.javaad.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void test() {
        User user = new User();

//        user.name = "Gigel";
//
//        System.out.println(user.name);

        user.setFirstName("Gigel");
        user.setLastName("Popescu");


        System.out.println( user.getName());
    }

    @Test
    public void test1() {
        User user = new User("Ionut", "Barbu");

//        user.name = "Gigel";
//
//        System.out.println(user.name);

//        user.setFirstName("Gigel");
//        user.setLastName("Popescu");


        System.out.println( user.getName());
    }
}
