package ro.esolacad.javaad.multithreading;

public class PrimeCalculator {

    private final long minLimit;

    public PrimeCalculator(long minLimit) {
        this.minLimit = minLimit;
    }

    public long getNextPrime() {
        long currentNumber = minLimit;

        while(!isPrime(currentNumber)) {
            currentNumber += 1;
        }

        return currentNumber;
    }

    private boolean isPrime(final long numberToCheck) {
        if(numberToCheck == 2 || numberToCheck == 3) {
            return true;
        }

        if(numberToCheck < 2 || numberToCheck % 2 == 0) {
            return false;
        }

        for(int i = 3; i <= Math.sqrt(numberToCheck); i+=2) {
            if(numberToCheck % i == 0) {
                return false;
            }
        }
        return true;
    }
}
