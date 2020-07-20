package ro.esolacad.javaad.multithreading;

import java.util.Random;

public class PrimeCalculatorRunnable implements Runnable{
    @Override
    public void run() {
        int i = new Random().nextInt(10000);
//
//        if(i % 2 == 0) {
//            System.out.println("Time for sleep:" +Thread.currentThread().getName() );
            try {
                Thread.sleep(new Random().nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }

        PrimeCalculator primeCalculator = new PrimeCalculator(1000);
        System.out.println(Thread.currentThread().getName());

        System.out.println(primeCalculator.getNextPrime());
    }
}
