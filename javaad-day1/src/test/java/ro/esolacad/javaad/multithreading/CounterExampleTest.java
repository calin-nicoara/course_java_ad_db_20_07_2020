package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

class CounterExampleTest {

    @Test
    public void testCounter() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
//                int nextInt = CounterExample.incrementAndGetNextInt();
                int nextInt = CounterExample.incrementAndGetAtomicNextInt();
                System.out.println(nextInt);
            }
        };

        for(int i = 0; i < 1000; i++) {
            new Thread(runnable).start();
        }

        Thread.sleep(1000);

        System.out.println("----------------------");
//        System.out.println("Final value " + CounterExample.getNextInt());
        System.out.println("Final value " + CounterExample.getAtomicNextInt());
    }

}
