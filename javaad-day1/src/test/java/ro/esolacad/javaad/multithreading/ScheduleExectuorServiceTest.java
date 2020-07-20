package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

public class ScheduleExectuorServiceTest {

    @Test
    public void testScheduledExecutor() throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        ScheduledFuture<Long> schedulFuture = scheduledExecutorService.schedule(new PrimeCalculatorCallable(450),
                2, TimeUnit.SECONDS);

        System.out.println(schedulFuture.get());
    }

    @Test
    public void testPeriodicExecution() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        Runnable command = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println("Random number: " + new Random().nextInt(100));
            }
        };
        scheduledExecutorService.scheduleAtFixedRate(command,
                1, 2, TimeUnit.SECONDS);

        Thread.sleep(15000);
    }

    @Test
    public void testPeriodicExecutionWithDelay() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        Runnable command = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println("Random number: " + new Random().nextInt(100));
            }
        };
        scheduledExecutorService.scheduleWithFixedDelay(command,
                1, 2, TimeUnit.SECONDS);

        Thread.sleep(15000);
    }
}
