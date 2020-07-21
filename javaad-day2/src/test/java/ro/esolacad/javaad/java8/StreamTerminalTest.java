package ro.esolacad.javaad.java8;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminalTest {

    @Test
    public void testCollect() {
        List<User> users = getUsers();

        Supplier<Stream<Integer>> streamSupplier = () -> users.stream()
                .filter(x -> x.getLastName().equals("Dumitru"))
                //                .map(x -> x.getReviews())
                .flatMap(x -> x.getReviews().stream());

        List<Integer> scores = streamSupplier.get()
                .collect(Collectors.toList());

        System.out.println(scores);

        Set<Integer> collect = streamSupplier.get()
                .collect(Collectors.toSet());

        System.out.println("Set:" + collect);
    }

    @Test
    public void testCollectMap() {
        Map<Long, String> stringMap = getUsers().stream()
                .collect(Collectors.toMap(User::getId, User::getLastName));

        System.out.println(stringMap);

        Map<Long, User> userMap = getUsers().stream()
                .collect(Collectors.toMap(User::getId, user -> user));

        System.out.println(userMap);
    }

    @Test
    public void testCollectGroupingBy() {
        Map<Boolean, List<User>> grouped = getUsers().stream()
                .collect(Collectors.groupingBy(user -> user.getAdmin()));

        System.out.println(grouped);

        Map<String, List<User>> grouped2 = getUsers().stream()
                .collect(Collectors.groupingBy(user -> user.getLastName()));

        System.out.println();
        System.out.println();
        System.out.println(grouped2);
    }

    @Test
    public void testCollectPartitionBy() {
        Map<Boolean, List<User>> grouped = getUsers().stream()
                .collect(Collectors.partitioningBy(user -> user.getAdmin()));

        System.out.println(grouped);
    }

    @Test
    public void testMatchers() {
        List<User> users = getUsers();

        boolean daniel = users.stream()
                .filter(user -> user.getAdmin())
                .anyMatch(user -> user.getFirstName().equals("Daniel"));

        System.out.println(daniel);

        boolean allMatch = users.stream().allMatch(user -> user.getAdmin());
        System.out.println(allMatch);

        boolean noneMatch = users.stream().noneMatch(user -> user.getAdmin());
        System.out.println(noneMatch);
    }

    @Test
    public void testFind() {
        Optional<User> findAny = getUsers()
                .stream()
                .filter(x -> x.getLastName().length() > 5)
                .findFirst();
//                .findAny();

        System.out.println(findAny);
    }

    @Test
    public void testStreamReduce() {
        Integer reduce = getUsers()
                .stream()
                .flatMap(user -> user.getReviews().stream())
                .reduce(0, (accum, current) -> {
                    System.out.println("Accum: " + accum);
                    System.out.println("Current: " + current);
                    return accum + current;
                });

        System.out.println(reduce);
    }

    private List<User> getUsers() {
        User user1 = new User("Daniel", "Bode", Arrays.asList(5, 7, 4, 9), true);
        user1.setId(1L);
        User user2 = new User("Ana", "Dumitru", Arrays.asList(8, 8, 8, 10), false);
        user2.setId(2L);
        User user4 = new User("Laurentiu", "Dumitru", Arrays.asList(3, 3, 5, 5), true);
        user4.setId(4L);
        User user3 = new User("Marian", "Dobrin", Arrays.asList(2, 3, 4, 5), true);
        user3.setId(3L);

        return Arrays.asList(user1, user2, user3, user4);
    }
}
