package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

    @Test
    public void testThreadLocal() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Old value " + ThreadIdSetter.getThreadId() +" for thread"
                + Thread.currentThread().getName());
                ThreadIdSetter.setNewValue();
                System.out.println("New value " + ThreadIdSetter.getThreadId() +" for thread"
                        + Thread.currentThread().getName());
            }
        };

        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);


        Thread.sleep(2000);
    }
}
