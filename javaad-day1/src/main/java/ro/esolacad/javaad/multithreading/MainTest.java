package ro.esolacad.javaad.multithreading;

public class MainTest {

    public static void main(String[] args) {
        System.out.println("aaaa");
        System.out.println("aaaa");
        System.out.println("aaaa");
        System.out.println("aaaa");

        PrimeThreadCalculator primeThreadCalculator = new PrimeThreadCalculator();
        primeThreadCalculator.start();
    }
}
