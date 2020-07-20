package ro.esolacad.javaad.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

import ro.esolacad.javaad.oop.SuperUser;
import ro.esolacad.javaad.oop.User;

public class CollectionTests {

    @Test
    public void test() {
        int[] emptyArray = new int[10];
        int[] numbers = new int[] {1, 2, 3, 4, 5};

        System.out.println(numbers[0]);
        System.out.println(numbers[4]);

        numbers[2] = 10;
//        numbers[2] = "hello";

        System.out.println(numbers[2]);

        numbers[5] = 3;
    }

    @Test
    public void testList() {
        List list = new ArrayList();

        list.add(1);
        list.add(2);

        list.add("222");

        Object o = list.get(2);

        System.out.println(list.get(0));
    }

    @Test
    public void testGenericList() {
        List<String> strings = new ArrayList<>();

        strings.add("hello there");
        strings.add("hi");

        String s = strings.get(0);

        System.out.println(s);

        System.out.println(strings);
    }

    @Test
    public void testNumberList() {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        System.out.println(numbers);

        Integer number = 4;

        System.out.println(number + 5);

        numbers.remove(1);
    }

    @Test
    public void testArrayList() {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        List<Integer> subList = numbers.subList(0, 1);



        System.out.println(subList);

        numbers.set(0,10);

        System.out.println(subList);

        System.out.println(Integer.parseInt("1111"));
    }

    @Test
    public void testSet() {
        Set<Integer> numberSet = new HashSet<>();

        numberSet.add(1);
        numberSet.add(2);
        numberSet.add(3);

        System.out.println(numberSet);

        System.out.println(numberSet.contains(2));
    }

    @Test
    public void testSetUser() {
        Collection<User> userSet = new HashSet<>();

        User user1 = new User("Ionut", "Popescu");
        User userDup = new User("Ionut", "Popescu");
        User user2 = new User("Ana", "Iordache");

//        System.out.println(user1 == user1);
//        System.out.println(user1.equals(userDup));

        userSet.add(user1);

        user1.setLastName("Brancusi");
        userSet.add(user1);
        userSet.add(user2);

//        userSet.add(userDup);

        System.out.println(userSet);
    }

    @Test
    public void tesIt() {
        Set<Integer> numberSet = new HashSet<>();

        numberSet.add(1);
        numberSet.add(2);
        numberSet.add(3);

        for(Integer number: numberSet) {
            System.out.println(number);
        }

    }

    @Test
    public void testGenericInheritance() {
        Box<? extends User> boxUser = new Box<SuperUser>();

        User object = boxUser.getObject();
    }

    @Test
    public void testMap() {
        Map<Long, User> userMap = new HashMap<>();

        User user1 = new User("Ionut", "Popescu");
        user1.setId(1L);
        User user2 = new User("Ana", "Iordache");
        user2.setId(2L);

        userMap.put(1L,user1);
        userMap.put(2L, user2);

//        System.out.println(userMap.get(1L));

        userMap.put(1L, null);

//        System.out.println(userMap.get(1L));

        userMap.put(null, user1);

        System.out.println(userMap.get(null));
    }

    @Test
    public void testCollections() {
        List<String> stringList = Collections.singletonList("Oneelement");

//        stringList.add("another");

        List<Integer> numberSet = new ArrayList<>();

        numberSet.add(1);
        numberSet.add(2);
        numberSet.add(3);
        numberSet.add(-1);
        numberSet.add(-2);

        Collections.sort(numberSet);

        System.out.println(numberSet);
    }

    @Test
    public void testArrays() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

//        System.out.println(integers);

        int[] numbers = new int[] {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(numbers));
    }

    @Test
    public void testImmutable() {
        List<Integer> numberList = new ArrayList<>();

        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(-1);
        numberList.add(-2);

        List<Integer> integers = Collections.unmodifiableList(numberList);

        numberList.add(10);
        integers.add(10);
    }
}
