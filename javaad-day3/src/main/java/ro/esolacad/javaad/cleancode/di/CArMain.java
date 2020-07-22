package ro.esolacad.javaad.cleancode.di;

public class CArMain {

    public static void main(String[] args) {
        Motor motor = new NormalMotor();

        Car car = new Car(motor);
    }
}
