package ro.esolacad.javaad.lab;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListNoIndexOutOfBoundsTest {

    @Test
    public void testList() {
        List<Integer> initialList = new ArrayList<>();
        initialList.add(0);
        initialList.add(1);

        ListNoIndexOutOfBounds<Integer> integers = new ListNoIndexOutOfBounds<>(initialList, i -> -1);

        assert integers.get(6) == -1;

        System.out.println(initialList);
//        list.get(5) == 5;
    }

    @Test
    public void testList2() {
        List<Integer> initialList = new ArrayList<>();

        ListNoIndexOutOfBounds<Integer> integers = new ListNoIndexOutOfBounds<>(initialList, i -> i * 2);

        assert integers.get(6) == 12;

        System.out.println(initialList);
//        list.get(5) == 5;
    }
}
