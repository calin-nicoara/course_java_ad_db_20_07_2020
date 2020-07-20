package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {

    @Test
    public void testExecutor() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 1000; i++) {
            executorService.execute(new PrimeCalculatorRunnable());
        }

        Thread.sleep(10000);

        executorService.shutdown();
    }

    @Test
    public void testExecturoCachePool() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i < 1000; i++) {
            executorService.execute(new PrimeCalculatorRunnable());
        }

        Thread.sleep(10000);
    }

    @Test
    public void testExecutorWithCallable() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<Long> future = executorService.submit(new PrimeCalculatorCallable(305));
        System.out.println("Main thread");

        Long aLong = future.get();

        System.out.println(aLong);
    }

    @Test
    public void testExecutorWithCallableWihtMultipleFutures() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<Long> future1 = executorService.submit(new PrimeCalculatorCallable(305));
        Future<Long> future2 = executorService.submit(new PrimeCalculatorCallable(508));
        System.out.println("Main thread");

        while(!future1.isDone() || !future2.isDone()) {
            System.out.println(
                    String.format("future1 is %s and future2 is %s",
                            future1.isDone() ? "done": "not done",
                            future2.isDone() ? "done": "not done")
            );
        }

    }
}
