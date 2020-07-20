package ro.esolacad.javaad.multithreading;

public class PrimeThreadCalculator extends Thread{

    @Override
    public void run() {
        PrimeCalculator primeCalculator = new PrimeCalculator(1000);
        System.out.println(Thread.currentThread().getName());

        System.out.println(primeCalculator.getNextPrime());
    }
}
