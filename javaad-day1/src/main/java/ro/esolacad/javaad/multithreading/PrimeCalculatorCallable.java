package ro.esolacad.javaad.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;

public class PrimeCalculatorCallable implements Callable<Long> {

    private final long minLimit;

    public PrimeCalculatorCallable(final long minLimit) {
        this.minLimit = minLimit;
    }


    @Override
    public Long call() throws Exception {
        Thread.sleep(new Random().nextInt(200));
        System.out.println(Thread.currentThread().getName());
        PrimeCalculator primeCalculator = new PrimeCalculator(minLimit);

        return primeCalculator.getNextPrime();
    }
}
