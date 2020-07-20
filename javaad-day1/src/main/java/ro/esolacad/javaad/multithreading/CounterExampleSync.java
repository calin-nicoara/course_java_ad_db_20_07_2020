package ro.esolacad.javaad.multithreading;

import java.util.Random;

public class CounterExampleSync {
    private int nextInt = 0;

    public synchronized int incrementAndGetNextInt() {
        int sleep = new Random().nextInt(200);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        nextInt = nextInt + 1;
        return nextInt;
    }

    public int getNextInt() {
        return nextInt;
    }
}
