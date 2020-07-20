package ro.esolacad.javaad.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    @Test
    public void testBox() {
        Box box = new Box();

        box.setObject("My Object");

        System.out.println(box.getObject());
    }

    @Test
    public void testGenericBox() {
        Box<String> box = new Box<>();

        box.setObject("My Object");

        System.out.println(box.getObject());
    }
}
