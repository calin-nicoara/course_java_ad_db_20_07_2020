package ro.esolacad.javaad.multithreading;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterExample {

    private static int nextInt = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static int incrementAndGetNextInt() {
        int sleep = new Random().nextInt(200);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        nextInt = nextInt + 1;
        return nextInt;
    }

    public static int getNextInt() {
        return nextInt;
    }

    public static int incrementAndGetAtomicNextInt() {
        int sleep = new Random().nextInt(200);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return atomicInteger.incrementAndGet();
    }

    public static int getAtomicNextInt() {
        return atomicInteger.get();
    }
}
