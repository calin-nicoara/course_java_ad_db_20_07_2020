package ro.esolacad.javaad.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserImmutableTest {

    @Test
    public void testImmut() {
        UserImmutable user = new UserImmutable(1L,"Ionut", "Popescu");
        System.out.println(user);

        UserImmutable user2 = user.setId(10L);

        System.out.println(user);
        System.out.println(user2);
    }
}
