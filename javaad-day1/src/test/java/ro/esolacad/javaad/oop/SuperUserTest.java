package ro.esolacad.javaad.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperUserTest {

    @Test
    public void superUser() {
        SuperUser superUser = new SuperUser();

        superUser.setFirstName("Mihaela");
        superUser.setLastName("Popescu");

        System.out.println(superUser.getName());
    }

    @Test
    public void superUser2() {
        SuperUser superUser = new SuperUser("Bogdan", "solomon", true);

        superUser.setFirstName("Mihaela");
        superUser.setLastName("Popescu");

        System.out.println(superUser.getName());

        System.out.println(superUser.isAdmin());
    }

    @Test
    public void testPoly() {
        User superUser = new SuperUser("Bogdan", "solomon", true);

        superUser.setFirstName("Mihaela");
        superUser.setLastName("Popescu");

        System.out.println(superUser.getName());

//        System.out.println(superUser.isAdmin());
    }

}
