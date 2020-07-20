package ro.esolacad.javaad.multithreading;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PrimeThreadCalculatorTest {

    @Test
    public void testFirstThread() {
        PrimeThreadCalculator primeThreadCalculator = new PrimeThreadCalculator();

        System.out.println(Thread.currentThread().getName());
        primeThreadCalculator.start();
        System.out.println("Hello from main thread!");
    }

    @Test
    public void testRunnable() {
        System.out.println(Thread.currentThread().getName());
        Runnable runnable = new PrimeCalculatorRunnable();

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        Thread thread = new Thread(runnable);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJoin() throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                PrimeCalculator primeCalculator = new PrimeCalculator(1000);
                System.out.println(Thread.currentThread().getName());

                System.out.println(primeCalculator.getNextPrime());
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();

        thread.join();

        System.out.println("Main thread");


        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
