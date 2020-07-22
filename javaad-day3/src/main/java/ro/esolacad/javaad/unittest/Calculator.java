package ro.esolacad.javaad.unittest;

public class Calculator {

    public int calculate(int first, int second) {
        if(first % 2 == 0) {
            return (first + second) * 2;
        } else if(second > 20) {
            return second - first + 10;
        } else {
            return first + second;
        }
    }
}
