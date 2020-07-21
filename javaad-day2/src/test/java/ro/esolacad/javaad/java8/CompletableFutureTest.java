package ro.esolacad.javaad.java8;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest {

    @Test
    public void firstTest() throws InterruptedException {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    return new Random().nextInt(500);
                })
                .thenApply(a -> a + 1000);

        integerCompletableFuture.thenAccept(x -> System.out.println(x));


        Thread.sleep(2000);
    }

    @Test
    public void testGetNOw() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture
                .supplyAsync(() -> new Random().nextInt(500))
                .thenApply(a -> {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    return a + 1000;
                });

//        Integer integer = integerCompletableFuture.get();
        Integer now = integerCompletableFuture.getNow(0);

        System.out.println(now);
    }

    @Test
    public void testJoinAndComplete() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            completableFuture.complete("Completed Value");
        });

        String join = completableFuture.join();

        System.out.println(join);
    }

    @Test
    public void testComposeFutures() {
        CompletableFuture<String> integerCompletableFuture = CompletableFuture.supplyAsync(() -> 2)
                .thenCompose(currentValue -> CompletableFuture.supplyAsync(() -> currentValue * 3 + " "));

        assert integerCompletableFuture.join().equals("6 ");
    }

    @Test
    public void testCombineFutures() {
        CompletableFuture<String> completableFuture = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println(Thread.currentThread().getName());
                    return "Hello";
                })
                .thenCombineAsync(CompletableFuture.supplyAsync(() -> {
                            System.out.println(Thread.currentThread().getName());
                            return "World!";
                        }),
                        (result1, result2) -> result1 + " " + result2);

        assert "Hello World!".equals(completableFuture.join());
    }

    @Test
    public void testUseExecutor() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        }, executorService);


        Thread.sleep(200);

        CompletableFuture<Object> voidCompletableFuture = CompletableFuture
//                .allOf(
                .anyOf(
                        CompletableFuture.runAsync(() -> {
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Operation 1");
                        }),
                        CompletableFuture.runAsync(() -> {
                            try {
                                Thread.sleep(600);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Operation 2");
                        }),
                        CompletableFuture.runAsync(() -> System.out.println("Operation 3")),
                        CompletableFuture.runAsync(() -> System.out.println("Operation 4"))
                );

        voidCompletableFuture.join();
    }
}
