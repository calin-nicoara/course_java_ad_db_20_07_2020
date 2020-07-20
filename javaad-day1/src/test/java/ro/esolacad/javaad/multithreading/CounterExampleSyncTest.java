package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterExampleSyncTest {

    @Test
    public void testSync() throws InterruptedException {
        CounterExampleSync counterExampleSync = new CounterExampleSync();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int nextInt = counterExampleSync.incrementAndGetNextInt();
                System.out.println(nextInt);
            }
        };

        for(int i = 0; i < 1000; i++) {
            new Thread(runnable).start();
        }

        Thread.sleep(10000);

        System.out.println("----------------------");
        System.out.println("Final value " + counterExampleSync.getNextInt());
    }
}
